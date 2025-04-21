package com.jakevans.tinycritic.service

import com.jakevans.tinycritic.dao.SpotDao
import com.jakevans.tinycritic.dto.Spot
import org.springframework.stereotype.Service

@Service
class SpotService(private val spotDao: SpotDao) {
    fun createSpot(name: String): Spot {
        val spotToInsert = Spot(name = name)
        return this.spotDao.createSpot(spotToInsert)
    }
}