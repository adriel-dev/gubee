package com.example.port.in;

public class UserMessageDTO {

    private Integer id;
    private String username;
    private String password;

    public UserMessageDTO() {}

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
