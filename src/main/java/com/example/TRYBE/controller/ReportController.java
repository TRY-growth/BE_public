package com.example.TRYBE.controller;

import com.example.TRYBE.entities.Report;
import com.example.TRYBE.services.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "00", description = "User APIs")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{userId}/reports")
    @Operation(summary = "userId로 모든 학습 이력 조회 (최신순 정렬)")
    public ResponseEntity<List<Report>> getSubmissionsByUserId(@PathVariable Long userId) {
        List<Report> submissions = reportService.findByUserId(userId);
        if (submissions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

//    @Deprecated
//    @GetMapping("/{userId}/reports/{reportId}")
//    @Operation(summary = "userId와 reportId로 특정 학습 이력 상세 조회 -> 전체 이력 조회에서 이미 필요한 정보를 제공하므로 사용하지 않음")
//    public ResponseEntity<Report> getSubmissionById(@PathVariable Long userId, @PathVariable Long reportId) {
//        Report submission = reportService.findByUserIdAndReportId(userId, reportId);
//        if (submission == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(submission, HttpStatus.OK);
//    }
}