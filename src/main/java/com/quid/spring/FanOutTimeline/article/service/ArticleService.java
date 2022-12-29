package com.quid.spring.FanOutTimeline.article.service;

import com.quid.spring.FanOutTimeline.article.Article;
import com.quid.spring.FanOutTimeline.article.model.ArticleRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface ArticleService permits ArticleServiceImpl {

    void createArticle(ArticleRequestDto articleRequestDto);

    void deleteArticle(Long id);

    Page<Article> getArticle(Long memberId, Pageable pageable);
}
