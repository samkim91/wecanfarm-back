package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.pricing.PricingCreateUpdateDto
import com.example.wecanfarm.dto.pricing.PricingReadDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.Pricing


fun Pricing.toReadDto() =
    PricingReadDto(
        eventName = eventName,
        cost = cost,
        playtime = playtime,
    )

fun PricingCreateUpdateDto.toEntity(farm: Farm) =
    Pricing(
        farm = farm,
        eventName = eventName,
        cost = cost,
        playtime = playtime,
    )
