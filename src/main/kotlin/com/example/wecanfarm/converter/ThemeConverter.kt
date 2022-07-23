package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.theme.ThemeCreateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.theme.ThemeUpdateDto
import com.example.wecanfarm.entity.Theme


fun Theme.toReadDto() =
    ThemeReadDto(
        id = id ?: 0,
        name = name,
        code = code,
        priority = priority,
    )

fun Theme.updateEntity(themeUpdateDto: ThemeUpdateDto) {
    name = themeUpdateDto.name
    code = themeUpdateDto.code
    priority = themeUpdateDto.priority
}

fun ThemeCreateDto.toEntity() =
    Theme(
        name = name,
        code = code,
        farms = mutableListOf(),
        priority = priority,
    )

