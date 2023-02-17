package com.quid.designPattern.structural.Adapter;

import com.quid.designPattern.structural.Adapter.security.UserDetailService;
import com.quid.designPattern.structural.Adapter.security.UserDetails;

public class AccountUserDetailsService implements UserDetailService {

    private Account account;

    public AccountUserDetailsService(Account account) {
        this.account = account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new AccountUserDetails(account);
    }

}
