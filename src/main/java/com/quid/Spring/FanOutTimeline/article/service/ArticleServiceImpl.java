package com.quid.Spring.FanOutTimeline.article.service;

import com.quid.Spring.FanOutTimeline.article.Article;
import com.quid.Spring.FanOutTimeline.article.model.ArticleRequestDto;
import com.quid.Spring.FanOutTimeline.article.repository.ArticleRepository;
import com.quid.Spring.FanOutTimeline.kafka.event.SaveTimelineEvent;
import com.quid.Spring.FanOutTimeline.kafka.producer.TimelineProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final TimelineProducer timelineProducer;

    @Override
    @Transactional
    public void createArticle(ArticleRequestDto articleRequestDto) {
        Article article = articleRepository.save(articleRequestDto.toEntity());
        SaveTimelineEvent event = SaveTimelineEvent.builder()
            .memberId(article.getMemberId())
            .articleId(article.getId())
            .build();
        timelineProducer.send(event);
    }

    @Override
    @Transactional
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Article> getArticle(Long memberId, Pageable pageable) {
        return articleRepository.findByMemberId(memberId, pageable);
    }
}
