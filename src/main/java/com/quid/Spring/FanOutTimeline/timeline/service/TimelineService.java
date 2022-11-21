package com.quid.Spring.FanOutTimeline.timeline.service;

import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;

public interface TimelineService {

    List<TimelineDto> getTimeline(Long memberId);
}
