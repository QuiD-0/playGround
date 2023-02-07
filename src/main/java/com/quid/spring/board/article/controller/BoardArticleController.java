package com.quid.spring.board.article.controller;

import com.quid.spring.board.article.domain.ArticleDto;
import com.quid.spring.board.article.domain.SearchType;
import com.quid.spring.board.article.service.BoardArticleService;
import com.quid.spring.board.user.domain.BoardPrincipal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class BoardArticleController {

    private final BoardArticleService boardArticleService;

    @GetMapping
    public Page<ArticleDto> articles(@RequestParam(required = false) SearchType searchType,
        @RequestParam(required = false) String searchValue,
        @PageableDefault(direction = Direction.DESC) Pageable pageable) {
        return boardArticleService.searchArticlesPage(searchType, searchValue, pageable);
    }

    @GetMapping("/{id}")
    public ArticleDto findOne(@PathVariable String id,
        @AuthenticationPrincipal BoardPrincipal boardPrincipal) {
        return boardArticleService.getArticle(Long.valueOf(id), boardPrincipal.getUsername());
    }

    @GetMapping("/hashtag")
    public List<String> hashtags() {
        return boardArticleService.findAllHashtag();
    }

    @GetMapping("/hashtag/{key}")
    public List<ArticleDto> hashtags(@PathVariable String key) {
        return boardArticleService.searchHashtag(key);
    }
}
