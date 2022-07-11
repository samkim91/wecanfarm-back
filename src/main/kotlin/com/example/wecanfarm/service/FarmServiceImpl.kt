package com.example.wecanfarm.service

import com.example.wecanfarm.entity.Farm
import com.example.wecanfarm.repository.FarmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class FarmServiceImpl @Autowired constructor(
    val farmRepository: FarmRepository
) : BaseService(), FarmService {

    override fun findById(id: Long): Farm {
        return farmRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 농장이 존재하지 않습니다.") }
    }

    @Transactional
    override fun insertFarm(farm: Farm): Farm {
        return farmRepository.save(farm)
    }

    @Transactional
    override fun updateFarm(id: Long, updatingFarm: Farm): Farm {
        val farm = farmRepository.findById(id)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 농장이 존재하지 않습니다.") }

        farm.name = updatingFarm.name
        farm.mainPhone = updatingFarm.mainPhone
        farm.altPhone = updatingFarm.altPhone
        farm.address = updatingFarm.address
        farm.detailAddress = updatingFarm.detailAddress
        farm.email = updatingFarm.email
        farm.webUrl = updatingFarm.webUrl
        farm.mainSnsUrl = updatingFarm.mainSnsUrl
        farm.altSnsUrl = updatingFarm.altSnsUrl
        farm.ownerNotes = updatingFarm.ownerNotes
        farm.hashTags = updatingFarm.hashTags
        farm.isReservationCancelable = updatingFarm.isReservationCancelable
        farm.refundPolicy = updatingFarm.refundPolicy
        farm.adminNotes = updatingFarm.adminNotes
        farm.isActive = updatingFarm.isActive

        return farm
    }


}