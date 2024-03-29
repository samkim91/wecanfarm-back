package com.example.wecanfarm.service.theme

import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.converter.toReadDto
import com.example.wecanfarm.converter.updateEntity
import com.example.wecanfarm.dto.theme.ThemeCreateUpdateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.FarmTheme
import com.example.wecanfarm.repository.FarmThemeRepository
import com.example.wecanfarm.repository.ThemeRepository
import com.example.wecanfarm.service.BaseService
import com.example.wecanfarm.service.theme_attachment.ThemeAttachmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class ThemeServiceImpl @Autowired constructor(
    private val themeRepository: ThemeRepository,
    private val farmThemeRepository: FarmThemeRepository,
    private val themeAttachmentService: ThemeAttachmentService,
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
    override fun create(themeCreateUpdateDto: ThemeCreateUpdateDto): ThemeReadDto {
        if (themeCreateUpdateDto.themeAttachmentFile == null)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "테마 이미지는 필수입니다.")

        return themeRepository.save(themeCreateUpdateDto.toEntity()).also { theme ->
            theme.themeAttachment = themeAttachmentService.addAttachment(theme, themeCreateUpdateDto.themeAttachmentFile)
        }.toReadDto()
    }

    @Transactional
    override fun update(id: Long, themeCreateUpdateDto: ThemeCreateUpdateDto): ThemeReadDto {
        val theme = themeRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 테마가 존재하지 않습니다.") }

        if (themeCreateUpdateDto.themeAttachmentFile == null && themeCreateUpdateDto.themeAttachment == null)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "테마 이미지는 필수입니다.")

        theme.updateEntity(themeCreateUpdateDto = themeCreateUpdateDto)
        if (themeCreateUpdateDto.themeAttachmentFile != null)
            theme.themeAttachment = themeAttachmentService.updateAttachment(theme, themeCreateUpdateDto.themeAttachmentFile)

        return theme.toReadDto()
    }

    @Transactional
    override fun createThemesOfFarm(farm: Farm, themeIds: List<Long>) {
        themeRepository.findAllById(themeIds).map { theme ->
            farm.themes.add(FarmTheme(farm, theme))
        }
        farmThemeRepository.saveAll(farm.themes)
    }

    @Transactional
    override fun updateThemesOfFarm(farm: Farm, themeIds: List<Long>) {
        farmThemeRepository.deleteAll(farm.themes)
        farm.themes.clear()

        createThemesOfFarm(farm, themeIds)
    }
}