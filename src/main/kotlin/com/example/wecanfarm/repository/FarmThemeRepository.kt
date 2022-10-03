package com.example.wecanfarm.repository

import com.example.wecanfarm.entity.FarmTheme
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FarmThemeRepository : JpaRepository<FarmTheme, Long>