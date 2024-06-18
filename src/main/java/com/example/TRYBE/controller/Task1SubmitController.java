package com.example.TRYBE.controller;

import com.example.TRYBE.Prompts;
import com.example.TRYBE.entities.Report;
import com.example.TRYBE.entities.Task1;
import com.example.TRYBE.models.ChatCompletionRequest;
import com.example.TRYBE.models.ChatCompletionResponse;
import com.example.TRYBE.models.JsonValidator;
import com.example.TRYBE.models.ResponseCleaner;
import com.example.TRYBE.repos.Task1Repo;
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
@RequestMapping("/task/1")
@Tag(name = "01")
public class Task1SubmitController {
    private final ReportService reportService;
    private final Task1Repo task1Repo;
    private final Prompts prompts;

    @Autowired
    public Task1SubmitController(ReportService reportService, Task1Repo task1Repo, Prompts prompts) {
        this.reportService = reportService;
        this.task1Repo = task1Repo;
        this.prompts = prompts;
    }

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/{taskId}/response")
    @Operation(summary = "Task1 제출 후 통합/상세 피드백 받기")
    public ResponseEntity<Report> submitTask1(@PathVariable String taskId, @RequestBody String submitAnswer) {
        Task1 task1 = task1Repo.findByTaskId(taskId);
        String question = task1.getQuestion();

        // Report에 User 답변 저장
        Report report = new Report();
        report.setTaskId(taskId);
        report.setTaskType("task1");
        report.setSubmitAnswer(submitAnswer);
        report.setUserId(1L); // 실제 User ID로 변경 필요
        report.setSubmitDate(LocalDateTime.now());
        reportService.save(report);

        // 문제 + 사용자 답안 + 프롬프트 -> 전체 점수 얻기
        String promptForTotalFeedback = "task 1 question: " + question + " task 1 user Answer: " + submitAnswer + prompts.task1TotalFeedback;
        ChatCompletionRequest chatCompletionRequest1 = new ChatCompletionRequest("gpt-4o", promptForTotalFeedback);

        // 사용자 답안 + 프롬프트 -> 모범 답안 얻기
        String promptForModifiedAnswer = prompts.task1GetModifiedAnswerFromGpt + " user answer: " + submitAnswer;
        ChatCompletionRequest chatCompletionRequest2 = new ChatCompletionRequest("gpt-4o", promptForModifiedAnswer);

        // CompletableFuture를 사용하여 두 API 호출을 병렬적으로 수행
        CompletableFuture<ChatCompletionResponse> responseFuture1 = CompletableFuture.supplyAsync(() ->
                restTemplate.postForObject("https://api.openai.com/v1/chat/completions", chatCompletionRequest1, ChatCompletionResponse.class));

        CompletableFuture<ChatCompletionResponse> responseFuture2 = CompletableFuture.supplyAsync(() ->
                restTemplate.postForObject("https://api.openai.com/v1/chat/completions", chatCompletionRequest2, ChatCompletionResponse.class));

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
            String promptForDiffChecker = prompts.getDifferenceFromGpt + "<before>\n " + submitAnswer + "<after>\n " + modifiedAnswerFromGpt;
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
