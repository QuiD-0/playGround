package com.quid.Spring.FanOutTimeline.member.service;

import com.quid.Spring.FanOutTimeline.member.Member;
import com.quid.Spring.FanOutTimeline.member.model.MemberSaveRequestDto;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    void createMember(MemberSaveRequestDto memberSaveRequestDto);

    Page<Member> findMember(Pageable pageable);

    Optional<Member> findMember(Long id);
}