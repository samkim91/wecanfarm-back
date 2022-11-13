package com.example.wecanfarm.enums

import com.fasterxml.jackson.annotation.JsonFormat

// TODO: 2022/10/21 key-value 모두 리턴되도록 변경 필요 * 참고자료 https://jojoldu.tistory.com/122
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class SnsType(val asEnglish: String, val asKorean: String) {
    YOUTUBE("YouTube", "유튜브"),
    INSTAGRAM("Instagram", "인스타그램"),
    BLOG("Blog", "블로그"),
    FACEBOOK("Facebook", "페이스북"),
    URL("Url", "웹주소"),
}