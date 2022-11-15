package com.example.wecanfarm.service.farm

import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.converter.toReadDto
import com.example.wecanfarm.converter.updateEntity
import com.example.wecanfarm.dto.farm.FarmCreateUpdateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.repository.FarmRepository
import com.example.wecanfarm.service.*
import com.example.wecanfarm.service.farm_attachment.FarmAttachmentService
import com.example.wecanfarm.service.opening_hour.OpeningHourService
import com.example.wecanfarm.service.pricing.PricingService
import com.example.wecanfarm.service.theme.ThemeService
import com.example.wecanfarm.service.url.UrlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException

@Service
class FarmServiceImpl @Autowired constructor(
    private val farmRepository: FarmRepository,
    private val themeService: ThemeService,
    private val openingHourService: OpeningHourService,
    private val pricingService: PricingService,
    private val farmAttachmentService: FarmAttachmentService,
    private val urlService: UrlService,
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
    override fun create(farmCreateUpdateDto: FarmCreateUpdateDto, imageFiles: List<MultipartFile>?): FarmReadDto {
        val farm = farmRepository.save(farmCreateUpdateDto.toEntity())

        themeService.createThemesOfFarm(farm, farmCreateUpdateDto.themeIds)
        farmCreateUpdateDto.openingHours?.let {
            openingHourService.createOpeningHoursOfFarm(farm, it)
        }
        farmCreateUpdateDto.pricing?.let {
            pricingService.createPricingOfFarm(farm, it)
        }
        imageFiles?.let {
            farmAttachmentService.addAttachments(farm, it)
        }
        farmCreateUpdateDto.urls?.let {
            urlService.createUrls(farm, it)
        }

        return farm.toReadDto()
    }

    @Transactional
    override fun update(
        id: Long,
        farmCreateUpdateDto: FarmCreateUpdateDto,
        imageFiles: List<MultipartFile>?
    ): FarmReadDto {
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
        farmCreateUpdateDto.images?.let {
            farmAttachmentService.updateLeftFiles(farm, it)
        }
        imageFiles?.let {
            farmAttachmentService.addAttachments(farm, it)
        }
        farmCreateUpdateDto.urls?.let {
            urlService.updateUrls(farm, it)
        }

        return farm.toReadDto()
    }
}