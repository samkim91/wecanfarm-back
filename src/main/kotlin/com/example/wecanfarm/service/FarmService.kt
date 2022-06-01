package com.example.wecanfarm.service

import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.repository.FarmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class FarmService @Autowired constructor(
    val farmRepository: FarmRepository
) {

    fun findById(id: Long): FarmReadDto {
        return FarmReadDto.fromEntity(farmRepository.findById(id).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND) })
    }

    fun insertFarm(farmCreateDto: FarmCreateDto): FarmReadDto {
        return FarmReadDto.fromEntity(farmRepository.save(FarmCreateDto.toEntity(farmCreateDto)))
    }
}