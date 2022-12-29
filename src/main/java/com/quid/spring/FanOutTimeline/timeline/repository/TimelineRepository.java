package com.quid.spring.FanOutTimeline.timeline.repository;

import com.quid.spring.FanOutTimeline.timeline.Timeline;
import com.quid.spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;

public sealed interface TimelineRepository permits TimelineRepositoryImpl {

    List<TimelineDto> getTimeline(Long memberId);

    void save(Timeline timeline);
}
