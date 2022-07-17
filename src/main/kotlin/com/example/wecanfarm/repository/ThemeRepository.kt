package com.example.wecanfarm.repository

import com.example.wecanfarm.entity.Theme
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ThemeRepository : JpaRepository<Theme, Long>