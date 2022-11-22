package com.quid.Spring.FanOutTimeline.follow.service;

import com.quid.Spring.FanOutTimeline.follow.model.FollowRequestDto;
import com.quid.Spring.FanOutTimeline.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class followServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    @Override
    @Transactional
    public void follow(FollowRequestDto followRequestDto) {
        followRepository.findByFollowId(followRequestDto.followUserId()).ifPresentOrElse(
            follow -> {
                throw new IllegalArgumentException("이미 팔로우한 유저입니다.");
            },
            () -> followRepository.follow(followRequestDto)
        );
    }

    @Override
    @Transactional
    public void unfollow(FollowRequestDto followRequestDto) {
        followRepository.findByFollowId(followRequestDto.followUserId())
            .ifPresent(followRepository::unfollow);
    }

}
