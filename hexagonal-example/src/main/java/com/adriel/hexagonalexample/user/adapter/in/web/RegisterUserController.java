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

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class RegisterUserController {

    private final RegisterUser registerUserService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserCommand userCommand){
        User savedUser = registerUserService.registerUser(userCommand);
        return ResponseEntity.ok().body(savedUser);
    }

}