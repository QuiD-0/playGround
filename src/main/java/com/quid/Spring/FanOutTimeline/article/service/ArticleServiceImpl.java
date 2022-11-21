package com.quid.Spring.FanOutTimeline.article.service;

import com.quid.Spring.FanOutTimeline.article.Article;
import com.quid.Spring.FanOutTimeline.article.model.ArticleRequestDto;
import com.quid.Spring.FanOutTimeline.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public void createArticle(ArticleRequestDto articleRequestDto) {
        articleRepository.save(articleRequestDto.toEntity());
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Page<Article> getArticle(Long memberId, Pageable pageable) {
        return articleRepository.findByMemberId(memberId, pageable);
    }
}
