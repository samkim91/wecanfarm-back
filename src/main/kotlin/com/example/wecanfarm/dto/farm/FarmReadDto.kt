package com.example.wecanfarm.dto.farm

import com.example.wecanfarm.dto.theme.ThemeReadDto

data class FarmReadDto(
    val name: String,
    val themes: List<ThemeReadDto?>,
    val mainPhone: String,
    val altPhone: String,
    val address: String,
    val detailAddress: String,
    val directions: String,
    val email: String,
    val webUrl: String,
    val mainSnsUrl: String,
    val altSnsUrl: String,
    val ownerNotes: String,
    val hashTags: String,
    val isReservationCancelable: Boolean,
    val refundPolicy: String,
    val adminNotes: String,
    val isActive: Boolean,
    val id: Long,
)
