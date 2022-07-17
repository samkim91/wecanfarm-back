package com.example.wecanfarm.repository

import com.example.wecanfarm.entity.Theme
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ThemeRepository : JpaRepository<Theme, Long> {

    @Query(
        "select t from Theme t where (:search is null or t.name like %:search% or t.code like %:search%) "
    )
    fun findAllBySearchAndFilter(search: String?, pageable: Pageable?): Page<Theme>
}