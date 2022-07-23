package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.opening_hour.OpeningHourCreateUpdateDto
import com.example.wecanfarm.dto.opening_hour.OpeningHourReadDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.OpeningHour
import java.time.DayOfWeek


fun OpeningHour.toReadDto() =
    OpeningHourReadDto(
        dayOfWeek = dayOfWeek,
        dayOfWeekInKorean = dayOfWeek.getKorean(),
        startTime = startTime,
        endTime = endTime,
    )

fun OpeningHourCreateUpdateDto.toEntity(farm: Farm) =
    OpeningHour(
        farm = farm,
        dayOfWeek = dayOfWeek,
        startTime = startTime,
        endTime = endTime
    )

fun DayOfWeek.getKorean() : String {
    return when(this) {
        DayOfWeek.MONDAY -> "월"
        DayOfWeek.TUESDAY -> "화"
        DayOfWeek.WEDNESDAY -> "수"
        DayOfWeek.THURSDAY -> "목"
        DayOfWeek.FRIDAY -> "금"
        DayOfWeek.SATURDAY -> "토"
        DayOfWeek.SUNDAY ->"일"
    }
}