package com.quid.Spring.FanOutTimeline.kafka.consumer;

import com.quid.Spring.FanOutTimeline.follow.repository.FollowRepository;
import com.quid.Spring.FanOutTimeline.kafka.event.SaveTimelineEvent;
import com.quid.Spring.FanOutTimeline.timeline.Timeline;
import com.quid.Spring.FanOutTimeline.timeline.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TimelineConsumer {

    private final FollowRepository followRepository;

    private final TimelineRepository timelineRepository;

    @KafkaListener(topics = "timeline", groupId = "timeline")
    public void saveTimeline(SaveTimelineEvent event, Acknowledgment ack) {
        followRepository.findFollowList(event.memberId())
            .forEach(follow -> timelineRepository.save(Timeline.builder()
                .articleId(event.articleId())
                .memberId(follow.getFollowerId())
                .build()));
        log.info("Timeline save event received from kafka topic(timeline): {}", event);

        ack.acknowledge();
    }

}
