package com.quid.Spring.diary.model;

import com.quid.Spring.diary.Diary;
import lombok.Builder;
import lombok.Data;

@Data
public class DiarySaveRequestDto {

    private String title;
    private String content;

    @Builder
    public DiarySaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Diary toEntity() {
        return Diary.builder()
                .title(title)
                .content(content)
                .build();
    }
}
