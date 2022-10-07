package com.adriel.hexagonalexample.user.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository {

    UserJpa save(UserJpa user);
    Optional<UserJpa> findById(Long id);
    Optional<UserJpa> findUserByUsername(String username);
    void deleteById(Long id);
    UserJpa update(UserJpa user);

}