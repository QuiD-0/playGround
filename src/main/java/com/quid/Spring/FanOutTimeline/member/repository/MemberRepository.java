package com.quid.Spring.FanOutTimeline.member.repository;

import com.quid.Spring.FanOutTimeline.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
