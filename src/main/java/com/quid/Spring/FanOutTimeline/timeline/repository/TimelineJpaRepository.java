package com.quid.Spring.FanOutTimeline.timeline.repository;

import com.quid.Spring.FanOutTimeline.timeline.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineJpaRepository extends JpaRepository<Timeline, Long> {

}
