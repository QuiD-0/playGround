package com.quid.Spring.FanOutTimeline.kafka.producer;

import com.quid.Spring.FanOutTimeline.kafka.event.SaveTimelineEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TimelineProducer {

    private final KafkaTemplate<Long, SaveTimelineEvent> kafkaTemplate;
    private String topic = "timeline";

    public void send(SaveTimelineEvent event) {
        kafkaTemplate.send(topic, event);
        log.info("Timeline save event sent to kafka topic(timeline): {}", event);
    }
}
