package com.quid.spring.FanOutTimeline.follow.service;

import com.quid.spring.FanOutTimeline.follow.model.FollowRequestDto;

public sealed interface FollowService permits followServiceImpl {

    void follow(FollowRequestDto followRequestDto);

    void unfollow(FollowRequestDto followRequestDto);

}
