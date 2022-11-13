package com.example.wecanfarm.service.opening_hour

import com.example.wecanfarm.dto.opening_hour.OpeningHourCreateUpdateDto
import com.example.wecanfarm.entity.Farm

interface OpeningHourService {
    fun createOpeningHoursOfFarm(farm: Farm, openingHours: List<OpeningHourCreateUpdateDto>)
    fun updateOpeningHoursOfFarm(farm: Farm, openingHours: List<OpeningHourCreateUpdateDto>)
}