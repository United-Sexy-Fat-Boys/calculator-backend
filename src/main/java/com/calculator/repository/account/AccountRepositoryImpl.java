package com.calculator.repository.account;

import com.calculator.filter.account.AccountFilter;
import com.calculator.model.accounts.Account;
import com.calculator.repository.BaseRepositoryImpl;
import com.querydsl.core.BooleanBuilder;

/**
 * Account repository impl
 */
public class AccountRepositoryImpl
        extends BaseRepositoryImpl<Account, AccountFilter>
        implements AccountRepositoryCustom {

    /**
     * Base constructor
     */
    public AccountRepositoryImpl() {
        super(Account.class);
    }

    @Override
    protected BooleanBuilder getQueryPredicate(AccountFilter searchFilter) {
        return null;
    }
}
