package com.quid.spring.FanOutTimeline.follow.repository;

import com.quid.spring.FanOutTimeline.follow.Follow;
import com.quid.spring.FanOutTimeline.follow.model.FollowRequestDto;
import java.util.List;
import java.util.Optional;

public sealed interface FollowRepository permits FollowRepositoryImpl {

    void follow(FollowRequestDto followRequestDto);

    void unfollow(Follow follow);

    Optional<Follow> findByFollowId(Long followUserId, Long memberId);

    List<Follow> findFollowList(Long memberId);
}
