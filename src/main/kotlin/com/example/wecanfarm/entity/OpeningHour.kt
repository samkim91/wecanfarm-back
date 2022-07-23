package com.example.wecanfarm.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.sql.Time
import java.time.DayOfWeek
import javax.persistence.*

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "opening_hours")
class OpeningHour(
    @ManyToOne
    @JoinColumn(name = "farm_id")
    var farm: Farm,

    @Enumerated(EnumType.STRING)
    var dayOfWeek: DayOfWeek,

    @Column(nullable = false)
    var startTime: Time,

    @Column(nullable = false)
    var endTime: Time,


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)