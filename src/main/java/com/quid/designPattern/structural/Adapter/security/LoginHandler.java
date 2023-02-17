package com.quid.designPattern.structural.Adapter.security;

public class LoginHandler {

    UserDetailService userDetailService;

    public LoginHandler(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    public void login(String username, String password) {
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if (userDetails.getPassword().equals(password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

}
