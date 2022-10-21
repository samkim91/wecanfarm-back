package com.example.wecanfarm.service

import com.example.wecanfarm.enums.SnsType
import org.springframework.stereotype.Service

@Service
class OptionServiceImpl : BaseService(), OptionService {
    override fun getSnsOptions(): List<SnsType> {
        return SnsType.values().asList()
    }

    override fun getSnsOption(key : String): SnsType {
        return SnsType.valueOf(key)
    }
}