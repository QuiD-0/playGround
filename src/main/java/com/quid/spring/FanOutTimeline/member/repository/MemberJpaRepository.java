package com.quid.spring.FanOutTimeline.member.repository;

import com.quid.spring.FanOutTimeline.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}
