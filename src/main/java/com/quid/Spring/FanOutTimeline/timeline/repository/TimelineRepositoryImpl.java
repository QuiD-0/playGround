package com.quid.Spring.FanOutTimeline.timeline.repository;

import com.quid.Spring.FanOutTimeline.timeline.Timeline;
import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TimelineRepositoryImpl implements TimelineRepository {

    private final TimelineDslRepository timelineDslRepository;

    private final TimelineJpaRepository timelineJpaRepository;

    @Override
    public List<TimelineDto> getTimeline(Long memberId) {
        return timelineDslRepository.getTimeline(memberId);
    }

    @Override
    public void save(Timeline timeline) {
        timelineJpaRepository.save(timeline);
    }

}
