package com.calculator.config.social;

import com.calculator.model.accounts.Account;
import com.calculator.model.accounts.Role;
import com.calculator.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Create account if not exist
 */
@Service
public class ConnectionSignUpImpl implements ConnectionSignUp {

    @Autowired
    private AccountService accountService;

    @Override
    public String execute(Connection<?> connection) {
        UserProfile up = connection.fetchUserProfile();
        Account account = new Account();
        account.setUsername(up.getEmail());
        account.setPassword(UUID.randomUUID().toString());
        account.setUserRole(Role.ROLE_USER);
        accountService.save(account);
        return account.getUsername();
    }
}
