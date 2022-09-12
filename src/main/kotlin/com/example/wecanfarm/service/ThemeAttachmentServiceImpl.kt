package com.example.wecanfarm.service

import com.example.wecanfarm.entity.Theme
import com.example.wecanfarm.entity.ThemeAttachment
import com.example.wecanfarm.enums.FileType
import com.example.wecanfarm.repository.ThemeAttachmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class ThemeAttachmentServiceImpl @Autowired constructor(
    private val themeAttachmentRepository: ThemeAttachmentRepository,
    private val s3Service: S3Service,
) : BaseService(), ThemeAttachmentService {

    @Transactional
    override fun addAttachment(theme: Theme, file: MultipartFile) {
        s3Service.uploadFile(file).let { (url, fileName) ->
            themeAttachmentRepository.save(
                ThemeAttachment(
                    theme = theme,
                    s3FileName = fileName,
                    url = url,
                    name = file.name,
                    type = if (file.contentType?.contains("image") == true) FileType.IMAGE else FileType.FILE,
                    size = file.size
                )
            )
        }
    }

    @Transactional
    override fun updateAttachment(theme: Theme, file: MultipartFile) {
        theme.themeAttachment?.let { removeAttachment(it) }
        addAttachment(theme, file)
    }

    @Transactional
    override fun removeAttachment(attachment: ThemeAttachment) {
        s3Service.deleteFile(attachment.s3FileName)
        themeAttachmentRepository.delete(attachment)
    }
}