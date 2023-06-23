package com.datasirpi.dschatbox.dto;

public class User {
    public int userId;
    public String userName;
    public String password;

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
}
