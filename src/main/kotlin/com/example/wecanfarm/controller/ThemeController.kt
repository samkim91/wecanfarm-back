package com.example.wecanfarm.controller

import com.example.wecanfarm.dto.theme.ThemeCreateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.theme.ThemeUpdateDto
import com.example.wecanfarm.service.ThemeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/themes")
class ThemeController @Autowired constructor(
    private val themeService: ThemeService,
) : BaseController() {

    @GetMapping
    fun getList(
        search: String?,
        pageable: Pageable
    ): ResponseEntity<Page<ThemeReadDto>> {
        return ResponseEntity.ok(themeService.getList(search, pageable))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<ThemeReadDto> {
        return ResponseEntity.ok(themeService.get(id))
    }

    @PostMapping
    fun create(@Valid themeCreateDto: ThemeCreateDto): ResponseEntity<ThemeReadDto> {
        return ResponseEntity.ok(themeService.create(themeCreateDto))
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @Valid themeUpdateDto: ThemeUpdateDto): ResponseEntity<ThemeReadDto> {
        return ResponseEntity.ok(themeService.update(id, themeUpdateDto))
    }
}