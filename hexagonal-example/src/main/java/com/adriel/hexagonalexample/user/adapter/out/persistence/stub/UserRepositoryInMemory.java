package com.adriel.hexagonalexample.user.adapter.out.persistence.stub;

import com.adriel.hexagonalexample.user.adapter.out.persistence.UserJpa;
import com.adriel.hexagonalexample.user.adapter.out.persistence.UserRepository;
import com.adriel.hexagonalexample.user.adapter.out.persistence.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryInMemory implements UserRepository {

    private final List<UserJpa> users = new ArrayList<>();
    private Long lastId = 0L;

    public UserRepositoryInMemory() {
        this.save(new UserJpa(null, "teste", "123"));
    }

    /**
     * Add a new user to the list
     */
    @Override
    public UserJpa save(UserJpa user) {
        if (user.getId() != null)
            return this.update(user);
        else{
            lastId++;
            user.setId(lastId);
            users.add(user);
            return user;
        }
    }

    @Override
    public Optional<UserJpa> findById(Long id) {
        var filteredUsers = users.stream().filter((user) -> user.getId().equals(id)).toList();
        return filteredUsers.stream().findFirst();
    }

    @Override
    public void deleteById(Long id) {
        var userToRemove = findById(id).get();
        users.remove(userToRemove);
    }

    @Override
    public UserJpa update(UserJpa userJpa) {
        users.stream().filter((user) -> user.equals(userJpa)).findFirst().ifPresentOrElse(value -> {
            var index = users.indexOf(value);
            users.set(index, userJpa);
        }, () -> {
            throw new UserNotFoundException();
        });
        return userJpa;
    }

    @Override
    public Optional<UserJpa> findUserByUsername(String username) {
        return Optional.empty();
    }
}