package com.quid.Spring.diary.repository;

import com.quid.Spring.diary.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiaryRepository {

    void save(Diary diary);

    Page<Diary> findAll(Pageable pageable);
}
