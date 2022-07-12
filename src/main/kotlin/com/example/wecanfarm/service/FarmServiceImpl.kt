package com.example.wecanfarm.service

import com.example.wecanfarm.converter.farm.toEntity
import com.example.wecanfarm.converter.farm.toReadDto
import com.example.wecanfarm.converter.farm.updateEntity
import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.dto.farm.FarmUpdateDto
import com.example.wecanfarm.repository.FarmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class FarmServiceImpl @Autowired constructor(
    val farmRepository: FarmRepository
) : BaseService(), FarmService {

    override fun findById(id: Long): FarmReadDto {
        return farmRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 농장이 존재하지 않습니다.") }.toReadDto()
    }

    @Transactional
    override fun insertFarm(farmCreateDto: FarmCreateDto): FarmReadDto {
        return farmRepository.save(farmCreateDto.toEntity()).toReadDto()
    }

    @Transactional
    override fun updateFarm(id: Long, farmUpdateDto: FarmUpdateDto): FarmReadDto {
        val farm = farmRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 농장이 존재하지 않습니다.") }

        farm.updateEntity(farmUpdateDto = farmUpdateDto)

        return farm.toReadDto()
    }


}