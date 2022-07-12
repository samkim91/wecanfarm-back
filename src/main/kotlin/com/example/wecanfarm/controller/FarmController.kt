package com.example.wecanfarm.controller

import com.example.wecanfarm.dto.farm.FarmCreateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.converter.farm.toEntity
import com.example.wecanfarm.converter.farm.toReadDto
import com.example.wecanfarm.dto.farm.FarmUpdateDto
import com.example.wecanfarm.service.FarmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/farms")
class FarmController @Autowired constructor(
    private val farmService: FarmService,
) : BaseController() {


    @GetMapping("/{id}")
    fun getFarm(@PathVariable id: Long): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.findById(id))
    }

    @PostMapping()
    fun createFarm(@Valid farmCreateDto: FarmCreateDto): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.insertFarm(farmCreateDto))
    }

    @PostMapping("{id}")
    fun updateFarm(@PathVariable id: Long, @Valid farmUpdateDto: FarmUpdateDto): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.updateFarm(id, farmUpdateDto))
    }
}

// TODO: 2022/07/12 validation message 모아두기
// https://jaimemin.tistory.com/1870
// https://oingdaddy.tistory.com/266