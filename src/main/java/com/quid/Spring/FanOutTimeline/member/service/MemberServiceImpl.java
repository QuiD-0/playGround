package com.quid.Spring.FanOutTimeline.member.service;

import com.quid.Spring.FanOutTimeline.member.Member;
import com.quid.Spring.FanOutTimeline.member.model.MemberSaveRequestDto;
import com.quid.Spring.FanOutTimeline.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void createMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member member = memberSaveRequestDto.toEntity();
        memberRepository.save(member);
    }

    @Override
    public Page<Member> findMember(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

}
