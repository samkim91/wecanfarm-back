package com.example.wecanfarm.service

import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.dto.farm.FarmUpdateDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FarmService {

    fun getList(search: String?, pageable: Pageable): Page<FarmReadDto>
    fun get(id: Long): FarmReadDto
    fun create(farmCreateDto: FarmCreateDto): FarmReadDto

    fun update(id: Long, farmUpdateDto: FarmUpdateDto): FarmReadDto
}