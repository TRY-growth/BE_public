package com.example.TRYBE.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private Long userId;
    private String taskId;
    private String taskType; // task1, task2, task3, task4, news

    @Column(columnDefinition = "LONGTEXT")
    private String submitAnswer;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime submitDate;

    @Column(columnDefinition = "LONGTEXT")
    private String submitMemo;

    @Column(columnDefinition = "LONGTEXT")
    private String submitRecording;

    @Column(columnDefinition = "LONGTEXT")
    private String totalFeedback;

    @Column(columnDefinition = "LONGTEXT")
    private String detailFeedback;

    @Column(columnDefinition = "LONGTEXT")
    private String detailFeedbackModifiedAnswer;

    @Column(columnDefinition = "LONGTEXT")
    private String newsQuestion;
}
