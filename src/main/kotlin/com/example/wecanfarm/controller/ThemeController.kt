package com.example.wecanfarm.controller

import com.example.wecanfarm.dto.theme.ThemeCreateDto
import com.example.wecanfarm.dto.theme.ThemeReadDto
import com.example.wecanfarm.dto.theme.ThemeUpdateDto
import com.example.wecanfarm.service.ThemeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/themes")
class ThemeController @Autowired constructor(
    private val themeService: ThemeService,
) : BaseController() {

    @GetMapping("/{id}")
    fun getTheme(@PathVariable id: Long): ResponseEntity<ThemeReadDto> {
        return ResponseEntity.ok(themeService.findById(id))
    }

    @PostMapping
    fun createTheme(@Valid themeCreateDto: ThemeCreateDto): ResponseEntity<ThemeReadDto> {
        return ResponseEntity.ok(themeService.createTheme(themeCreateDto))
    }

    @PutMapping("{id}")
    fun updateTheme(@PathVariable id: Long, @Valid themeUpdateDto: ThemeUpdateDto): ResponseEntity<ThemeReadDto> {
        return ResponseEntity.ok(themeService.updateTheme(id, themeUpdateDto))
    }
}