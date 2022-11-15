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
                    name = file.originalFilename ?: fileName,
                    type = if (file.contentType?.contains("image") == true) FileType.IMAGE else FileType.FILE,
                    size = file.size
                )
            ).also { farmAttachment ->
                farm.images.add(farmAttachment)
            }
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
        // TODO: 이미지 업데이트가 제대로 되지 않는 문제 수정 필요!!!
        // https://stackoverflow.com/questions/56559751/how-to-filter-two-lists-in-kotlin
        // 리스트 아이디 필터 기능으로 남겨지는 파일목록을 엔터티에서 남기고 나머지는 제외한다.
        // 위 방법도 안됨 ... 더 연구 필요..

        farm.images.map { image -> image.toReadDto() }.let { originalImages ->
            s3Service.deleteFiles(originalImages.minus(leftFiles.toSet()).map {farmAttachmentReadDto -> farmAttachmentReadDto.s3FileName })
        }

        farm.images.filter { image -> image.id in leftFiles.map { it.id } }.let {
            farm.images.clear()
            farm.images.addAll(it)

            farmAttachmentRepository.flush()
        }
    }

    @Transactional
    override fun removeAttachment(attachmentReadDto: FarmAttachmentReadDto) {
        s3Service.deleteFile(attachmentReadDto.s3FileName)
        farmAttachmentRepository.deleteById(attachmentReadDto.id)
    }

    @Transactional
    override fun removeAttachments(attachmentReadDtos: List<FarmAttachmentReadDto>) {
        s3Service.deleteFiles(attachmentReadDtos.map { attachment -> attachment.s3FileName })
        farmAttachmentRepository.deleteAllById(attachmentReadDtos.map { it.id })

    }
}