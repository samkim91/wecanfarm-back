package com.example.wecanfarm.entity

import java.sql.Date
import java.sql.Time
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

//@Entity
//class OpeningHour(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = null,
//    @ManyToOne
//    var farm: Farm,
//    var day: Date,
//    var startTime: Time,
//    var endTime: Time,
//)