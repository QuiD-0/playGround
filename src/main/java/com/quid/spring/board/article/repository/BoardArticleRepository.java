package com.quid.spring.board.article.repository;

import com.quid.spring.board.article.domain.BoardArticle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardArticleRepository {

    List<String> findAllHashtag();

    Page<BoardArticle> findByTitleContaining(String title, Pageable pageable);

    Page<BoardArticle> findByContentContaining(String key, Pageable pageable);

    Page<BoardArticle> findByHashtag(String key, Pageable pageable);

    Optional<BoardArticle> findById(Long id);

    Page<BoardArticle> findAll(Pageable pageable);

    List<BoardArticle> findSearchtag(String key);
}
