package com.example.wecanfarm.dto.farm

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class FarmCreateDto(
    @NotBlank(message = "농장이름은 필수입니다.")
    val name: String,
    @NotBlank(message = "주 연락처는 필수입니다.")
    val mainPhone: String,
    val altPhone: String?,
    @NotBlank(message = "주소는 필수입니다.")
    val address: String,
    val detailAddress: String?,
    val directions: String?,
    val email: String?,
    val webUrl: String?,
    val mainSnsUrl: String?,
    val altSnsUrl: String?,
    val ownerNotes: String?,
    val hashTags: String?,
    @NotNull(message = "예약취소 여부는 필수입니다.")
    val isReservationCancelable: Boolean,
    val refundPolicy: String?,
    val adminNotes: String?,
    @NotNull(message = "활성여부는 필수입니다.")
    val isActive: Boolean,

    @NotEmpty(message = "테마는 필수입니다.")
    val themes: List<Long> = listOf(),
)
