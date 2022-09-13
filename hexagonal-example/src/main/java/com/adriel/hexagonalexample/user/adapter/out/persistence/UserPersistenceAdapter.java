package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.application.port.in.*;
import com.adriel.hexagonalexample.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements RegisterUser, FindUser, UpdateUser, DeleteUser {

    private final UserRepository userRepository;

    @Override
    public User registerUser(RegisterUserCommand userCommand) {
        UserJpa user = new UserJpa(null, userCommand.getUsername(), userCommand.getPassword());
        return userRepository.save(user).toUser();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get().toUser();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, RegisterUserCommand userCommand) {
        if(userRepository.findById(id).isPresent()) {
            UserJpa user = new UserJpa(id, userCommand.getUsername(), userCommand.getPassword());
            return userRepository.save(user).toUser();
        }
        throw new NoSuchElementException();
    }
}
