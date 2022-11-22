package com.example.springkafkaconsumer.adapter.`in`.message

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class UserKafkaListener(private val mapper: ObjectMapper) {

    @KafkaListener(topics = ["user-test"], groupId = "user-group")
    fun listen(msg: String) {
        //fazer algo sempre que uma nova msg for recebida
        val user = mapper.readValue(msg, UserMessageDTO::class.java)
        println(user)
    }

}

data class UserMessageDTO(val id: Int, val username: String, val password: String)
