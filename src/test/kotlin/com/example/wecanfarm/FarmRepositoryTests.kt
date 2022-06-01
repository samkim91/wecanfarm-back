package com.example.wecanfarm

import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.repository.FarmRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest

@DataJpaTest
class FarmRepositoryTests @Autowired constructor(
    val farmRepository: FarmRepository,
) {

    @Test
    fun `find farm by name`() {
        println(">> startTest")
        val farm = Farm("위캔팜", "010", "101", "가나", "다라", "가능", "가나","가나","가나","가나","가나","가나",true, "가나", "가나", false)

        farmRepository.save(farm)
//        farmRepository.flush()

        val savedFarm = farmRepository.findByNameContains("캔팜")

        println(">> endTest ${savedFarm?.id}")
        assertThat(farm).isEqualTo(savedFarm)
    }
}
