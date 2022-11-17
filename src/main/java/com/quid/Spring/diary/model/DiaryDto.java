package com.quid.Spring.diary.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record DiaryDto(Long id, String username, String title, String content,LocalDate date, LocalDateTime createdAt) {

}
