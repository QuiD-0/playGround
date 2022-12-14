package com.quid.spring.FanOutTimeline.follow.service;

import com.quid.spring.FanOutTimeline.follow.model.FollowRequestDto;
import com.quid.spring.FanOutTimeline.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public non-sealed class followServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    @Override
    @Transactional
    public void follow(FollowRequestDto followRequestDto) {
        followRepository.findByFollowId(followRequestDto.followUserId(), followRequestDto.userId())
            .ifPresentOrElse(
                follow -> {
                    throw new IllegalArgumentException("이미 팔로우한 유저입니다.");
                },
                () -> followRepository.follow(followRequestDto)
            );
    }

    @Override
    @Transactional
    public void unfollow(FollowRequestDto followRequestDto) {
        followRepository.findByFollowId(followRequestDto.followUserId(), followRequestDto.userId())
            .ifPresent(followRepository::unfollow);
    }

}
