package com.example.wecanfarm.dto.opening_hour

import java.sql.Time
import java.time.DayOfWeek

data class OpeningHourReadDto(
    val dayOfWeek: DayOfWeek,
    val dayOfWeekInKorean: String,
    val startTime: Time,
    val endTime: Time,
)
