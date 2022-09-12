package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.theme.ThemeCreateUpdateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.entity.Theme


fun Theme.toReadDto() =
    ThemeReadDto(
        id = id!!,
        name = name,
        code = code,
        priority = priority,
        isActive = isActive,
        themeAttachment = themeAttachment!!.toReadDto(),
    )

fun Theme.updateEntity(themeCreateUpdateDto: ThemeCreateUpdateDto) {
    name = themeCreateUpdateDto.name
    code = themeCreateUpdateDto.code
    priority = themeCreateUpdateDto.priority
    isActive = themeCreateUpdateDto.isActive
}

fun ThemeCreateUpdateDto.toEntity() =
    Theme(
        name = name,
        code = code,
        priority = priority,
        isActive = isActive,
        farms = mutableListOf(),
        themeAttachment = null,
    )

