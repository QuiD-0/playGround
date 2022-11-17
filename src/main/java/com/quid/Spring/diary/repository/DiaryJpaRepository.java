package com.quid.Spring.diary.repository;

import com.quid.Spring.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryJpaRepository extends JpaRepository<Diary, Long> {

}
