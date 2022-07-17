package com.example.wecanfarm.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "themes")
class Theme(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(nullable = false, length = 64)
    var name: String,

    @OneToMany(mappedBy = "theme")
    var farms: MutableList<FarmTheme> = mutableListOf(),
)