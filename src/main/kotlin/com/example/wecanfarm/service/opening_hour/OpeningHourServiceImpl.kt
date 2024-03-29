package com.example.wecanfarm.service.opening_hour

import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.dto.opening_hour.OpeningHourCreateUpdateDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.repository.OpeningHourRepository
import com.example.wecanfarm.service.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OpeningHourServiceImpl @Autowired constructor(
    private val openingHourRepository: OpeningHourRepository,
) : BaseService(), OpeningHourService {

    @Transactional
    override fun createOpeningHoursOfFarm(farm: Farm, openingHours: List<OpeningHourCreateUpdateDto>) {
        openingHours.map { openingHourCreateUpdateDto ->
            farm.openingHours.add(openingHourCreateUpdateDto.toEntity(farm))
        }
        openingHourRepository.saveAll(farm.openingHours)
    }

    @Transactional
    override fun updateOpeningHoursOfFarm(farm: Farm, openingHours: List<OpeningHourCreateUpdateDto>) {
        openingHourRepository.deleteAll(farm.openingHours)
        farm.openingHours.clear()

        openingHourRepository.flush()
        createOpeningHoursOfFarm(farm, openingHours)
    }


}