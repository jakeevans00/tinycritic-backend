package com.jakevans.tinycritic.service

import com.jakevans.tinycritic.dao.UserDao
import com.jakevans.tinycritic.dto.CreateUserRequest
import com.jakevans.tinycritic.dto.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userDao: UserDao,
) {
    fun createUser(request: CreateUserRequest): User {
        userDao.findByEmail(request.email)?.let {
            throw IllegalArgumentException("Email already in use")
        }

        val user = User(
            email = request.email,
            name = request.username,
        )

        return userDao.createUser(user)
    }
}