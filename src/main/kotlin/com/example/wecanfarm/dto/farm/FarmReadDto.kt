package com.example.wecanfarm.dto.farm

import com.example.wecanfarm.entity.Farm

data class FarmReadDto(
    val name: String,
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
) {
    companion object {
        fun fromEntity(farm: Farm): FarmReadDto {
            return FarmReadDto(
                name = farm.name,
                mainPhone = farm.mainPhone,
                altPhone = farm.altPhone ?: "",
                address = farm.address,
                detailAddress = farm.detailAddress ?: "",
                directions = farm.directions ?: "",
                email = farm.email ?: "",
                webUrl = farm.webUrl ?: "",
                mainSnsUrl = farm.mainSnsUrl ?: "",
                altSnsUrl = farm.altSnsUrl ?: "",
                ownerNotes = farm.ownerNotes ?: "",
                hashTags = farm.hashTags ?: "",
                isReservationCancelable = farm.isReservationCancelable,
                refundPolicy = farm.refundPolicy ?: "",
                adminNotes = farm.adminNotes ?: "",
                isActive = farm.isActive,
                id = farm.id!!,
            )
        }
    }
}
