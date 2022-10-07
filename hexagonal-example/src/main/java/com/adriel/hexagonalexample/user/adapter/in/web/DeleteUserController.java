package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.adapter.out.persistence.exceptions.UserNotFoundException;
import com.adriel.hexagonalexample.user.application.port.in.DeleteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class DeleteUserController {

    private final DeleteUser deleteUser;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try{
            deleteUser.deleteUserById(id);
            return ResponseEntity.ok().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}