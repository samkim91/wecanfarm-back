package com.example.wecanfarm.entity

import com.example.wecanfarm.enums.SnsType
import javax.persistence.*

@Entity
@Table(name = "urls")
class Url(
    @ManyToOne
    @JoinColumn(name = "farm_id")
    var farm: Farm,

    @Column(nullable = false, length = 2100)
    var address: String,

    @Column(nullable = false)
    var type: SnsType = SnsType.URL,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
)