package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJpa {

    private Long id;

    private String username;

    private String password;

    public User toUser(){
        return new User(this.getId(), this.getUsername(), this.getPassword());
    }

}