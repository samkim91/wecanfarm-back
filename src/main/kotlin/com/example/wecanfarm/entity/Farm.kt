package com.example.wecanfarm.entity

import org.hibernate.annotations.ColumnDefault
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

    @OneToMany(mappedBy = "farm")
    var themes: MutableList<FarmTheme> = mutableListOf(),

    @Column(nullable = false, length = 16)
    var mainPhone: String,

    @Column(length = 16)
    @ColumnDefault("")
    var altPhone: String?,

    @Column(nullable = false, length = 100)
    var address: String,

    @Column(length = 100)
    @ColumnDefault("")
    var detailAddress: String?,

    @Column(columnDefinition = "text")
    @ColumnDefault("")
    var directions: String?,

    @ColumnDefault("")
    var email: String?,

    @ColumnDefault("")
    @Column(length = 2100)
    var webUrl: String?,

    @Column(length = 2100)
    @ColumnDefault("")
    var mainSnsUrl: String?,

    @Column(length = 2100)
    @ColumnDefault("")
    var altSnsUrl: String?,

    @Column(columnDefinition = "text")
    @ColumnDefault("")
    var ownerNotes: String?,

    @Column(length = 2000)
    @ColumnDefault("")
    var hashTags: String?,

    var isReservationCancelable: Boolean,

    @Column(columnDefinition = "text")
    @ColumnDefault("")
    var refundPolicy: String?,

    @Column(columnDefinition = "text")
    @ColumnDefault("")
    var adminNotes: String?,

    var isActive: Boolean,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)