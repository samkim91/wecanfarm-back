package com.example.wecanfarm.converter.farm

import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.dto.farm.FarmUpdateDto
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
        isReservationCancelable = isReservationCancelable,
        refundPolicy = refundPolicy ?: "",
        adminNotes = adminNotes ?: "",
        isActive = isActive,
        id = id ?: 0,
    )

fun Farm.updateEntity(farmUpdateDto: FarmUpdateDto) {
    this.name = farmUpdateDto.name
    this.mainPhone = farmUpdateDto.mainPhone
    this.altPhone = farmUpdateDto.altPhone
    this.address = farmUpdateDto.address
    this.detailAddress = farmUpdateDto.detailAddress
    this.directions = farmUpdateDto.directions
    this.email = farmUpdateDto.email
    this.webUrl = farmUpdateDto.webUrl
    this.mainSnsUrl = farmUpdateDto.mainSnsUrl
    this.altSnsUrl = farmUpdateDto.altSnsUrl
    this.ownerNotes = farmUpdateDto.ownerNotes
    this.hashTags = farmUpdateDto.hashTags
    this.isReservationCancelable = farmUpdateDto.isReservationCancelable
    this.refundPolicy = farmUpdateDto.refundPolicy
    this.adminNotes = farmUpdateDto.adminNotes
    this.isActive = farmUpdateDto.isActive
}

fun FarmCreateDto.toEntity() =
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
        isReservationCancelable = isReservationCancelable,
        refundPolicy = refundPolicy,
        adminNotes = adminNotes,
        isActive = isActive,
    )

