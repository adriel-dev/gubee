package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.domain.User;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
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