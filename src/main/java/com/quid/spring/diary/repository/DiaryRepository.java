package com.quid.spring.diary.repository;

import com.quid.spring.diary.Diary;
import com.quid.spring.diary.model.DailyCount;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface DiaryRepository permits DiaryRepositoryImpl {

    void save(Diary diary);

    Page<Diary> findAll(Pageable pageable);

    Page<Diary> findAllByDate(LocalDate date, Pageable pageable);

    List<DailyCount> dailyCount();

    void saveAll(List<Diary> diaries);
}
