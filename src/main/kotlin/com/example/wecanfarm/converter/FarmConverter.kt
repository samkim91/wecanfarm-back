package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.farm.FarmCreateUpdateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.entity.Farm


fun Farm.toReadDto() =
    FarmReadDto(
        name = name,
        mainPhone = mainPhone,
        altPhone = altPhone ?: "",
        address = address,
        detailAddress = detailAddress ?: "",
        directions = directions ?: "",
        email = email ?: "",
        webUrl = webUrl ?: "",
        mainSnsUrl = mainSnsUrl ?: "",
        altSnsUrl = altSnsUrl ?: "",
        ownerNotes = ownerNotes ?: "",
        hashTags = hashTags ?: "",
        conveniences = conveniences ?: "",
        isReservationCancelable = isReservationCancelable,
        refundPolicy = refundPolicy ?: "",
        adminNotes = adminNotes ?: "",
        isActive = isActive,
        themes = themes.map { farmTheme ->
            farmTheme.theme.toReadDto()
        },
        openingHours = openingHours.map { openingHour ->
            openingHour.toReadDto()
        },
        pricing = pricing.map { pricing -> pricing.toReadDto() },
        images = images.map { image -> image.toReadDto() },
        id = id!!,
    )

fun Farm.updateEntity(farmCreateUpdateDto: FarmCreateUpdateDto) {
    this.name = farmCreateUpdateDto.name
    this.mainPhone = farmCreateUpdateDto.mainPhone
    this.altPhone = farmCreateUpdateDto.altPhone
    this.address = farmCreateUpdateDto.address
    this.detailAddress = farmCreateUpdateDto.detailAddress
    this.directions = farmCreateUpdateDto.directions
    this.email = farmCreateUpdateDto.email
    this.webUrl = farmCreateUpdateDto.webUrl
    this.mainSnsUrl = farmCreateUpdateDto.mainSnsUrl
    this.altSnsUrl = farmCreateUpdateDto.altSnsUrl
    this.ownerNotes = farmCreateUpdateDto.ownerNotes
    this.hashTags = farmCreateUpdateDto.hashTags
    this.conveniences = farmCreateUpdateDto.conveniences
    this.isReservationCancelable = farmCreateUpdateDto.isReservationCancelable
    this.refundPolicy = farmCreateUpdateDto.refundPolicy
    this.adminNotes = farmCreateUpdateDto.adminNotes
    this.isActive = farmCreateUpdateDto.isActive
}

fun FarmCreateUpdateDto.toEntity() =
    Farm(
        name = name,
        mainPhone = mainPhone,
        altPhone = altPhone,
        address = address,
        detailAddress = detailAddress,
        directions = directions,
        email = email,
        webUrl = webUrl,
        mainSnsUrl = mainSnsUrl,
        altSnsUrl = altSnsUrl,
        ownerNotes = ownerNotes,
        hashTags = hashTags,
        conveniences = conveniences,
        isReservationCancelable = isReservationCancelable,
        refundPolicy = refundPolicy,
        adminNotes = adminNotes,
        isActive = isActive,
    )

