package com.adriel.hexagonalexample.user.adapter.out.persistence;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class UserJpa {

    @Id
    private Long id;

    private String username;

    private String password;

}