package com.quid.spring.FanOutTimeline.article.repository;

import com.quid.spring.FanOutTimeline.article.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<Article, Long> {

    Page<Article> findByMemberId(Long memberId, Pageable pageable);
}
