package com.calculator.config.security;

import com.calculator.model.accounts.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * EShop user details
 */
public class EShopUserDetails implements UserDetails {

    private static final long serialVersionUID = -5837371255707611751L;

    private transient Account account;

    private List<GrantedAuthority> authorities;

    public EShopUserDetails() {
        //default constructor
    }

    /**
     * Create EShop user details
     *
     * @param account     account
     * @param authorities authorities
     */
    public EShopUserDetails(Account account, List<GrantedAuthority> authorities) {
        this.account = account;
        this.authorities = authorities;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
