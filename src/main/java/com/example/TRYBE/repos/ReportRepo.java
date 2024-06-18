package com.example.TRYBE.repos;

import com.example.TRYBE.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {
    Report findByUserIdAndReportId(Long userId, Long reportId);

    List<Report> findByUserIdOrderBySubmitDateDesc(Long userId);
}
