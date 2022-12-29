package com.quid.spring.FanOutTimeline.article.model;

import com.quid.spring.FanOutTimeline.article.Article;

public record ArticleRequestDto(String title, String content, Long memberId) {

    public Article toEntity() {
        return Article.builder()
            .title(title)
            .content(content)
            .memberId(memberId)
            .build();
    }
}
