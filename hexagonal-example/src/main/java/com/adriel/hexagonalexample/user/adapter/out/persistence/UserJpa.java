package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "myapp_user")
public class UserJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public User toUser(){
        return new User(this.getUsername(), this.getPassword());
    }

}