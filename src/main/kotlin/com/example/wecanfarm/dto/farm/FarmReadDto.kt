package com.example.wecanfarm.dto.farm

import com.example.wecanfarm.dto.farm_attachment.FarmAttachmentReadDto
import com.example.wecanfarm.dto.opening_hour.OpeningHourReadDto
import com.example.wecanfarm.dto.pricing.PricingReadDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.url.UrlReadDto

data class FarmReadDto(
    val name: String,
    val mainPhone: String,
    val altPhone: String,
    val address: String,
    val detailAddress: String,
    val directions: String,
    val email: String,
    val ownerNotes: String,
    val hashTags: String,
    val conveniences: String,
    val isReservationCancelable: Boolean,
    val refundPolicy: String,
    val adminNotes: String,
    val isActive: Boolean,
    val themes: List<ThemeReadDto>,
    val openingHours: List<OpeningHourReadDto>,
    val pricing: List<PricingReadDto>,
    val images: List<FarmAttachmentReadDto>,
    val urls: List<UrlReadDto>,
    val id: Long,
)
