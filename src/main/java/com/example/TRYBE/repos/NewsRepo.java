package com.example.TRYBE.repos;

import com.example.TRYBE.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Long> {
    // 눌렀을 때 특정 뉴스 보기 기능
    // Id로 뉴스 불러오기
    News findByNewsId(Long newsId);
}
