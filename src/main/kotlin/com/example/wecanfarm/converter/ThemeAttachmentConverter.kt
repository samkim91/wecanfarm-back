package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.theme_attachment.ThemeAttachmentReadDto
import com.example.wecanfarm.entity.ThemeAttachment


fun ThemeAttachment.toReadDto() =
    ThemeAttachmentReadDto(
        url = url,
        name = name,
        type = type,
        size = size,
        id = id!!,
    )
