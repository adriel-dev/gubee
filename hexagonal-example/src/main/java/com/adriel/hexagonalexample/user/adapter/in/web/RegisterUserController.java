package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUser;
import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
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
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserCommand userCommand){
        registerUserService.registerUser(userCommand);
        return null;
    }

}