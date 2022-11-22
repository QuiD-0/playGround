package com.quid.Spring.FanOutTimeline.article.service;

import com.quid.Spring.FanOutTimeline.article.Article;
import com.quid.Spring.FanOutTimeline.article.model.ArticleRequestDto;
import com.quid.Spring.FanOutTimeline.article.repository.ArticleRepository;
import com.quid.Spring.FanOutTimeline.follow.repository.FollowRepository;
import com.quid.Spring.FanOutTimeline.timeline.Timeline;
import com.quid.Spring.FanOutTimeline.timeline.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final FollowRepository followRepository;

    private final TimelineRepository timelineRepository;

    @Override
    public void createArticle(ArticleRequestDto articleRequestDto) {
        Article article = articleRepository.save(articleRequestDto.toEntity());
        followRepository.findFollowList(articleRequestDto.memberId())
            .forEach(follow -> timelineRepository.save(Timeline.builder()
                .articleId(article.getId())
                .memberId(follow.getFollowerId())
                .build()));
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
