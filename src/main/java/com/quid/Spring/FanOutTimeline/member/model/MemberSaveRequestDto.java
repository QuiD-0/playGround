package com.quid.Spring.FanOutTimeline.member.model;

import com.quid.Spring.FanOutTimeline.member.Member;
import lombok.Builder;

@Builder
public record MemberSaveRequestDto(String name) {

    public Member toEntity() {
        return Member.builder().name(name).build();
    }
}
