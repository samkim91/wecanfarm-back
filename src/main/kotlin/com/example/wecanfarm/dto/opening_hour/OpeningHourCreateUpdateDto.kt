package com.example.wecanfarm.dto.opening_hour

import java.sql.Time
import java.time.DayOfWeek
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class  OpeningHourCreateUpdateDto(
    @field:NotBlank(message = "요일은 필수입니다.")
    @field:Pattern(regexp = "^[A-Z]*\$", message = "요일은 대문자로 보내주세요.")
    val dayOfWeek: DayOfWeek,

    @field:NotNull(message = "시작시간은 필수입니다.")
    val startTime: Time,

    @field:NotNull(message = "시작시간은 필수입니다.")
    val endTime: Time,
)
