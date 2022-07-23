package com.example.wecanfarm.dto.farm

import com.example.wecanfarm.dto.opening_hour.OpeningHourCreateUpdateDto
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class FarmCreateUpdateDto(
    @field:NotBlank(message = "농장이름은 필수입니다.")
    val name: String,
    @field:NotBlank(message = "주 연락처는 필수입니다.")
    val mainPhone: String,
    val altPhone: String?,
    @field:NotBlank(message = "주소는 필수입니다.")
    val address: String,
    val detailAddress: String?,
    val directions: String?,
    val email: String?,
    val webUrl: String?,
    val mainSnsUrl: String?,
    val altSnsUrl: String?,
    val ownerNotes: String?,
    val hashTags: String?,
    @field:NotNull(message = "예약취소 여부는 필수입니다.")
    val isReservationCancelable: Boolean,
    val refundPolicy: String?,
    val adminNotes: String?,
    @field:NotNull(message = "활성여부는 필수입니다.")
    val isActive: Boolean,

    @field:NotEmpty(message = "테마는 필수입니다.")
    val themeIds: List<Long>,
    val openingHours: List<OpeningHourCreateUpdateDto>?
)