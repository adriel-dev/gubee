package com.example.springkafkaproducer.user.domain

import com.example.springkafkaproducer.user.port.out.UserMessageDTO

data class User(
    private val id: Int,
    private val username: String,
    private val password: String
) {

    fun save() {
        println("User registered successfully!")
    }

    fun toUserDTO(): UserMessageDTO {
        return UserMessageDTO(id, username, password)
    }
}
