package com.jakevans.tinycritic.controller

import com.jakevans.tinycritic.dto.CreateUserRequest
import com.jakevans.tinycritic.dto.User
import com.jakevans.tinycritic.service.UserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserController(private val userService: UserService) {
    @QueryMapping
    fun user(@Argument id: String): String? {
        return "Jake Evans"
    }

    @MutationMapping
    fun createUser(@Argument input: CreateUserRequest): User {
        return userService.createUser(input);
    }
}