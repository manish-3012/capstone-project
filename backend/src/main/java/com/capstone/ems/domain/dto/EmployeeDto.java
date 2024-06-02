package com.capstone.ems.domain.dto;

import java.util.List;
import com.capstone.ems.enums.UserType;

public class EmployeeDto {
    private Long empId;
    private String username;
    private String email;
    private String name;
    private List<String> skills;
    private Long managerId;
    private List<Long> managedProjectIds;
    private Long projectId;
    private UserType userType;
    private Long userId;

    // Getters and Setters

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public List<Long> getManagedProjectIds() {
        return managedProjectIds;
    }

    public void setManagedProjectIds(List<Long> managedProjectIds) {
        this.managedProjectIds = managedProjectIds;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public static class Builder {
        private Long empId;
        private String username;
        private String email;
        private String name;
        private List<String> skills;
        private Long managerId;
        private List<Long> managedProjectIds;
        private Long projectId;
        private UserType userType;
        private Long userId;

        public Builder setEmpId(Long empId) {
            this.empId = empId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSkills(List<String> skills) {
            this.skills = skills;
            return this;
        }

        public Builder setManagerId(Long managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder setManagedProjectIds(List<Long> managedProjectIds) {
            this.managedProjectIds = managedProjectIds;
            return this;
        }

        public Builder setProjectId(Long projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder setUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public EmployeeDto build() {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.empId = this.empId;
            employeeDto.username = this.username;
            employeeDto.email = this.email;
            employeeDto.name = this.name;
            employeeDto.skills = this.skills;
            employeeDto.managerId = this.managerId;
            employeeDto.managedProjectIds = this.managedProjectIds;
            employeeDto.projectId = this.projectId;
            employeeDto.userType = this.userType;
            employeeDto.userId = this.userId;
            return employeeDto;
        }
    }
}