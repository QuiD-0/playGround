package com.quid.feignClient.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseRes {

    private String name;
    private Long age;
    private String header;

    @Builder
    public BaseRes(String name, Long age, String header) {
        this.name = name;
        this.age = age;
        this.header = header;
    }
}
