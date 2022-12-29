package com.quid.spring.diary.service;

import com.quid.spring.diary.Diary;
import com.quid.spring.diary.model.DailyCount;
import com.quid.spring.diary.model.DiarySaveRequestDto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface DiaryService permits DiaryServiceImpl {

    void write(DiarySaveRequestDto diaryWriteRequestDto);

    Page<Diary> read(Pageable pageable);

    Page<Diary> readDaily(LocalDate date, Pageable pageable);

    List<DailyCount> dailyCount();
}
