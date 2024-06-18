package com.example.TRYBE.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task3 {
    @Id
    private String taskId;

    @Column(columnDefinition = "LONGTEXT")
    private String passage;

    @Column(columnDefinition = "LONGTEXT")
    private String discussion;

    @Column(columnDefinition = "LONGTEXT")
    private String question;

    @Column(columnDefinition = "LONGTEXT")
    private String modelAnswer;
}
