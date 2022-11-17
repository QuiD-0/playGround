package com.quid.Spring.diary.service;

import com.quid.Spring.diary.Diary;
import com.quid.Spring.diary.model.DiarySaveRequestDto;
import com.quid.Spring.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Override
    public void write(DiarySaveRequestDto diaryWriteRequestDto){
        log.info("write diary");
        diaryRepository.save(diaryWriteRequestDto.toEntity());
    }

    @Override
    public Page<Diary> read(Pageable pageable) {
        return diaryRepository.findAll(pageable);
    }


}
