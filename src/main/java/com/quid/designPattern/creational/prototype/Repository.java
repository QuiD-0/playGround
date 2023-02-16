package com.quid.designPattern.creational.prototype;

public class Repository {

    private String name;
    private String password;

    public Repository(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
