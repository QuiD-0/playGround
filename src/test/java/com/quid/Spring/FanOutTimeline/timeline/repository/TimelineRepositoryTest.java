package com.quid.Spring.FanOutTimeline.timeline.repository;

import com.quid.Spring.FanOutTimeline.timeline.model.TimelineDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimelineRepositoryTest {

    @Autowired
    TimelineRepository timelineRepository;

    @Test
    void getTimeline() {
        List<TimelineDto> timeline = timelineRepository.getTimeline(1L);
        System.out.println(timeline);
    }
}