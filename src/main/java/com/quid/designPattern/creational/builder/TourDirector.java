package com.quid.designPattern.creational.builder;

import com.quid.designPattern.creational.builder.TourPlan.TourPlan;

public interface TourDirector {

     TourPlan myTrip();

     TourPlan busanTrip();

}
