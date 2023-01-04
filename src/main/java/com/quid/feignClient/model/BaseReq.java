package com.quid.feignClient.model;

import static lombok.AccessLevel.PROTECTED;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = PROTECTED)
public class BaseReq {

    private String name;
    private Long age;

    @Builder
    public BaseReq(String name, Long age) {
        this.name = name;
        this.age = age;
    }
}
