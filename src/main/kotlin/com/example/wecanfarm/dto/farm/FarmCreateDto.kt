package com.example.wecanfarm.dto.farm

import com.example.wecanfarm.entity.Farm

data class FarmCreateDto(
    val name: String,
    val mainPhone: String,
    val altPhone: String?,
    val address: String,
    val detailAddress: String?,
    val directions: String?,
    val email: String?,
    val webUrl: String?,
    val mainSnsUrl: String?,
    val altSnsUrl: String?,
    val ownerNotes: String?,
    val hashTags: String?,
    val isReservationCancelable: Boolean,
    val refundPolicy: String?,
    val adminNotes: String?,
    val isActive: Boolean,
) {
    companion object {
        fun toEntity(farmCreateDto: FarmCreateDto): Farm {
            return Farm(
                name = farmCreateDto.name,
                mainPhone = farmCreateDto.mainPhone,
                altPhone = farmCreateDto.altPhone,
                address = farmCreateDto.address,
                detailAddress = farmCreateDto.detailAddress,
                directions = farmCreateDto.directions,
                email = farmCreateDto.email,
                webUrl = farmCreateDto.webUrl,
                mainSnsUrl = farmCreateDto.mainSnsUrl,
                altSnsUrl = farmCreateDto.altSnsUrl,
                ownerNotes = farmCreateDto.ownerNotes,
                hashTags = farmCreateDto.hashTags,
                isReservationCancelable = farmCreateDto.isReservationCancelable,
                refundPolicy = farmCreateDto.refundPolicy,
                adminNotes = farmCreateDto.adminNotes,
                isActive = farmCreateDto.isActive,
            )
        }
    }
}
