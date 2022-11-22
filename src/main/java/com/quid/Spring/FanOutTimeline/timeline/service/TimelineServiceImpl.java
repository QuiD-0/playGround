package com.quid.Spring.FanOutTimeline.timeline.service;

import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import com.quid.Spring.FanOutTimeline.timeline.repository.TimelineRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TimelineServiceImpl implements TimelineService {

    private final TimelineRepository timelineRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TimelineDto> getTimeline(Long memberId) {
        return timelineRepository.getTimeline(memberId);
    }
}
