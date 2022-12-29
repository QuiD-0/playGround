package com.quid.spring.diary.repository;

import com.quid.spring.diary.Diary;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Disabled;
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
    @Disabled
    @Rollback(value = false)
    @DisplayName("테스트를 위한 데이터 삽입")
    public void bulkInsert() {
        List<Diary> diaries = IntStream.range(0, 100000)
            .mapToObj(DiaryRepositoryImplTest::getRandomDiary)
            .toList();

        diaryRepository.saveAll(diaries);
    }


    public static Diary getRandomDiary(int i) {
        UUID uuid = UUID.randomUUID();
        return Diary.builder()
            .date(LocalDate.now().minusDays((long) (Math.random() * 100)))
            .title("title : " + uuid)
            .content("content : " + uuid)
            .build();
    }
}