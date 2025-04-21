package com.jakevans.tinycritic.dao

import com.jakevans.tinycritic.dto.User
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.springframework.stereotype.Repository

@Repository
class UserDao(private val userCollection: MongoCollection<User>) {
    companion object {
        const val COLLECTION_NAME = "users"
    }

    fun createUser(user: User): User {
        userCollection.insertOne(user)
        return user
    }

    fun findByEmail(email: String): User? {
        return userCollection.find(Filters.eq("email", email)).first()
    }
}