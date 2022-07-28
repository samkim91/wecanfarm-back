package com.example.wecanfarm.dto.pricing

import java.sql.Time
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class PricingCreateUpdateDto(
    @field:NotBlank(message = "이용내용은 필수입니다.")
    val eventName: String,

    @field:NotNull(message = "이용가격은 필수입니다.")
    val cost: Long,

    val playtime: Time?,
)
