package com.quid.Spring.FanOutTimeline.article.repository;

import com.quid.Spring.FanOutTimeline.article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public non-sealed class ArticleRepositoryImpl implements ArticleRepository {

    private final ArticleJpaRepository articleJpaRepository;

    @Override
    public Article save(Article article) {
        return articleJpaRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
        articleJpaRepository.deleteById(id);
    }

    @Override
    public Page<Article> findByMemberId(Long memberId, Pageable pageable) {
        return articleJpaRepository.findByMemberId(memberId, pageable);
    }
}
