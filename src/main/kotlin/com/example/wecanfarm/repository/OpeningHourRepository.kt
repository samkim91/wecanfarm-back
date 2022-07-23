package com.example.wecanfarm.repository;

import com.example.wecanfarm.entity.OpeningHour
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OpeningHourRepository : JpaRepository<OpeningHour, Long> {
}