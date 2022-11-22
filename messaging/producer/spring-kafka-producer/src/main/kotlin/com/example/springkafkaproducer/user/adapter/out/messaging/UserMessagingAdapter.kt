package com.example.springkafkaproducer.user.adapter.out.messaging

import com.example.springkafkaproducer.user.domain.User
import com.example.springkafkaproducer.user.port.`in`.RegisterUser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class UserMessagingAdapter(private val kafkaTemplate: KafkaTemplate<String, String>, private val mapper: ObjectMapper) : RegisterUser {

    override fun registerUser(user: User) {
        user.save()
        kafkaTemplate.send("user-test", mapper.writeValueAsString(user.toUserDTO()))
    }

}
