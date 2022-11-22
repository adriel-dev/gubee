package com.example.user.port.out;

public class UserMessageDTO {

    private final Integer id;
    private final String username;
    private final String password;

    public UserMessageDTO(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
