package com.example.wecanfarm.repository;

import com.example.wecanfarm.entity.Url
import org.springframework.data.jpa.repository.JpaRepository

interface UrlRepository : JpaRepository<Url, Long> {
}