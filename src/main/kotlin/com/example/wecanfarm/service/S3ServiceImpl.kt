package com.example.wecanfarm.service

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.DeleteObjectsRequest
import com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.util.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.util.*

// references : https://devlog-wjdrbs96.tistory.com/403

@Service
class S3ServiceImpl @Autowired constructor(
    private val s3Client: AmazonS3Client
) : BaseService(), S3Service {

    @Value("\${cloud.aws.s3.bucket}")
    lateinit var bucket: String

    override fun uploadFile(file: MultipartFile): Pair<String, String> {
        val fileName = UUID.randomUUID().toString()
        val objectMeta = ObjectMetadata()

        val bytes = IOUtils.toByteArray(file.inputStream)
        objectMeta.contentLength = bytes.size.toLong()

        val byteArrayInputStream = ByteArrayInputStream(bytes)

        s3Client.putObject(
            PutObjectRequest(bucket, fileName, byteArrayInputStream, objectMeta).withCannedAcl(
                CannedAccessControlList.PublicRead
            )
        )

        return Pair(s3Client.getUrl(bucket, fileName).toString(), fileName)
    }

    override fun uploadFiles(files: List<MultipartFile>): List<Pair<String, String>> {
        return files.map { uploadFile(it) }
    }

    override fun deleteFile(s3FileName: String) {
        s3Client.deleteObject(bucket, s3FileName)
    }

    override fun deleteFiles(s3FileNames: List<String>) {
        DeleteObjectsRequest(bucket)
            .withKeys(s3FileNames.map { s3FileName -> KeyVersion(s3FileName) })
            .withQuiet(false)
            .let { deleteObjectsRequest ->
                s3Client.deleteObjects(deleteObjectsRequest).deletedObjects.size
            }
    }
}