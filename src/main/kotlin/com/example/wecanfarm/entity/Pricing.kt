package com.example.wecanfarm.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.sql.Time
import javax.persistence.*

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "pricing")
class Pricing(
    @ManyToOne
    @JoinColumn(name = "farm_id")
    var farm: Farm,

    @Column(nullable = false)
    var eventName: String,

    @Column(nullable = false)
    var cost: Long,

    @Column(nullable = false)
    var playtime: Time?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)