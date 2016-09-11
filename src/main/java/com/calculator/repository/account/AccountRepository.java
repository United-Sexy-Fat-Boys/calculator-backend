package com.calculator.repository.account;


import com.calculator.filter.account.AccountFilter;
import com.calculator.model.accounts.Account;
import com.calculator.repository.BaseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Repository for Account
 */
public interface AccountRepository
        extends JpaRepository<Account, Long>,
        QueryDslPredicateExecutor<Account>,
        AccountRepositoryCustom {

    /**
     * Find Account by username
     *
     * @param name username
     * @return Account
     */
    Account findAccountByUsername(String name);
}

interface AccountRepositoryCustom
        extends BaseRepositoryCustom<Account, AccountFilter> {
}
