package com.example.wecanfarm.service

import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.entity.FarmAttachment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
class FarmAttachmentServiceImpl @Autowired constructor(

) : BaseService(), FarmAttachmentService {
    override fun uploadFiles(farm: Farm, files: List<MultipartFile>) {
        TODO("Not yet implemented")
    }

    override fun uploadFile(farm: Farm, file: MultipartFile) {
        TODO("Not yet implemented")
    }

    override fun deleteFile(farm: Farm, attachment: FarmAttachment) {
        TODO("Not yet implemented")
    }

    override fun deleteFiles(farm: Farm, attachments: List<FarmAttachment>) {
        TODO("Not yet implemented")
    }

}