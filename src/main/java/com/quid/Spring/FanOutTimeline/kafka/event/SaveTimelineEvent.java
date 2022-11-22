package com.quid.Spring.FanOutTimeline.kafka.event;

import lombok.Builder;

@Builder
public record SaveTimelineEvent(Long memberId, Long articleId) {

}