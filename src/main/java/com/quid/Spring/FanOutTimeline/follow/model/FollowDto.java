package com.quid.Spring.FanOutTimeline.follow.model;

import lombok.Builder;

@Builder
public record FollowDto(String followerName, Long followerId) {

}
