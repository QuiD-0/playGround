package com.quid.Spring.diary.service;

import com.quid.Spring.diary.Diary;
import com.quid.Spring.diary.model.DiarySaveRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiaryService {

    void write(DiarySaveRequestDto diaryWriteRequestDto);

    Page<Diary> read(Pageable pageable);
}
