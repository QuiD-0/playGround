package com.quid.Spring.FanOutTimeline.follow.service;

import com.quid.Spring.FanOutTimeline.follow.model.FollowRequestDto;

public interface FollowService {

    void follow(FollowRequestDto followRequestDto);

    void unfollow(FollowRequestDto followRequestDto);

}
