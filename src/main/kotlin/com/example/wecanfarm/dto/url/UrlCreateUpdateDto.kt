package com.example.wecanfarm.dto.url

import com.example.wecanfarm.enums.SnsType
import java.sql.Time
import java.time.DayOfWeek
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class  UrlCreateUpdateDto(
    @field:NotNull(message = "주소는 필수입니다.")
    @field:Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$", message = "요일은 대문자로 보내주세요.")
    val address: String,
    @field:NotNull(message = "주소 타입은 필수입니다.")
    val type: SnsType,
)
