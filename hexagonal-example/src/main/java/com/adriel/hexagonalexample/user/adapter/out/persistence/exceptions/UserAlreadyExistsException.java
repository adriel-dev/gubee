package com.adriel.hexagonalexample.user.adapter.out.persistence.exceptions;

public class UserAlreadyExistsException extends  RuntimeException {

    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }

}