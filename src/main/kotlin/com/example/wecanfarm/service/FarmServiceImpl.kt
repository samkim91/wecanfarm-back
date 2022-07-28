package com.example.wecanfarm.service

import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.converter.toReadDto
import com.example.wecanfarm.converter.updateEntity
import com.example.wecanfarm.dto.farm.FarmCreateUpdateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.repository.FarmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class FarmServiceImpl @Autowired constructor(
    val farmRepository: FarmRepository,
    val themeService: ThemeService,
    val openingHourService: OpeningHourService,
    val pricingService: PricingService,
) : BaseService(), FarmService {

    override fun getList(search: String?, pageable: Pageable): Page<FarmReadDto> {
        return if (search == null) {
            farmRepository.findAll(pageable)
        } else {
            farmRepository.findAllBySearchAndFilters(search, pageable)
        }.map { farm -> farm.toReadDto() }
    }

    override fun get(id: Long): FarmReadDto {
        return farmRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 농장이 존재하지 않습니다.") }.toReadDto()
    }

    @Transactional
    override fun create(farmCreateUpdateDto: FarmCreateUpdateDto): FarmReadDto {
        val farm = farmRepository.save(farmCreateUpdateDto.toEntity())

        themeService.createThemesOfFarm(farm, farmCreateUpdateDto.themeIds)
        farmCreateUpdateDto.openingHours?.let {
            openingHourService.createOpeningHoursOfFarm(farm, farmCreateUpdateDto.openingHours)
        }
        farmCreateUpdateDto.pricing?.let {
            pricingService.createPricingOfFarm(farm, farmCreateUpdateDto.pricing)
        }

        return farm.toReadDto()
    }

    @Transactional
    override fun update(id: Long, farmCreateUpdateDto: FarmCreateUpdateDto): FarmReadDto {
        val farm = farmRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 농장이 존재하지 않습니다.") }

        farm.updateEntity(farmCreateUpdateDto = farmCreateUpdateDto)
        themeService.updateThemesOfFarm(farm, farmCreateUpdateDto.themeIds)
        farmCreateUpdateDto.openingHours?.let {
            openingHourService.updateOpeningHoursOfFarm(farm, farmCreateUpdateDto.openingHours)
        }
        farmCreateUpdateDto.pricing?.let {
            pricingService.updatePricingOfFarm(farm, farmCreateUpdateDto.pricing)
        }

        return farm.toReadDto()
    }


}