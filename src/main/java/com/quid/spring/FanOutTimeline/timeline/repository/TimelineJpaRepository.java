package com.quid.spring.FanOutTimeline.timeline.repository;

import com.quid.spring.FanOutTimeline.timeline.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineJpaRepository extends JpaRepository<Timeline, Long> {

}
