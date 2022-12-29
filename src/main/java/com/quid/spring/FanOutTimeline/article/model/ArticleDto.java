package com.quid.spring.FanOutTimeline.article.model;

import lombok.Builder;

@Builder
public record ArticleDto(Long id, Long memberId, String title, String content) {

}
