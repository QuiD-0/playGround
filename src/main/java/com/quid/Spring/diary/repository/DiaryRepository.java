package com.quid.Spring.diary.repository;

import com.quid.Spring.diary.Diary;
import com.quid.Spring.diary.model.DailyCount;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiaryRepository {

    void save(Diary diary);

    Page<Diary> findAll(Pageable pageable);

    Page<Diary> findAllByDate(LocalDate date, Pageable pageable);

    List<DailyCount> dailyCount();
}
