package com.quid.spring.FanOutTimeline.follow.controller;

import com.quid.spring.FanOutTimeline.follow.model.FollowRequestDto;
import com.quid.spring.FanOutTimeline.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/follow")
    public void follow(@RequestBody FollowRequestDto followRequestDto) {
        followService.follow(followRequestDto);
    }

    @DeleteMapping("/follow")
    public void unfollow(@RequestBody FollowRequestDto followRequestDto) {
        followService.unfollow(followRequestDto);
    }

}
