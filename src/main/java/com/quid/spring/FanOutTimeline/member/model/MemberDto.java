package com.quid.spring.FanOutTimeline.member.model;

import lombok.Builder;

@Builder
public record MemberDto(Long id, String name) {

}
