package com.example.TRYBE.services;

import com.example.TRYBE.entities.News;
import com.example.TRYBE.repos.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepo newsRepo;

    @Autowired
    public NewsService(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    // 화면에 List 형태로 모든 뉴스 조회
    public List<News> findAllNews() {
        return newsRepo.findAll();
    }

    // 특정 뉴스를 눌렀을 때 newsId로 뉴스 내용 불러오기
    public News findByNewsId(Long newsId) {
        return newsRepo.findByNewsId(newsId);
    }
}