package com.example.wecanfarm.service

import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.converter.toReadDto
import com.example.wecanfarm.converter.updateEntity
import com.example.wecanfarm.dto.theme.ThemeCreateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.theme.ThemeUpdateDto
import com.example.wecanfarm.repository.ThemeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class ThemeServiceImpl @Autowired constructor(
    val themeRepository: ThemeRepository
) : BaseService(), ThemeService {

    override fun getList(search: String?, pageable: Pageable): Page<ThemeReadDto> {
        return if (search == null) {
            themeRepository.findAll(pageable)
        } else {
            themeRepository.findAllBySearchAndFilter(search, pageable)
        }.map { theme -> theme.toReadDto() }
    }

    override fun get(id: Long): ThemeReadDto {
        return themeRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 테마가 존재하지 않습니다.") }.toReadDto()
    }

    @Transactional
    override fun create(themeCreateDto: ThemeCreateDto): ThemeReadDto {
        return themeRepository.save(themeCreateDto.toEntity()).toReadDto()
    }

    @Transactional
    override fun update(id: Long, themeUpdateDto: ThemeUpdateDto): ThemeReadDto {
        val theme = themeRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 테마가 존재하지 않습니다.") }
        theme.updateEntity(themeUpdateDto = themeUpdateDto)
        return theme.toReadDto()
    }
}