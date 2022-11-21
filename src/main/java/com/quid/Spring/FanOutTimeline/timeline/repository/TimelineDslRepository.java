package com.quid.Spring.FanOutTimeline.timeline.repository;

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
        return null;
    }
}
