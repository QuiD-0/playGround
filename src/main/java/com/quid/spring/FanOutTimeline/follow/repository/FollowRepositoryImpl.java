package com.quid.spring.FanOutTimeline.follow.repository;

import com.quid.spring.FanOutTimeline.follow.Follow;
import com.quid.spring.FanOutTimeline.follow.model.FollowRequestDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public non-sealed class FollowRepositoryImpl implements FollowRepository {

    private final FollowJpaRepository followJpaRepository;

    @Override
    public void follow(FollowRequestDto followRequestDto) {
        followJpaRepository.save(followRequestDto.toEntity());
    }

    @Override
    public void unfollow(Follow follow) {
        followJpaRepository.delete(follow);
    }

    @Override
    public Optional<Follow> findByFollowId(Long followUserId, Long memberId) {
        return followJpaRepository.findByFollowerIdAndMemberId(followUserId, memberId);
    }

    @Override
    public List<Follow> findFollowList(Long memberId) {
        return followJpaRepository.findByFollowerId(memberId);
    }
}
