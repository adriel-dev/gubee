package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUser;
import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements RegisterUser {

    private final UserRepository userRepository;

    @Override
    public User registerUser(RegisterUserCommand userCommand) {
        UserJpa user = new UserJpa(null, userCommand.getUsername(), userCommand.getPassword());
        return userRepository.save(user).toUser();
    }

}
