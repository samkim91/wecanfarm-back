package com.example.wecanfarm.converter.farm

import com.example.wecanfarm.dto.theme.ThemeCreateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.theme.ThemeUpdateDto
import com.example.wecanfarm.entity.Theme


fun Theme.toReadDto() =
    ThemeReadDto(
        id = id ?: 0,
        name = name,
    )

fun Theme.updateEntity(themeUpdateDto: ThemeUpdateDto) {
    this.name = themeUpdateDto.name
}

fun ThemeCreateDto.toEntity() =
    Theme(
        name = name
    )

