package com.quid.Spring.FanOutTimeline.article.controller;

import com.quid.Spring.FanOutTimeline.article.Article;
import com.quid.Spring.FanOutTimeline.article.model.ArticleDto;
import com.quid.Spring.FanOutTimeline.article.model.ArticleRequestDto;
import com.quid.Spring.FanOutTimeline.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public void createArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        articleService.createArticle(articleRequestDto);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    @GetMapping("/article/member/{memberId}")
    public Page<ArticleDto> getArticle(@PathVariable Long memberId, Pageable pageable) {
        return articleService.getArticle(memberId, pageable).map(Article::toDto);
    }
}
