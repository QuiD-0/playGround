package com.quid.Spring.diary;

import com.quid.Spring.diary.controller.DiaryDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final String username = "QuiD-0";
    private String title;
    private String content;
    private LocalDateTime createdAt;

    @Builder
    public Diary(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public DiaryDto toDto() {
        return DiaryDto.builder()
                .id(id)
                .username(username)
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .build();
    }
}
