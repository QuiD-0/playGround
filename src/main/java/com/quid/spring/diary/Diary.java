package com.quid.spring.diary;

import com.quid.spring.diary.model.DiaryDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "diary", indexes = @Index(name = "idx_diary_date", columnList = "date"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    private final static String OWNER = "QuiD-0";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String username;
    @Column(length = 100)
    private String title;
    @Column(length = 1000)
    private String content;
    private LocalDate date;
    private LocalDateTime createdAt;

    @Builder
    public Diary(String title, String content, LocalDate date) {
        this.username = OWNER;
        this.title = title;
        this.content = content;
        this.date = date;
        this.createdAt = LocalDateTime.now();
    }

    public DiaryDto toDto() {
        return DiaryDto.builder().id(id).username(username).title(title).content(content)
            .createdAt(createdAt).build();
    }

}
