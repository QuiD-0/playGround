package com.quid.Spring.diary.repository;

import com.quid.Spring.diary.Diary;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class DiaryRepositoryImplTest {

    @Autowired
    DiaryRepository diaryRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("테스트를 위한 데이터 삽입")
    public void bulkInsert() {
        List<Diary> diaries = IntStream.range(0, 1000).mapToObj(i -> Diary.builder()
            .date(LocalDate.now().minusDays((long) (Math.random() * 100)))
            .title("title" + i)
            .content("content" + i)
            .build()).toList();

        diaryRepository.saveAll(diaries);
    }

}