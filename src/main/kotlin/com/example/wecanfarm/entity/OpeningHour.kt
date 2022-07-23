package com.example.wecanfarm.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.sql.Date
import java.sql.Time
import javax.persistence.*

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "opening_hours")
class OpeningHour(
    @ManyToOne
    var farm: Farm,
    var day: Date,
    var startTime: Time,
    var endTime: Time,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)