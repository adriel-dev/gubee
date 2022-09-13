package com.adriel.hexagonalexample.user.adapter.out.persistence;

import java.util.NoSuchElementException;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}