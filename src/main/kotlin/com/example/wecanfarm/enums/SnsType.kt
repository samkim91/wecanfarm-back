package com.example.wecanfarm.enums

// TODO: 2022/10/21 key-value 모두 리턴되도록 변경 필요 * 참고자료 https://jojoldu.tistory.com/122
enum class SnsType(val asKorean: String) {
    YOUTUBE("유튜브"),
    INSTAGRAM("인스타그램"),
    BLOG("블로그"),
    FACEBOOK("페이스북"),
    URL("기타"),
}