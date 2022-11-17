package com.quid.Spring.diary.repository;

import com.quid.Spring.diary.Diary;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryJpaRepository extends JpaRepository<Diary, Long> {

    Page<Diary> findAllByDate(LocalDate date, Pageable pageable);
}
