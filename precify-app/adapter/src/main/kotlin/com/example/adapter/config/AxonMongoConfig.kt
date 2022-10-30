package com.example.adapter.config

import com.mongodb.client.MongoClient
import org.axonframework.eventhandling.tokenstore.TokenStore
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.extensions.mongo.DefaultMongoTemplate
import org.axonframework.extensions.mongo.MongoTemplate
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine
import org.axonframework.extensions.mongo.eventsourcing.tokenstore.MongoTokenStore
import org.axonframework.serialization.Serializer
import org.axonframework.spring.config.AxonConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AxonMongoConfig {

    @Bean
    fun eventStorageTemplate(client: MongoClient): MongoTemplate {
        return DefaultMongoTemplate
            .builder()
            .mongoDatabase(client.getDatabase("precify-database"))
            .build()
    }

    @Bean
    fun eventStorageEngine(
        storageTemplate: MongoTemplate,
        serializer: Serializer,
    ): EventStorageEngine {
        return MongoEventStorageEngine
            .builder()
            .batchSize(200)
            .snapshotSerializer(serializer)
            .eventSerializer(serializer)
            .mongoTemplate(storageTemplate).build()
    }

}