package com.example.wecanfarm.service.url

import com.example.wecanfarm.converter.toEntity
import com.example.wecanfarm.dto.url.UrlCreateUpdateDto
import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.repository.UrlRepository
import com.example.wecanfarm.service.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UrlServiceImpl @Autowired constructor(
    private val urlRepository: UrlRepository,
) : BaseService(), UrlService {

    @Transactional
    override fun createUrls(farm: Farm, urls: List<UrlCreateUpdateDto>) {
        urls.map { urlCreateUpdateDto ->
            farm.urls.add(urlCreateUpdateDto.toEntity(farm))
        }
    }

    @Transactional
    override fun updateUrls(farm: Farm, urls: List<UrlCreateUpdateDto>) {
        urlRepository.deleteAll(farm.urls)
        farm.urls.clear()

        urlRepository.flush()
        createUrls(farm, urls)
    }
}