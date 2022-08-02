package com.example.wecanfarm.repository;

import com.example.wecanfarm.entity.FarmAttachment
import org.springframework.data.jpa.repository.JpaRepository

interface FarmAttachmentRepository : JpaRepository<FarmAttachment, Long> {
}