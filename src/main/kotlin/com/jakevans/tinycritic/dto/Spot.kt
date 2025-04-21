package com.jakevans.tinycritic.dto

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Spot(
    @BsonId
    var id: ObjectId = ObjectId(),
    var name: String = "",
    var rating: Int = 1
)