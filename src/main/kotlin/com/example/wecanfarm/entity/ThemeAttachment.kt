package com.example.wecanfarm.entity

import com.example.wecanfarm.enums.FileType
import javax.persistence.*

@Entity
@Table(name = "themes_attachments")
class ThemeAttachment(
    @OneToOne(mappedBy = "theme_attachment")
    var theme: Theme,

    @Column(nullable = false, length = 40)
    var s3FileName: String,

    @Column(nullable = false, length = 2100)
    var url: String,

    @Column(nullable = false, length = 256)
    var name: String,

    @Column(nullable = false)
    var type: FileType = FileType.FILE,

    @Column(nullable = false)
    var size: Long = 0,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

)