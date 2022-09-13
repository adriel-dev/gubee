package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.application.port.in.UpdateUser;
import com.adriel.hexagonalexample.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UpdateUserController {

    private final UpdateUser updateUser;

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody RegisterUserCommand userCommand) {
        try {
            return ResponseEntity.ok().body(updateUser.updateUser(id, userCommand));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}