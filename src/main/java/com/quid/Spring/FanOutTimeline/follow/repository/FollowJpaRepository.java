package com.quid.Spring.FanOutTimeline.follow.repository;

import com.quid.Spring.FanOutTimeline.follow.Follow;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowJpaRepository extends JpaRepository<Follow, Long> {

    Optional<Follow> findByFollowerId(Long followUserId);
}
