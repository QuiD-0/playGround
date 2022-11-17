package com.quid.Spring.diary.repository;

import com.quid.Spring.diary.Diary;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DiaryRepositoryImpl implements DiaryRepository{

    private final DiaryJpaRepository diaryJpaRepository;

    @Override
    public void save(Diary diary) {
        diaryJpaRepository.save(diary);
    }

    @Override
    public Page<Diary> findAll(Pageable pageable) {
        return diaryJpaRepository.findAll(pageable);
    }
}
