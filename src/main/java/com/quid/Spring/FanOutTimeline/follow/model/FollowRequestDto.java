package com.quid.Spring.FanOutTimeline.follow.model;

import com.quid.Spring.FanOutTimeline.follow.Follow;
import lombok.Builder;

@Builder
public record FollowRequestDto(Long userId, Long followUserId) {

    public Follow toEntity() {
        return Follow.builder()
            .memberId(userId)
            .followerId(followUserId)
            .build();
    }
}
