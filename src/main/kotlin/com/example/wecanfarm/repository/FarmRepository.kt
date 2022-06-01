package com.example.wecanfarm.repository

import com.example.wecanfarm.entity.Farm
import org.springframework.data.jpa.repository.JpaRepository

interface FarmRepository : JpaRepository<Farm, Long> {

    fun findByNameContains(name: String) : Farm?

}