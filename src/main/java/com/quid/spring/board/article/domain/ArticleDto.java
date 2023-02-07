package com.quid.spring.board.article.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(LocalDateTime createdAt, String createdBy, String title, String content,
                         String hashtag) implements Serializable {

    public static ArticleDto toArticleDto(BoardArticle entity) {
        return new ArticleDto(
            entity.getCreatedAt(),
            entity.getCreatedBy(),
            entity.getTitle(),
            entity.getContent(),
            entity.getHashtag()
        );
    }

    public static BoardArticle toEntity(ArticleDto dto) {
        return BoardArticle.builder().content(dto.content).createdBy(dto.createdBy)
            .hashtag(dto.hashtag)
            .title(dto.title).build();
    }
}
