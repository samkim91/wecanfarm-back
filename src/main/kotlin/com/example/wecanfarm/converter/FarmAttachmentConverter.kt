package com.example.wecanfarm.converter

import com.example.wecanfarm.dto.farm_attachment.FarmAttachmentReadDto
import com.example.wecanfarm.entity.FarmAttachment


fun FarmAttachment.toReadDto() =
    FarmAttachmentReadDto(
        s3FileName = s3FileName,
        url = url,
        name = name,
        type = type,
        size = size,
        id = id!!,
    )
