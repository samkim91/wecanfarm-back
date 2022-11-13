package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.url.UrlCreateUpdateDto
import com.example.wecanfarm.dto.url.UrlReadDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.Url


fun Url.toReadDto() =
    UrlReadDto(
        address = address,
        type = type
    )

fun UrlCreateUpdateDto.toEntity(farm: Farm) =
    Url(
        farm = farm,
        address = address,
        type = type
    )