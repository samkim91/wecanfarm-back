package com.example.wecanfarm.controller

import com.example.wecanfarm.dto.farm.FarmReadDto
import com.example.wecanfarm.service.farm.FarmService
import com.example.wecanfarm.util.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
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
    fun createFarm(
        @RequestPart("farmCreateUpdateDto") @Valid farmCreateUpdateDtoJson: String,
        @RequestPart(required = false) imageFiles: List<MultipartFile>?
    ): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(farmService.create(jacksonObjectMapper.readValue(farmCreateUpdateDtoJson), imageFiles))
    }

    @PostMapping("{id}")
    fun updateFarm(
        @PathVariable id: Long,
        @RequestPart("farmCreateUpdateDto") @Valid farmCreateUpdateDtoJson: String,
        @RequestPart(required = false) imageFiles: List<MultipartFile>?
    ): ResponseEntity<FarmReadDto> {
        return ResponseEntity.ok(
            farmService.update(
                id,
                jacksonObjectMapper.readValue(farmCreateUpdateDtoJson),
                imageFiles
            )
        )
    }
}

// TODO: 2022/07/12 validation message 모아두기
// https://jaimemin.tistory.com/1870
// https://oingdaddy.tistory.com/266

// NOTE : post 에서 multipartFile 과 pojo 를 같이 받으려고 했는데 계속해서 415, 500, 400 등 에러가 발생했다.
// data class pojo 를 만드려고 했는데 data class 의 생성자 관련된 이슈가 있는 것 같다. 많은 자료를 찾아봤지만 결국 아래 내용을 참고해서 위처럼 작업했다.
// https://kapentaz.github.io/kotlin/json/Kotlin-and-Jackson-(ObjectMapper)/#
// https://www.baeldung.com/kotlin/jackson-kotlin