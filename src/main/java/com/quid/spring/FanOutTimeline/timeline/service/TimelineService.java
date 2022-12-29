package com.quid.spring.FanOutTimeline.timeline.service;

import com.quid.spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;

public sealed interface TimelineService permits TimelineServiceImpl {

    List<TimelineDto> getTimeline(Long memberId);
}
