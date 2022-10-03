package com.example.wecanfarm.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "farms")
class Farm(
    @Column(nullable = false, length = 50)
    var name: String,

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

    @Column(length = 4000)
    var conveniences: String?,

    var isReservationCancelable: Boolean,

    @Column(columnDefinition = "text")
    var refundPolicy: String?,

    @Column(columnDefinition = "text")
    var adminNotes: String?,

    var isActive: Boolean,

    @OneToMany(mappedBy = "farm", fetch = FetchType.LAZY)
    var themes: MutableList<FarmTheme> = mutableListOf(),

    @OneToMany(mappedBy = "farm", fetch = FetchType.LAZY)
    var openingHours: MutableList<OpeningHour> = mutableListOf(),

    @OneToMany(mappedBy = "farm", fetch = FetchType.LAZY)
    var pricing: MutableList<Pricing> = mutableListOf(),

    @OneToMany(mappedBy = "farm", fetch = FetchType.LAZY)
    var images: MutableList<FarmAttachment> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)