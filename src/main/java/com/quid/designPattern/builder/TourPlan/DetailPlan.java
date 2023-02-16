package com.quid.designPattern.builder.TourPlan;

import lombok.ToString;

@ToString
public class DetailPlan {

    private int day;
    private String plan;

    public DetailPlan(int day, String plan) {
        this.day = day;
        this.plan = plan;
    }

    public int getDay() {
        return day;
    }

    public String getPlan() {
        return plan;
    }

}
