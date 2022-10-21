package com.example.wecanfarm.controller

import com.example.wecanfarm.enums.SnsType
import com.example.wecanfarm.service.OptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/options")
class OptionController @Autowired constructor(
    private val optionService: OptionService
) : BaseController() {

    @GetMapping("/sns")
    fun getSnsOptions(): ResponseEntity<List<SnsType>> {
        return ResponseEntity.ok(optionService.getSnsOptions())
    }

}