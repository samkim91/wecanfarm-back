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

fun FarmUpdateDto.toEntity() =
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

