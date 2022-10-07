package com.adriel.hexagonalexample.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;

    //Acredito que essa se trata de uma classe anêmica
    //Métodos de regra de negócio?

}