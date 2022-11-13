package com.example.wecanfarm.service.s3

import org.springframework.web.multipart.MultipartFile

interface S3Service {

    fun uploadFile(file : MultipartFile): Pair<String, String>
    fun uploadFiles(files: List<MultipartFile>): List<Pair<String, String>>
    fun deleteFile(s3FileName: String)
    fun deleteFiles(s3FileNames: List<String>)

}