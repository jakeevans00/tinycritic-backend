package com.jakevans.tinycritic.dao

import com.jakevans.tinycritic.dto.Spot
import com.mongodb.client.MongoCollection
import org.springframework.stereotype.Repository

@Repository
class SpotDao(private val mongoCollection: MongoCollection<Spot>) {
    companion object {
        const val COLLECTION_NAME = "spots"
    }

    fun createSpot(spot: Spot): Spot {
        this.mongoCollection.insertOne(spot)
        return spot
    }
}