package com.quid.Spring.FanOutTimeline.article.model;

import com.quid.Spring.FanOutTimeline.article.Article;

public record ArticleRequestDto(String title, String content, Long memberId) {

    public Article toEntity() {
        return Article.builder()
            .title(title)
            .content(content)
            .memberId(memberId)
            .build();
    }
}
