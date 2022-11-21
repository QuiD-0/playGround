package com.quid.Spring.FanOutTimeline.article;

import com.quid.Spring.FanOutTimeline.article.model.ArticleDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String title;
    private String content;

    @Builder
    public Article(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }

    public ArticleDto toDto() {
        return ArticleDto.builder()
            .id(id)
            .memberId(memberId)
            .title(title)
            .content(content)
            .build();
    }
}
