package com.quid.Spring.FanOutTimeline.follow.service;

import com.quid.Spring.FanOutTimeline.follow.model.FollowRequestDto;

public sealed interface FollowService permits followServiceImpl {

    void follow(FollowRequestDto followRequestDto);

    void unfollow(FollowRequestDto followRequestDto);

}
