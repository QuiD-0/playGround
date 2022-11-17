package com.quid.Spring.diary.controller;

import com.quid.Spring.diary.Diary;
import com.quid.Spring.diary.model.DiarySaveRequestDto;
import com.quid.Spring.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public void write(@RequestBody DiarySaveRequestDto diaryWriteRequestDto) {
        diaryService.write(diaryWriteRequestDto);
    }

    @GetMapping
    public Page<DiaryDto> read(Pageable pageable) {
        return diaryService.read(pageable).map(Diary::toDto);
    }

}
