package com.example.wecanfarm.service.theme

import com.example.wecanfarm.dto.theme.ThemeCreateUpdateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.entity.Farm
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ThemeService {

    fun getList(search: String?, pageable: Pageable): Page<ThemeReadDto>
    fun get(id: Long): ThemeReadDto
    fun create(themeCreateUpdateDto: ThemeCreateUpdateDto): ThemeReadDto
    fun update(id: Long, themeCreateUpdateDto: ThemeCreateUpdateDto): ThemeReadDto
    fun createThemesOfFarm(farm: Farm, themeIds: List<Long>)
    fun updateThemesOfFarm(farm: Farm, themeIds: List<Long>)
}