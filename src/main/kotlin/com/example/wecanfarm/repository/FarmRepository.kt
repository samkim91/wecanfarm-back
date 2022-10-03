package com.example.wecanfarm.repository

import com.example.wecanfarm.entity.Farm
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FarmRepository : JpaRepository<Farm, Long> {


    @Query(
        "select f from Farm f " +
                "left join f.themes ft " +
                "inner join ft.theme t " +
                "where (:search is null " +
                "or f.name like %:search% " +
                "or f.mainPhone like %:search% " +
                "or f.altPhone like %:search% " +
                "or f.address like %:search% " +
                "or f.detailAddress like %:search% " +
                "or f.directions like %:search% " +
                "or f.hashTags like %:search% " +
                "or f.conveniences like %:search% " +
                "or f.adminNotes like %:search% " +
                "or t.name like %:search%) "
    )
    fun findAllBySearchAndFilters(search: String?, pageable: Pageable): Page<Farm>

    fun findByNameContains(name: String): Optional<Farm>

}