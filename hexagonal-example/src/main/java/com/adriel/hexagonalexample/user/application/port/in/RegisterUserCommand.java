package com.adriel.hexagonalexample.user.application.port.in;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class RegisterUserCommand {

    @NotNull
    private final String username;

    @NotNull
    private final String password;

}