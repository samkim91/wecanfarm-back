package com.example.wecanfarm.dto.theme

import javax.validation.constraints.NotBlank

data class ThemeUpdateDto(
    @NotBlank(message = "테마이름은 필수입니다.")
    val name: String,
)
