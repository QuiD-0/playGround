package com.quid.Spring.diary.model;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record DailyCount (LocalDate date, Long count) {
}
