package com.example.wecanfarm.repository

import com.example.wecanfarm.entity.Farm
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FarmRepository : JpaRepository<Farm, Long> {

    fun findByNameContains(name: String) : Optional<Farm>

}