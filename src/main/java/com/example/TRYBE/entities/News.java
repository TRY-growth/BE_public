package com.example.TRYBE.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    //뉴스 제목
    private String newsTitle;

    //뉴스 카테고리
    private String newsCategory;

    //뉴스 기자
    private String newsReporter;

    //뉴스 날짜
    private Date newsDate;

    //뉴스 image URL
    private URL newsURL;

    //뉴스 텍스트
    @Column(columnDefinition = "LONGTEXT")
    private String newsArticle ;
}