package com.calculator.dto.user;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Info about account from client
 */
public class AccountDTO extends BaseAccountDTO{
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof AccountDTO)) {
            return false;
        }

        AccountDTO that = (AccountDTO) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getPassword(), that.getPassword())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getPassword())
                .toHashCode();
    }
}