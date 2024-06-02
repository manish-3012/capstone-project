package com.capstone.ems.domain.entities;

import java.util.List;
import com.capstone.ems.enums.UserType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @NotNull
    @Column(name = "userName")
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", unique = true)
    @Email
    private String email;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_skills", joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name = "skill")
    private List<String> skills;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "emp_id")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProjectEntity> managedProjectIds;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", referencedColumnName = "id", unique = true)
    private ProjectEntity project;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private UserEntity user;

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

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public List<ProjectEntity> getManagedProjectIds() {
        return managedProjectIds;
    }

    public void setManagedProjectIds(List<ProjectEntity> managedProjectIds) {
        this.managedProjectIds = managedProjectIds;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    
    public static class Builder {
        private Long empId;
        private String username;
        private String email;
        private String name;
        private List<String> skills;
        private EmployeeEntity manager;
        private List<ProjectEntity> managedProjectIds;
        private ProjectEntity project;
        private UserType userType;
        private UserEntity user;

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

        public Builder setManager(EmployeeEntity manager) {
            this.manager = manager;
            return this;
        }

        public Builder setManagedProjectIds(List<ProjectEntity> managedProjectIds) {
            this.managedProjectIds = managedProjectIds;
            return this;
        }

        public Builder setProject(ProjectEntity project) {
            this.project = project;
            return this;
        }

        public Builder setUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder setUser(UserEntity user) {
            this.user = user;
            return this;
        }

        public EmployeeEntity build() {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.empId = this.empId;
            employeeEntity.username = this.username;
            employeeEntity.email = this.email;
            employeeEntity.name = this.name;
            employeeEntity.skills = this.skills;
            employeeEntity.manager = this.manager;
            employeeEntity.managedProjectIds = this.managedProjectIds;
            employeeEntity.project = this.project;
            employeeEntity.userType = this.userType;
            employeeEntity.user = this.user;
            return employeeEntity;
        }
    }
}