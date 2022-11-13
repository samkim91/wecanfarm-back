package com.example.wecanfarm.service.option

import com.example.wecanfarm.enums.SnsType
import com.example.wecanfarm.service.BaseService
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