package com.example.wecanfarm.controller

import com.example.wecanfarm.dto.farm.FarmCreateUpdateDto
import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.service.FarmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/farms")
class FarmController @Autowired constructor(
    private val farmService: FarmService,
) : BaseController() {


    @GetMapping
    fun getList(search: String?, pageable: Pageable): ResponseEntity<Page<FarmReadDto>> {
        return ResponseEntity.ok(farmService.getList(search, pageable))
    }

    @GetMapping("/{id}")
    fun getFarm(@PathVariable id: Long): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.get(id))
    }

    @PostMapping
    fun createFarm(@RequestBody @Valid farmCreateUpdateDto: FarmCreateUpdateDto): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.create(farmCreateUpdateDto))
    }

    @PostMapping("{id}")
    fun updateFarm(@PathVariable id: Long, @RequestBody @Valid farmCreateUpdateDto: FarmCreateUpdateDto): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.update(id, farmCreateUpdateDto))
    }
}

// TODO: 2022/07/12 validation message 모아두기
// https://jaimemin.tistory.com/1870
// https://oingdaddy.tistory.com/266