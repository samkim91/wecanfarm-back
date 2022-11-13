package com.example.wecanfarm.service.url

import com.example.wecanfarm.dto.url.UrlCreateUpdateDto
import com.example.wecanfarm.entity.Farm

interface UrlService {

    fun createUrls(farm: Farm, urls: List<UrlCreateUpdateDto>)

    fun updateUrls(farm: Farm, urls: List<UrlCreateUpdateDto>)
}