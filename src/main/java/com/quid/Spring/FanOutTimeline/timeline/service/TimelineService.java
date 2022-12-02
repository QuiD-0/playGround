package com.quid.Spring.FanOutTimeline.timeline.service;

import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;

public sealed interface TimelineService permits TimelineServiceImpl {

    List<TimelineDto> getTimeline(Long memberId);
}
