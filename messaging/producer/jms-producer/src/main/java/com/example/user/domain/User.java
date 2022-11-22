package com.example.user.domain;

import com.example.user.port.out.UserMessageDTO;

public class User {

    private Integer id;
    private String username;
    private String password;

    public void save() {
        System.out.println("User registered successfully!");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserMessageDTO toUserMessageDTO() {
        return new UserMessageDTO(this.getId(), this.getUsername(), this.getPassword());
    }

}
