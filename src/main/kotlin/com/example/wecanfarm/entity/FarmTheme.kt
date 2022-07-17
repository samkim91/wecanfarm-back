package com.example.wecanfarm.entity

import javax.persistence.*

@Entity
@Table(name = "farms_themes")
class FarmTheme(
    @ManyToOne
    @JoinColumn(name = "farm_id")
    var farm: Farm,

    @ManyToOne
    @JoinColumn(name = "themes_id")
    var theme: Theme,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
)