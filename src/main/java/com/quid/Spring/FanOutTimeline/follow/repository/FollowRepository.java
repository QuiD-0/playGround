package com.quid.Spring.FanOutTimeline.follow.repository;

import com.quid.Spring.FanOutTimeline.follow.Follow;
import com.quid.Spring.FanOutTimeline.follow.model.FollowRequestDto;
import java.util.List;
import java.util.Optional;

public interface FollowRepository {

    void follow(FollowRequestDto followRequestDto);

    void unfollow(Follow follow);

    Optional<Follow> findByFollowId(Long followUserId, Long memberId);

    List<Follow> findFollowList(Long memberId);
}
