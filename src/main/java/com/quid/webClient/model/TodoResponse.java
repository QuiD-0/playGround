package com.quid.webClient.model;

import lombok.Getter;

@Getter
public class TodoResponse {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;
}
