package com.example.wecanfarm.service

import com.example.wecanfarm.dto.theme.ThemeCreateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.theme.ThemeUpdateDto

interface ThemeService {

    fun findById(id: Long): ThemeReadDto
    fun createTheme(themeCreateDto: ThemeCreateDto): ThemeReadDto
    fun updateTheme(id: Long, themeUpdateDto: ThemeUpdateDto): ThemeReadDto
}