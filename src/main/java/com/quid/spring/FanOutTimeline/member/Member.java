package com.quid.spring.FanOutTimeline.member;

import com.quid.spring.FanOutTimeline.member.model.MemberDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder
    public Member(String name) {
        this.name = name;
    }

    public MemberDto toDto() {
        return MemberDto.builder()
            .id(id)
            .name(name)
            .build();
    }
}
