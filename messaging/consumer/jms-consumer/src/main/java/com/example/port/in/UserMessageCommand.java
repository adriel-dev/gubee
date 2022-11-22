package com.example.port.in;

public class UserMessageCommand {

    private Integer id;
    private String username;
    private String password;

    public UserMessageCommand() {}

    public UserMessageCommand(Integer id, String username, String password) {
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