package com.quid.spring.diary.model;

import com.quid.spring.diary.Diary;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public record DiarySaveRequestDto(String title, String content,
                                  @DateTimeFormat(iso = ISO.DATE) LocalDate date) {

    public Diary toEntity() {
        return Diary.builder()
            .title(title)
            .content(content)
            .date(date)
            .build();
    }
}
