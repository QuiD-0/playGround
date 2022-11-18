package com.quid.Spring.diary.repository;

import static com.quid.Spring.diary.QDiary.diary;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.quid.Spring.diary.model.DailyCount;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DairyDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<DailyCount> dailyCount() {
        return jpaQueryFactory
            .select(Projections.constructor(DailyCount.class, diary.date, diary.date.count()))
                .from(diary)
                .groupBy(diary.date)
                .fetch();
    }
}
