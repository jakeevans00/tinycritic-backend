package com.jakevans.tinycritic.config

import com.jakevans.tinycritic.dao.SpotDao
import com.jakevans.tinycritic.dao.UserDao
import com.jakevans.tinycritic.dto.Spot
import com.jakevans.tinycritic.dto.User
import com.mongodb.*
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import org.bson.Document
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
class MongoConfig {
    lateinit var database: String
    lateinit var uri: String
    var refreshIndex: Boolean = false

    @Bean
    fun mongoClient(): MongoClient {
        return MongoClients.create(buildMongoClientSettings())
    }

    private fun buildMongoClientSettings(): MongoClientSettings {
        val connectionString = ConnectionString(uri)
        val serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build()

        val pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        )

        return MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .serverApi(serverApi)
            .readPreference(ReadPreference.primary())
            .codecRegistry(pojoCodecRegistry)
            .build()
    }

    @Bean
    fun userMongoCollection(mongoClient: MongoClient): MongoCollection<User> {
        val userMongoCollection = mongoClient.getDatabase(database)
            .getCollection(UserDao.COLLECTION_NAME, User::class.java)

        if (refreshIndex) {
            userMongoCollection.dropIndexes()
            userMongoCollection.createIndex(Document("email", 1))
            userMongoCollection.createIndex(Document("createdAt", -1))
        }

        return userMongoCollection
    }

    @Bean
    fun spotMongoCollection(mongoClient: MongoClient): MongoCollection<Spot> {
        val spotMongoCollection = mongoClient.getDatabase(database)
            .getCollection(SpotDao.COLLECTION_NAME, Spot::class.java)

        if (refreshIndex) {
            spotMongoCollection.dropIndexes()
            spotMongoCollection.createIndex(Document("name", 1))
        }

        return spotMongoCollection
    }
}