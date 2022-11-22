package com.quid.Spring.timeline.repository;

import com.quid.Spring.FanOutTimeline.article.Article;
import com.quid.Spring.FanOutTimeline.article.repository.ArticleJpaRepository;
import com.quid.Spring.FanOutTimeline.follow.Follow;
import com.quid.Spring.FanOutTimeline.follow.repository.FollowJpaRepository;
import com.quid.Spring.FanOutTimeline.member.Member;
import com.quid.Spring.FanOutTimeline.member.repository.MemberJpaRepository;
import com.quid.Spring.FanOutTimeline.timeline.Timeline;
import com.quid.Spring.FanOutTimeline.timeline.repository.TimelineJpaRepository;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class InsertRepository {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Autowired
    ArticleJpaRepository articleJpaRepository;

    @Autowired
    FollowJpaRepository followJpaRepository;

    @Autowired
    TimelineJpaRepository timelineJpaRepository;

    @Test
    @Rollback(value = false)
    public void memberInsert() {
        IntStream.range(0, 10000).forEach(i -> memberJpaRepository.save(Member.builder()
            .name("member" + i)
            .build()));
    }

    @Test
    @Rollback(value = false)
    public void followInsert() {
        IntStream.range(0, 1000).forEach(i -> followJpaRepository.save(Follow.builder()
            .memberId(Long.valueOf(i) * new Random().nextInt(10))
            .followerId(Long.valueOf(i) * new Random().nextInt(10))
            .build()));
    }

    @Test
    @Rollback(value = false)
    public void articleInsert() {
        IntStream.range(0, 1000).forEach(i -> {
            Article article = Article.builder()
                .memberId(Long.valueOf(i) * new Random().nextInt(10))
                .content("content" + i)
                .build();
            Article saved = articleJpaRepository.save(article);
            followJpaRepository.findByMemberId(Long.valueOf(i))
                .forEach(follow -> timelineJpaRepository.save(
                    Timeline.builder()
                        .articleId(saved.getId())
                        .memberId(follow.getFollowerId())
                        .build()));
        });
    }

}
