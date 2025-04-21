package com.jakevans.tinycritic.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping
    fun testEndpoint(): ResponseEntity<String> {
        return ResponseEntity.ok("This is a test");
    }
}