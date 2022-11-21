package com.quid.Spring.FanOutTimeline.member.controller;

import com.quid.Spring.FanOutTimeline.member.Member;
import com.quid.Spring.FanOutTimeline.member.model.MemberDto;
import com.quid.Spring.FanOutTimeline.member.model.MemberSaveRequestDto;
import com.quid.Spring.FanOutTimeline.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public void createMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        memberService.createMember(memberSaveRequestDto);
    }

    @GetMapping("/member")
    public Page<MemberDto> findMembers(Pageable pageable) {
        return memberService.findMember(pageable).map(Member::toDto);
    }

    @GetMapping("/member/{id}")
    public MemberDto findMember(@PathVariable Long id) {
        return memberService.findMember(id).map(Member::toDto)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다. id=" + id));
    }

}
