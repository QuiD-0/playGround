package com.quid.Spring.FanOutTimeline.timeline.repository;

import com.quid.Spring.FanOutTimeline.timeline.Timeline;
import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;

public sealed interface TimelineRepository permits TimelineRepositoryImpl {

    List<TimelineDto> getTimeline(Long memberId);

    void save(Timeline timeline);
}
