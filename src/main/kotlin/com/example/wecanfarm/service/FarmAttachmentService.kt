package com.example.wecanfarm.service

import com.example.wecanfarm.dto.farm_attachment.FarmAttachmentReadDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.FarmAttachment
import org.springframework.web.multipart.MultipartFile

interface FarmAttachmentService {


    fun addAttachment(farm: Farm, file: MultipartFile)
    fun addAttachments(farm: Farm, files: List<MultipartFile>)
    fun updateLeftFiles(farm: Farm, leftFiles: List<FarmAttachmentReadDto>)
    fun removeAttachment(attachment: FarmAttachment)
    fun removeAttachments(attachments: List<FarmAttachment>)
}