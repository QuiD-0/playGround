package com.quid.spring.diary.repository;

import com.quid.spring.diary.Diary;
import com.quid.spring.diary.model.DailyCount;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public non-sealed class DiaryRepositoryImpl implements DiaryRepository {

    private final DiaryJpaRepository diaryJpaRepository;

    private final DairyDslRepository dairyDslRepository;

    @Override
    public void save(Diary diary) {
        diaryJpaRepository.save(diary);
    }

    @Override
    public Page<Diary> findAll(Pageable pageable) {
        return diaryJpaRepository.findAll(pageable);
    }

    @Override
    public Page<Diary> findAllByDate(LocalDate date, Pageable pageable) {
        return diaryJpaRepository.findAllByDate(date, pageable);
    }

    @Override
    public List<DailyCount> dailyCount() {
        return dairyDslRepository.dailyCount();
    }


    @Override
    public void saveAll(List<Diary> diaries) {
        diaryJpaRepository.saveAll(diaries);
    }
}
