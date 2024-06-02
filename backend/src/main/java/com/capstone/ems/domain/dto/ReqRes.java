package com.capstone.ems.domain.dto;

import java.util.List;
import com.capstone.ems.domain.entities.UserEntity;
import com.capstone.ems.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private UserType role;
    private String email;
    private String password;
    private UserEntity ourUsers;
    private List<UserEntity> ourUsersList;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity getOurUsers() {
        return ourUsers;
    }

    public void setOurUsers(UserEntity ourUsers) {
        this.ourUsers = ourUsers;
    }

    public List<UserEntity> getOurUsersList() {
        return ourUsersList;
    }

    public void setOurUsersList(List<UserEntity> ourUsersList) {
        this.ourUsersList = ourUsersList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int statusCode;
        private String error;
        private String message;
        private String token;
        private String refreshToken;
        private String expirationTime;
        private String name;
        private UserType role;
        private String email;
        private String password;
        private UserEntity ourUsers;
        private List<UserEntity> ourUsersList;

        public Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Builder expirationTime(String expirationTime) {
            this.expirationTime = expirationTime;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(UserType role) {
            this.role = role;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder ourUsers(UserEntity ourUsers) {
            this.ourUsers = ourUsers;
            return this;
        }

        public Builder ourUsersList(List<UserEntity> ourUsersList) {
            this.ourUsersList = ourUsersList;
            return this;
        }

        public ReqRes build() {
            ReqRes reqRes = new ReqRes();
            reqRes.setStatusCode(statusCode);
            reqRes.setError(error);
            reqRes.setMessage(message);
            reqRes.setToken(token);
            reqRes.setRefreshToken(refreshToken);
            reqRes.setExpirationTime(expirationTime);
            reqRes.setName(name);
            reqRes.setRole(role);
            reqRes.setEmail(email);
            reqRes.setPassword(password);
            reqRes.setOurUsers(ourUsers);
            reqRes.setOurUsersList(ourUsersList);
            return reqRes;
        }
    }
}