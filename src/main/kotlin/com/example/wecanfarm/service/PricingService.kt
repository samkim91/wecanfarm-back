package com.example.wecanfarm.service

import com.example.wecanfarm.dto.pricing.PricingCreateUpdateDto
import com.example.wecanfarm.entity.Farm

interface PricingService {

    fun createPricingOfFarm(farm: Farm, pricing: List<PricingCreateUpdateDto>)
    fun updatePricingOfFarm(farm: Farm, pricing: List<PricingCreateUpdateDto>)
}