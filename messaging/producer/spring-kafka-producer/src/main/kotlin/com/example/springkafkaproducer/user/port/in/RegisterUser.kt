package com.example.springkafkaproducer.user.port.`in`

import com.example.springkafkaproducer.user.domain.User

interface RegisterUser {
    fun registerUser(user: User)
}
