package com.quid.spring.board.article.service;

import com.quid.spring.board.article.domain.ArticleDto;
import com.quid.spring.board.article.domain.SearchType;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface BoardArticleService {

    Page<ArticleDto> searchArticlesPage(SearchType searchType, String key, Pageable pageable);

    List<String> findAllHashtag();

    List<ArticleDto> searchHashtag(String key);

    @Transactional(readOnly = true)
    ArticleDto getArticle(Long id, String name);
}
