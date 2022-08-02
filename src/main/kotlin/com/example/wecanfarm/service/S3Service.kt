package com.example.wecanfarm.service

import org.springframework.web.multipart.MultipartFile

interface S3Service {

    fun uploadFile(file : MultipartFile): String
    fun uploadFiles(files: List<MultipartFile>): List<String>
}