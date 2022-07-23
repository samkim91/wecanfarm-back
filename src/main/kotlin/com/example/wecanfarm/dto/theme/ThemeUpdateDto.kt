package com.example.wecanfarm.dto.theme

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ThemeUpdateDto(
    @field:NotBlank(message = "테마이름은 필수입니다.")
    val name: String,

    @field:NotBlank(message = "테마코드는 필수입니다.")
    val code: String,

    @field:NotNull(message = "우선순위는 필수입니다.")
    val priority: Int,
)
