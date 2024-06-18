package com.example.TRYBE.services;

import com.example.TRYBE.entities.Report;
import com.example.TRYBE.repos.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepo reportRepo;

    @Autowired
    public ReportService(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    public List<Report> findByUserId(Long userId) {
        return reportRepo.findByUserIdOrderBySubmitDateDesc(userId);
    }

    public Report findByUserIdAndReportId(Long userId, Long reportId) {
        return reportRepo.findByUserIdAndReportId(userId, reportId);
    }

    public Report findByReportId(Long reportId) {
        return reportRepo.findById(reportId).orElse(null);
    }

    public Report save(Report report) {
        return reportRepo.save(report);
    }
}