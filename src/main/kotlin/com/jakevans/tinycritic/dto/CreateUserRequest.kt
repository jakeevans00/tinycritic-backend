package com.jakevans.tinycritic.dto

data class CreateUserRequest(
    val email: String,
    val username: String,
    val password: String
)