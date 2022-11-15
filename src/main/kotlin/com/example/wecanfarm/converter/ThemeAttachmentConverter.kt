package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.theme_attachment.ThemeAttachmentReadDto
import com.example.wecanfarm.entity.ThemeAttachment


fun ThemeAttachment.toReadDto() =
    ThemeAttachmentReadDto(
        s3FileName = s3FileName,
        url = url,
        name = name,
        type = type,
        size = size,
        id = id!!,
    )
