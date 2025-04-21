package com.jakevans.tinycritic.controller

import com.jakevans.tinycritic.dto.Spot
import com.jakevans.tinycritic.service.SpotService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class SpotController(private val spotService: SpotService) {

    @MutationMapping
    fun createSpot(@Argument name: String): Spot {
        return this.spotService.createSpot(name);
    }
}