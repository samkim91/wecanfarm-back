package com.example.wecanfarm.service.farm

import com.example.wecanfarm.dto.farm.FarmCreateUpdateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FarmService {

    fun getList(search: String?, pageable: Pageable): Page<FarmReadDto>
    fun get(id: Long): FarmReadDto
    fun create(farmCreateUpdateDto: FarmCreateUpdateDto): FarmReadDto
    fun update(id: Long, farmCreateUpdateDto: FarmCreateUpdateDto): FarmReadDto
}