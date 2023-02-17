package com.quid.designPattern.structural.Adapter.security;

public interface UserDetailService {

    UserDetails loadUserByUsername(String username);
}
