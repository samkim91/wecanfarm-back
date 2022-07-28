package com.example.wecanfarm.dto.pricing

import java.sql.Time
import java.time.DayOfWeek

data class PricingReadDto(
    val eventName: String,
    val cost: Long,
    val playtime: Time?,
)
