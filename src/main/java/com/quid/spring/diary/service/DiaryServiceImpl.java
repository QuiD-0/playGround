package com.quid.spring.diary.service;

import com.quid.spring.diary.Diary;
import com.quid.spring.diary.model.DailyCount;
import com.quid.spring.diary.model.DiarySaveRequestDto;
import com.quid.spring.diary.repository.DiaryRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public non-sealed class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Override
    public void write(DiarySaveRequestDto diaryWriteRequestDto) {
        log.info("write diary");
        diaryRepository.save(diaryWriteRequestDto.toEntity());
    }

    @Override
    public Page<Diary> read(Pageable pageable) {
        log.info("read diary {}", pageable);
        return diaryRepository.findAll(pageable);
    }

    @Override
    public Page<Diary> readDaily(LocalDate date, Pageable pageable) {
        log.info("read daily diary {}", date);
        return diaryRepository.findAllByDate(date, pageable);
    }

    @Override
    public List<DailyCount> dailyCount() {
        log.info("get daily count");
        return diaryRepository.dailyCount();
    }


}
