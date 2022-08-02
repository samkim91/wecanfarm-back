package com.example.wecanfarm.service

import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.FarmAttachment
import org.springframework.web.multipart.MultipartFile

interface FarmAttachmentService {


    fun uploadFiles(farm: Farm, files: List<MultipartFile>)
    fun uploadFile(farm: Farm, file: MultipartFile)
    fun deleteFile(farm: Farm, attachment: FarmAttachment)
    fun deleteFiles(farm: Farm, attachments: List<FarmAttachment>)
}