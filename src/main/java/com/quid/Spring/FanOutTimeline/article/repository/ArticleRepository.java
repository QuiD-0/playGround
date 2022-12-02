package com.quid.Spring.FanOutTimeline.article.repository;

import com.quid.Spring.FanOutTimeline.article.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface ArticleRepository permits ArticleRepositoryImpl {


    Article save(Article article);

    void deleteById(Long id);

    Page<Article> findByMemberId(Long memberId, Pageable pageable);
}
