package com.quid.designPattern.builder;

import com.quid.designPattern.builder.TourPlan.TourPlan;
import java.time.LocalDate;

public class DefaultTourDirector implements TourDirector {

    private TourPlanBuilder builder;

    public DefaultTourDirector(TourPlanBuilder builder) {
        this.builder = builder;
    }

    @Override
    public TourPlan myTrip() {
        return builder.title("My Tour Plan")
            .nightsAndDays(3, 4)
            .startDate(LocalDate.of(2023, 2, 16))
            .whereToStay("Hotel")
            .addPlan(1, "체크인 및 휴식")
            .addPlan(2, "바다보기")
            .addPlan(3, "맛집 가기")
            .addPlan(4, "기차여행")
            .addPlan(4, "체크아웃")
            .getPlan();
    }

    @Override
    public TourPlan busanTrip() {
        return builder.title("부산여행")
            .nightsAndDays(3, 4)
            .startDate(LocalDate.of(2023, 2, 16))
            .getPlan();
    }
}
