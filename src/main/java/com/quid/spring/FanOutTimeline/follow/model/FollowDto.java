package com.quid.spring.FanOutTimeline.follow.model;

import lombok.Builder;

@Builder
public record FollowDto(String followerName, Long followerId) {

}
