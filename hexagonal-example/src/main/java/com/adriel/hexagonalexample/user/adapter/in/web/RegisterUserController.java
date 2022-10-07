package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUser;
import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class RegisterUserController {

    private final RegisterUser registerUser;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserCommand userCommand){
        User savedUser = registerUser.registerUser(userCommand);
        return ResponseEntity.created(URI.create("/api/users/"+savedUser.getId()))
                .body(savedUser);
    }

}