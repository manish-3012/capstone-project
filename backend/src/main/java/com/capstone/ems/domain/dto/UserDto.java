package com.capstone.ems.domain.dto;

import com.capstone.ems.enums.UserType;

public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private UserType role;
    private Long employeeId;
    private String username;
    private String name;

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long userId;
        private String email;
        private String password;
        private UserType role;
        private Long employeeId;
        private String username;
        private String name;

        public Builder userId(Long userId) {
            this.userId = userId;
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

        public Builder role(UserType role) {
            this.role = role;
            return this;
        }

        public Builder employeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public UserDto build() {
            UserDto userDto = new UserDto();
            userDto.setUserId(userId);
            userDto.setEmail(email);
            userDto.setPassword(password);
            userDto.setRole(role);
            userDto.setEmployeeId(employeeId);
            userDto.setUsername(username);
            userDto.setName(name);
            return userDto;
        }
    }
}