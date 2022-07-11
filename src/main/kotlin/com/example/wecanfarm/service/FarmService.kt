package com.example.wecanfarm.service

import com.example.wecanfarm.entity.Farm

interface FarmService {

    fun findById(id: Long): Farm
    fun insertFarm(farm: Farm): Farm

    fun updateFarm(id: Long, farm: Farm): Farm
}