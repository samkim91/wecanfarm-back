package com.example.wecanfarm.service

import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.dto.farm.FarmUpdateDto

interface FarmService {

    fun findById(id: Long): FarmReadDto
    fun createFarm(farmCreateDto: FarmCreateDto): FarmReadDto

    fun updateFarm(id: Long, farmUpdateDto: FarmUpdateDto): FarmReadDto
}