package com.calculator.dto.user;

import com.calculator.dto.BaseDTO;
import com.calculator.model.accounts.Account;
import com.calculator.model.accounts.Role;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class BaseAccountDTO extends BaseDTO<Account> {
    private String username;

    private Role userRole;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseAccountDTO)) {
            return false;
        }

        BaseAccountDTO that = (BaseAccountDTO) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getUsername(), that.getUsername())
                .append(getUserRole(), that.getUserRole())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getUsername())
                .append(getUserRole())
                .toHashCode();
    }

    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }
}
