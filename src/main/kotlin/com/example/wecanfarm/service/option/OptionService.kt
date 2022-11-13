package com.example.wecanfarm.service.option

import com.example.wecanfarm.enums.SnsType

interface OptionService {

    fun getSnsOptions(): List<SnsType>
    fun getSnsOption(key : String): SnsType
}