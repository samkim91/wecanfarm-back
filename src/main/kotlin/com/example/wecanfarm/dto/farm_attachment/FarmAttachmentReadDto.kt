package com.example.wecanfarm.dto.farm_attachment

import com.example.wecanfarm.enums.FileType

data class FarmAttachmentReadDto(
    val url: String,
    val name: String,
    val type: FileType,
    val size: Long,
    val id: Long,
)
