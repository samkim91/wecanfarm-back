package com.example.wecanfarm.service.farm_attachment

import com.example.wecanfarm.converter.toReadDto
import com.example.wecanfarm.dto.farm_attachment.FarmAttachmentReadDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.FarmAttachment
import com.example.wecanfarm.enums.FileType
import com.example.wecanfarm.repository.FarmAttachmentRepository
import com.example.wecanfarm.service.BaseService
import com.example.wecanfarm.service.s3.S3Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class FarmAttachmentServiceImpl @Autowired constructor(
    private val farmAttachmentRepository: FarmAttachmentRepository,
    private val s3Service: S3Service,
) : BaseService(), FarmAttachmentService {

    @Transactional
    override fun addAttachment(farm: Farm, file: MultipartFile) {
        s3Service.uploadFile(file).let { (url, fileName) ->
            farmAttachmentRepository.save(
                FarmAttachment(
                    farm = farm,
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
    override fun addAttachments(farm: Farm, files: List<MultipartFile>) {
        files.map { file ->
            addAttachment(farm, file)
        }
    }

    @Transactional
    override fun updateLeftFiles(farm: Farm, leftFiles: List<FarmAttachmentReadDto>) {
        farm.images.map { image -> image.toReadDto() }.let { originalImages ->
            originalImages.minus(leftFiles.toSet()).let { deletedImages ->
                deletedImages.map { deletedImage -> deletedImage.name }.let { deletedImageNames ->
                    s3Service.deleteFiles(deletedImageNames)
                }
            }
        }
    }

    @Transactional
    override fun removeAttachment(attachment: FarmAttachment) {
        s3Service.deleteFile(attachment.s3FileName)
        farmAttachmentRepository.delete(attachment)
    }

    @Transactional
    override fun removeAttachments(attachments: List<FarmAttachment>) {
        s3Service.deleteFiles(attachments.map { attachment -> attachment.s3FileName })
        farmAttachmentRepository.deleteAll(attachments)
    }
}