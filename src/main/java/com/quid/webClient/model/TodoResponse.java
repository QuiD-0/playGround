package com.quid.webClient.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TodoResponse {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;
}
