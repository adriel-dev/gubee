package com.example.springkafkaproducer.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaConfig{

    @Autowired
    private lateinit var kafkaProperties: KafkaProperties

    @Bean
    fun producerFactory(): ProducerFactory<String, String> { //permite criar produtor
        val configs = mutableMapOf<String, Any>()
        configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return DefaultKafkaProducerFactory(configs)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {//permite mandar mensagens
        return KafkaTemplate(producerFactory())
    }

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs = mutableMapOf<String, Any>()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        return KafkaAdmin(configs)
    }

    @Bean
    fun userTestTopic(): NewTopic {//cria novo tópico
        return NewTopic("user-test", 10, 1.toShort())
    }

}
