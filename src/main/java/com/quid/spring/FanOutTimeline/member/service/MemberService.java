package com.quid.spring.FanOutTimeline.member.service;

import com.quid.spring.FanOutTimeline.member.Member;
import com.quid.spring.FanOutTimeline.member.model.MemberSaveRequestDto;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface MemberService permits MemberServiceImpl {

    void createMember(MemberSaveRequestDto memberSaveRequestDto);

    Page<Member> findMember(Pageable pageable);

    Optional<Member> findMember(Long id);
}
