package com.quid.spring.FanOutTimeline.timeline.service;

import com.quid.spring.FanOutTimeline.timeline.model.TimelineDto;
import com.quid.spring.FanOutTimeline.timeline.repository.TimelineRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public non-sealed class TimelineServiceImpl implements TimelineService {

    private final TimelineRepository timelineRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TimelineDto> getTimeline(Long memberId) {
        return timelineRepository.getTimeline(memberId);
    }
}
