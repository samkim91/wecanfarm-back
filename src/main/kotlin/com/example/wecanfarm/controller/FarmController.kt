package com.example.wecanfarm.controller

import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.service.FarmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/farm")
class FarmController @Autowired constructor(
    private val farmService: FarmService,
) : BaseController() {

    @GetMapping("/{id}")
    fun findFarm(@PathVariable id: Long): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.findById(id))
    }

    @PostMapping()
    fun insertFarm(@RequestBody farmCreateDto: FarmCreateDto): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.insertFarm(farmCreateDto))
    }
}