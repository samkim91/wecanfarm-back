package com.example.wecanfarm.service.theme_attachment

import com.example.wecanfarm.entity.Theme
import com.example.wecanfarm.entity.ThemeAttachment
import org.springframework.web.multipart.MultipartFile

interface ThemeAttachmentService {


    fun addAttachment(theme: Theme, file: MultipartFile) : ThemeAttachment
    fun updateAttachment(theme: Theme, file: MultipartFile) : ThemeAttachment
    fun removeAttachment(attachment: ThemeAttachment)
}