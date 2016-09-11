package com.calculator.model.accounts.social;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;

import javax.jdo.annotations.Index;
import javax.persistence.*;

/**
 * User connection to social
 */
@Entity
@Table(name = "userconnection")
@IdClass(UserConnectionId.class)
@Index(members = {"userId", "providerId", "rank"}, unique = "true")
public class UserConnection {

    @Id
    @Column(name = "userid")
    private String userId;

    @Id
    @Column(name = "providerid")
    private String providerId;

    @Id
    @Column(name = "provideruserid")
    private String providerUserId;

    private int rank;

    @Column(name = "displayname")
    private String displayName;

    @Column(name = "profileurl")
    private String profileUrl;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "accesstoken", nullable = false)
    private String accessToken;

    private String secret;

    @Column(name = "refreshtoken")
    private String refreshToken;

    @Column(name = "expiretime")
    private long expireTime;

    public UserConnection() {
        //d
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
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

        UserConnection that = (UserConnection) o;

        return new EqualsBuilder()
                .append(getRank(), that.getRank())
                .append(getExpireTime(), that.getExpireTime())
                .append(getUserId(), that.getUserId())
                .append(getProviderId(), that.getProviderId())
                .append(getProviderUserId(), that.getProviderUserId())
                .append(getDisplayName(), that.getDisplayName())
                .append(getProfileUrl(), that.getProfileUrl())
                .append(getImageUrl(), that.getImageUrl())
                .append(getAccessToken(), that.getAccessToken())
                .append(getSecret(), that.getSecret())
                .append(getRefreshToken(), that.getRefreshToken())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getUserId())
                .append(getProviderId())
                .append(getProviderUserId())
                .append(getRank())
                .append(getDisplayName())
                .append(getProfileUrl())
                .append(getImageUrl())
                .append(getAccessToken())
                .append(getSecret())
                .append(getRefreshToken())
                .append(getExpireTime())
                .toHashCode();
    }
}
