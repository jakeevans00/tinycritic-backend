package com.jakevans.tinycritic.dto

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.Instant

data class User(
    @BsonId
    var id: ObjectId = ObjectId(),
    var email: String = "",
    var name: String = "",
    var createdAt: Instant = Instant.now()
)   {
    companion object {
        const val COLLECTION_NAME = "users"
    }
}