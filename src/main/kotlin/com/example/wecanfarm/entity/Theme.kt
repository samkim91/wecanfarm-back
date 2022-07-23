package com.example.wecanfarm.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "themes")
class Theme(
    @Column(nullable = false, length = 64, unique = true)
    var name: String,

    @Column(nullable = false, length = 64, unique = true)
    var code: String,

    @Column(nullable = false)
    var priority: Int = 0,

    @OneToMany(mappedBy = "theme")
    var farms: MutableList<FarmTheme>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,
)