package com.quid.spring.FanOutTimeline.timeline.controller;

import com.quid.spring.FanOutTimeline.timeline.model.TimelineDto;
import com.quid.spring.FanOutTimeline.timeline.service.TimelineService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

    @GetMapping("/timeline/member/{memberId}")
    public List<TimelineDto> getTimeline(@PathVariable Long memberId) {
        return timelineService.getTimeline(memberId);
    }

}
