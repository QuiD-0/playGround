package com.quid.Spring.diary.controller;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
public class DiaryDto {

    private Long id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    @Builder
    public DiaryDto(Long id, String username, String title, String content,
        LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}
