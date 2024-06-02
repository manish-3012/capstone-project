package com.capstone.ems.domain.entities;

import java.util.List;

import com.capstone.ems.domain.dto.ProjectDto;
import com.capstone.ems.domain.dto.ProjectDto.Builder;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_skills", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "skill")
    private List<String> skills;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<EmployeeEntity> employeeIds;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "emp_id")
    private EmployeeEntity manager;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<EmployeeEntity> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<EmployeeEntity> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }
    
    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private List<String> skills;
        private List<EmployeeEntity> employeeIds;
        private EmployeeEntity manager;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setSkills(List<String> skills) {
            this.skills = skills;
            return this;
        }

        public Builder setEmployeeIds(List<EmployeeEntity> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }

        public Builder setManager(EmployeeEntity manager) {
            this.manager = manager;
            return this;
        }

        public ProjectEntity build() {
        	ProjectEntity projectEntity = new ProjectEntity();
        	projectEntity.id = this.id;
        	projectEntity.name = this.name;
        	projectEntity.description = this.description;
        	projectEntity.skills = this.skills;
        	projectEntity.employeeIds = this.employeeIds;
        	projectEntity.manager = this.manager;
            return projectEntity;
        }
    }
}