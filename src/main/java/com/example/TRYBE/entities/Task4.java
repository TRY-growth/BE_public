package com.example.TRYBE.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//task 4는 교수 렉처 + 문제 밖에 없음

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task4 {
    @Id
    private String taskId;

    @Column(columnDefinition = "LONGTEXT")
    private String lecture;


    @Column(columnDefinition = "LONGTEXT")
    private String question;

    @Column(columnDefinition = "LONGTEXT")
    private String modelAnswer;
}
