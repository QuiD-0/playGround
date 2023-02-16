package com.quid.designPattern.builder;

import com.quid.designPattern.builder.TourPlan.TourPlan;

public interface TourDirector {

     TourPlan myTrip();

     TourPlan busanTrip();

}
