package com.example.wecanfarm.dto.theme_attachment

import com.example.wecanfarm.enums.FileType

data class ThemeAttachmentReadDto(
    val url: String,
    val name: String,
    val type: FileType,
    val size: Long,
    val id: Long,
)
