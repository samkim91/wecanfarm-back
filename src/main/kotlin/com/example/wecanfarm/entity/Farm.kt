package com.example.wecanfarm.entity

import javax.persistence.*

@Entity
@Table(name = "Farms")
class Farm(
    @Column(nullable = false, length = 50)
    var name: String,
    // Theme 추가

    @Column(nullable = false, length = 16)
    var mainPhone: String,

    @Column(length = 16)
    var altPhone: String?,

    @Column(nullable = false, length = 100)
    var address: String,

    @Column(length = 100)
    var detailAddress: String?,

    @Column(columnDefinition = "text")
    var directions: String?,

    var email: String?,

    @Column(length = 2100)
    var webUrl: String?,

    @Column(length = 2100)
    var mainSnsUrl: String?,

    @Column(length = 2100)
    var altSnsUrl: String?,

    @Column(columnDefinition = "text")
    var ownerNotes: String?,

    @Column(length = 2000)
    var hashTags: String?,

    var isReservationCancelable: Boolean,

    @Column(columnDefinition = "text")
    var refundPolicy: String?,

    @Column(columnDefinition = "text")
    var adminNotes: String?,

    var isActive: Boolean,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)