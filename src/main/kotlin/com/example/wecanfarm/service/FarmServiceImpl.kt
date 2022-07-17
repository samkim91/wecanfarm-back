package com.example.wecanfarm.service

import com.example.wecanfarm.converter.farm.toEntity
import com.example.wecanfarm.converter.farm.toReadDto
import com.example.wecanfarm.converter.farm.updateEntity
import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.converter.toReadDto
import com.example.wecanfarm.converter.updateEntity
import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.dto.farm.FarmUpdateDto
import com.example.wecanfarm.entity.FarmTheme
import com.example.wecanfarm.repository.FarmRepository
import com.example.wecanfarm.repository.FarmThemeRepository
import com.example.wecanfarm.repository.ThemeRepository
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
    val themeRepository: ThemeRepository,
    val farmThemeRepository: FarmThemeRepository,
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
    override fun create(farmCreateDto: FarmCreateDto): FarmReadDto {
        val farm = farmRepository.save(farmCreateDto.toEntity())

        themeRepository.findAllById(farmCreateDto.themes).map { theme ->
            farm.themes.add(FarmTheme(farm, theme))
        }
        farmThemeRepository.saveAll(farm.themes)

        return farm.toReadDto()
    }

    @Transactional
    override fun update(id: Long, farmUpdateDto: FarmUpdateDto): FarmReadDto {
        val farm = farmRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 농장이 존재하지 않습니다.") }

        farm.updateEntity(farmUpdateDto = farmUpdateDto)

        farmThemeRepository.deleteAll(farm.themes)
        farm.themes.clear()

        themeRepository.findAllById(farmUpdateDto.themes).map { theme ->
            farm.themes.add(FarmTheme(farm, theme))
        }
        farmThemeRepository.saveAll(farm.themes)

        return farm.toReadDto()
    }


}