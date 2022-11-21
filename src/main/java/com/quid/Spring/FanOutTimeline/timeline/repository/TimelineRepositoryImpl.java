package com.quid.Spring.FanOutTimeline.timeline.repository;

import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TimelineRepositoryImpl implements TimelineRepository {

    private final TimelineDslRepository timelineDslRepository;

    @Override
    public List<TimelineDto> getTimeline(Long memberId) {
        return timelineDslRepository.getTimeline(memberId);
    }

}
