package com.example.wecanfarm.entity

import javax.persistence.*

@Entity
@Table(name = "farms_themes")
class FarmTheme(
    @ManyToOne
    @JoinColumn(name = "farm_id")
    var farm: Farm? = null,

    @ManyToOne
    @JoinColumn(name = "themes_id")
    var theme: Theme? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    // TODO: 2022/07/12 theme entity 추가
)