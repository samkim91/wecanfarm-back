package com.example.wecanfarm.dto.theme

import com.example.wecanfarm.dto.theme_attachment.ThemeAttachmentReadDto
import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class ThemeCreateUpdateDto(
    @field:NotBlank(message = "테마이름은 필수입니다.")
    val name: String,

    @field:NotBlank(message = "테마코드는 필수입니다.")
    @field:Pattern(regexp = "^[A-Z_]*\$", message = "테마코드는 대문자와 _만 가능합니다.")
    val code: String,

    @field:NotNull(message = "우선순위는 필수입니다.")
    val priority: Int,

    @field:NotNull(message = "활성여부는 필수입니다.")
    val isActive: Boolean,

    val themeAttachment: ThemeAttachmentReadDto?,
    val themeAttachmentFile: MultipartFile?,
)
