package com.quid.Spring.FanOutTimeline.timeline.repository;

import static com.quid.Spring.FanOutTimeline.article.QArticle.article;
import static com.quid.Spring.FanOutTimeline.member.QMember.member;
import static com.quid.Spring.FanOutTimeline.timeline.QTimeline.timeline;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TimelineDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<TimelineDto> getTimeline(Long memberId) {
        return jpaQueryFactory.select(
                Projections.constructor(TimelineDto.class, member.name, article.title, article.content,
                    article.id))
            .from(timeline)
            .join(article).on(timeline.articleId.eq(article.id))
            .join(member).on(timeline.memberId.eq(member.id))
            .where(timeline.memberId.eq(memberId))
            .fetch();
    }
}
