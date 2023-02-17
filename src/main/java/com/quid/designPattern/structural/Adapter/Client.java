package com.quid.designPattern.structural.Adapter;

import com.quid.designPattern.structural.Adapter.security.LoginHandler;
import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void adapterTest() {
        Account account = new Account("username", "password");
        LoginHandler loginHandler = new LoginHandler(new AccountUserDetailsService(account));
        loginHandler.login("username", "password");
    }

}
