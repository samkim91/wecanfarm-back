package com.example.wecanfarm.repository

import com.example.wecanfarm.entity.ThemeAttachment
import org.springframework.data.jpa.repository.JpaRepository

interface ThemeAttachmentRepository : JpaRepository<ThemeAttachment, Long>