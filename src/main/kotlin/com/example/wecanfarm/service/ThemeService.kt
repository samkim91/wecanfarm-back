package com.example.wecanfarm.service

import com.example.wecanfarm.dto.theme.ThemeCreateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.theme.ThemeUpdateDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ThemeService {

    fun get(id: Long): ThemeReadDto
    fun create(themeCreateDto: ThemeCreateDto): ThemeReadDto
    fun update(id: Long, themeUpdateDto: ThemeUpdateDto): ThemeReadDto
    fun getList(search: String?, pageable: Pageable): Page<ThemeReadDto>
}