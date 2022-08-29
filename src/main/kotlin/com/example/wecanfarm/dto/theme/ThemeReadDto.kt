package com.example.wecanfarm.dto.theme

import com.example.wecanfarm.dto.theme_attachment.ThemeAttachmentReadDto

data class ThemeReadDto(
    val id: Long,
    val name: String,
    val code: String,
    val priority: Int,
    val image: ThemeAttachmentReadDto,
)
