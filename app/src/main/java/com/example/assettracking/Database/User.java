package com.example.assettracking.Database;

public class User {
    public String name, email, mobileno, password;

    public User() {
    }

    public User(String name, String email, String mobileno, String password) {
        this.name = name;
        this.email = email;
        this.mobileno = mobileno;
        this.password = password;
    }
}
