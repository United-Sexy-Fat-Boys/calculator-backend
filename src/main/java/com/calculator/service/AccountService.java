package com.calculator.service;

import com.calculator.filter.account.AccountFilter;
import com.calculator.model.accounts.Account;
import com.calculator.repository.BaseRepositoryCustom;
import com.calculator.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * Service for account
 */
@Service
public class AccountService implements BaseCRUDService<Account, AccountFilter> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }

    @Override
    public BaseRepositoryCustom<Account, AccountFilter> getRepositoryCustom() {
        return accountRepository;
    }

    /**
     * Find Category by username
     *
     * @param username username
     * @return Category
     */
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }
}
