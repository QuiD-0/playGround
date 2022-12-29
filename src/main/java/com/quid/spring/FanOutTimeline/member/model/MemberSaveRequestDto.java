package com.quid.spring.FanOutTimeline.member.model;

import com.quid.spring.FanOutTimeline.member.Member;
import lombok.Builder;

@Builder
public record MemberSaveRequestDto(String name) {

    public Member toEntity() {
        return Member.builder().name(name).build();
    }
}
