package com.example.wecanfarm.dto.url

import com.example.wecanfarm.enums.SnsType
import java.sql.Time
import java.time.DayOfWeek

data class UrlReadDto(
    val address: String,
    val type: SnsType,
)
