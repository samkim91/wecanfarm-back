package com.example.wecanfarm.service

import com.example.wecanfarm.dto.opening_hour.OpeningHourCreateUpdateDto
import com.example.wecanfarm.dto.theme.ThemeCreateUpdateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.entity.Farm
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional

interface OpeningHourService {
    fun createOpeningHoursOfFarm(farm: Farm, openingHours: List<OpeningHourCreateUpdateDto>)
    fun updateOpeningHoursOfFarm(farm: Farm, openingHours: List<OpeningHourCreateUpdateDto>)
}