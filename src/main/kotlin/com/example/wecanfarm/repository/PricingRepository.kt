package com.example.wecanfarm.repository;

import com.example.wecanfarm.entity.Pricing
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PricingRepository : JpaRepository<Pricing, Long> {
}