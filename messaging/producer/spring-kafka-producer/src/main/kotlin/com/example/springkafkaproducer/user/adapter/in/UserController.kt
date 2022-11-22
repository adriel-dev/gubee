package com.example.springkafkaproducer.user.adapter.`in`

import com.example.springkafkaproducer.user.domain.User
import com.example.springkafkaproducer.user.port.`in`.RegisterUser
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val registerUser: RegisterUser) {

    @PostMapping("/save")
    fun saveUser(@RequestBody user: User) {
        registerUser.registerUser(user)
    }

}
