package com.example.wecanfarm.service

import com.example.wecanfarm.entity.Theme
import com.example.wecanfarm.entity.ThemeAttachment
import org.springframework.web.multipart.MultipartFile

interface ThemeAttachmentService {


    fun addAttachment(theme: Theme, file: MultipartFile)
    fun updateAttachment(theme: Theme, file: MultipartFile)
    fun removeAttachment(attachment: ThemeAttachment)
}