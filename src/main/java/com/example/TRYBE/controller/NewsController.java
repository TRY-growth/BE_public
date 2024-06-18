package com.example.TRYBE.controller;

import com.example.TRYBE.Prompts;
import com.example.TRYBE.entities.Report;
import com.example.TRYBE.entities.News;
import com.example.TRYBE.models.ChatCompletionRequest;
import com.example.TRYBE.models.ChatCompletionResponse;
import com.example.TRYBE.services.NewsService;
import com.example.TRYBE.services.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/news")
@Tag(name = "02", description = "News APIs")
public class NewsController {

    private final NewsService newsService;
    private final ReportService reportService;
    private final Prompts prompts;

    @Autowired
    public NewsController(NewsService newsService, ReportService reportService, Prompts prompts) {
        this.newsService = newsService;
        this.reportService = reportService;
        this.prompts = prompts;
    }

    @Autowired
    RestTemplate restTemplate;

//    @GetMapping("/test")
//    public String test() {
//        return "NewsController works!";
//    }

    @GetMapping("")
    @Operation(summary = "모든 NEWS 조회")
    public ResponseEntity<List<News>> getAllNews() {
        List<News> allNews = newsService.findAllNews();

        if (allNews != null) {
            return new ResponseEntity<>(allNews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

//    @Deprecated
//    @GetMapping("/{newsId}")
//    @Operation(summary = "newsId로 특정 NEWS 조회 -> 모든 NEWS 조회에서 이미 필요한 정보를 제공하므로 사용하지 않음")
//    public ResponseEntity<News> getNewsByNewsId(@PathVariable Long newsId) {
//        News news = newsService.findByNewsId(newsId);
//
//        if (news != null) {
//            return new ResponseEntity<>(news, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/{newsId}/question")
    @Operation(summary = "뉴스 기반 질문 생성 후 Report에 저장")
    public ResponseEntity<Report> createNewsQuestion(@PathVariable Long newsId) {
        News news = newsService.findByNewsId(newsId);
        String newsArticle = news.getNewsArticle();

        // 새로운 Report 생성
        Report report = new Report();
        report.setTaskId(newsId.toString());
        report.setTaskType("news");

        // GPT에게 질문 생성 요청
        String prompt = "Article Prompt: " + newsArticle + prompts.GPTGeneratedQuestionsPrompt;
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-4o", prompt);
        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions", chatCompletionRequest, ChatCompletionResponse.class);

        String gptGeneratedQuestionText = response.getChoices().get(0).getMessage().getContent();
        if (gptGeneratedQuestionText != null) {
            report.setNewsQuestion(gptGeneratedQuestionText);
            reportService.save(report);
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}