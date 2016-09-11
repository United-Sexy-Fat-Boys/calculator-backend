package com.calculator.model.accounts.social;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * User connection id
 */
public class UserConnectionId implements Serializable {

    @Column(name = "userid")
    private String userId;

    @Column(name = "providerid")
    private String providerId;

    @Column(name = "provideruserid")
    private String providerUserId;

    public UserConnectionId() {
        //defaultConstructor
    }

    /**
     * Create User connection id
     *
     * @param userId         user id
     * @param providerId     provider id
     * @param providerUserId provider user id
     */
    public UserConnectionId(String userId, String providerId, String providerUserId) {
        this.userId = userId;
        this.providerId = providerId;
        this.providerUserId = providerUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }

        UserConnectionId that = (UserConnectionId) o;

        return new EqualsBuilder()
                .append(userId, that.userId)
                .append(providerId, that.providerId)
                .append(providerUserId, that.providerUserId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userId)
                .append(providerId)
                .append(providerUserId)
                .toHashCode();
    }
}
