package com.quid.spring.FanOutTimeline.member.repository;

import com.quid.spring.FanOutTimeline.member.Member;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface MemberRepository permits MemberRepositoryImpl {


    void save(Member member);

    Page<Member> findAll(Pageable pageable);

    Optional<Member> findById(Long id);
}
