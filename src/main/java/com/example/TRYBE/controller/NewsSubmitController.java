package com.example.TRYBE.controller;

import com.example.TRYBE.Prompts;
import com.example.TRYBE.entities.Report;
import com.example.TRYBE.entities.News;
import com.example.TRYBE.models.ChatCompletionRequest;
import com.example.TRYBE.models.ChatCompletionResponse;
import com.example.TRYBE.models.JsonValidator;
import com.example.TRYBE.models.ResponseCleaner;
import com.example.TRYBE.services.NewsService;
import com.example.TRYBE.services.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/news")
@Tag(name = "02", description = "News APIs")
public class NewsSubmitController {

    private final ReportService reportService;
    private final NewsService newsService;
    private final Prompts prompts;

    @Autowired
    public NewsSubmitController(ReportService reportService, NewsService newsService, Prompts prompts) {
        this.reportService = reportService;
        this.newsService = newsService;
        this.prompts = prompts;
    }

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/{reportId}/response")
    @Operation(summary = "사용자 답변 제출 후 생성된 피드백을 해당 reportId에 업데이트")
    public ResponseEntity<Report> sendUserAnswerToGPT(@PathVariable Long reportId, @RequestBody String userAnswer) {
        Report report = reportService.findByReportId(reportId);
        News news = newsService.findByNewsId(Long.parseLong(report.getTaskId()));
        String newsArticle = news.getNewsArticle();
        String newsQuestion = report.getNewsQuestion();

        report.setSubmitAnswer(userAnswer);
        report.setSubmitDate(LocalDateTime.now());
        report.setUserId(1L); // 임시 userId 설정, 실제 사용자 ID로 변경 필요

        String promptForTotalFeedback = prompts.newsGetFeedbackPrompt
                + "News Article: " + newsArticle
                + "News Question: " + newsQuestion
                + "User Answer: " + userAnswer;

        String promptForModifiedAnswer = prompts.newsGetModifiedAnswerFromGpt
                + "News Article: " + newsArticle
                + "News Question: " + newsQuestion
                + "User Answer: " + userAnswer;

        // CompletableFuture를 사용하여 두 API 호출을 병렬적으로 수행
        CompletableFuture<ChatCompletionResponse> responseFuture1 = CompletableFuture.supplyAsync(() ->
                restTemplate.postForObject("https://api.openai.com/v1/chat/completions", new ChatCompletionRequest("gpt-4o", promptForTotalFeedback), ChatCompletionResponse.class));

        CompletableFuture<ChatCompletionResponse> responseFuture2 = CompletableFuture.supplyAsync(() ->
                restTemplate.postForObject("https://api.openai.com/v1/chat/completions", new ChatCompletionRequest("gpt-4o", promptForModifiedAnswer), ChatCompletionResponse.class));

        String totalFeedbackByGpt;
        try {
            // 두 응답이 모두 완료될 때까지 기다림
            ChatCompletionResponse response1 = responseFuture1.get();
            ChatCompletionResponse response2 = responseFuture2.get();

            // GPT에게 받은 total feedback을 정리
            totalFeedbackByGpt = ResponseCleaner.cleanGptResponse(response1.getChoices().get(0).getMessage().getContent());
            report.setTotalFeedback(totalFeedbackByGpt);

            // GPT에게 받은 수정된 답안
            String modifiedAnswerFromGpt = response2.getChoices().get(0).getMessage().getContent();
            report.setDetailFeedbackModifiedAnswer(modifiedAnswerFromGpt);

            // 사용자 답안 + 모범 답안 + 프롬프트 -> json 형태로 diff checker
            String promptForDiffChecker = prompts.getDifferenceFromGpt + "<before>\n " + userAnswer + "<after>\n " + modifiedAnswerFromGpt;
            ChatCompletionRequest chatCompletionRequest3 = new ChatCompletionRequest("gpt-4o", promptForDiffChecker);
            ChatCompletionResponse response3 = restTemplate.postForObject("https://api.openai.com/v1/chat/completions", chatCompletionRequest3, ChatCompletionResponse.class);

            // GPT에게 받은 json 형태의 diff checker를 정리
            String diffChecker = ResponseCleaner.cleanGptResponse(response3.getChoices().get(0).getMessage().getContent());
            report.setDetailFeedback(diffChecker);

            // repo에 save
            reportService.save(report);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // json validation
        if (JsonValidator.isValidJson(totalFeedbackByGpt) && JsonValidator.isValidJson(report.getDetailFeedback())) {
            reportService.save(report);
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
