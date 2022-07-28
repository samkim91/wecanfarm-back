package com.example.wecanfarm.service

import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.dto.pricing.PricingCreateUpdateDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.repository.PricingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PricingServiceImpl @Autowired constructor(
    val pricingRepository: PricingRepository,
) : BaseService(), PricingService {

    @Transactional
    override fun createPricingOfFarm(farm: Farm, pricing: List<PricingCreateUpdateDto>) {
        pricing.map { pricingCreateUpdateDto ->
            farm.pricing.add(pricingCreateUpdateDto.toEntity(farm))
        }
        pricingRepository.saveAll(farm.pricing)
    }

    @Transactional
    override fun updatePricingOfFarm(farm: Farm, pricing: List<PricingCreateUpdateDto>) {
        pricingRepository.deleteAll(farm.pricing)
        farm.pricing.clear()

        createPricingOfFarm(farm, pricing)
    }


}