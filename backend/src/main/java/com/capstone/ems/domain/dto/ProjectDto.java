package com.capstone.ems.domain.dto;

import java.util.List;

public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private List<String> skills;
    private List<Long> employeeIds;
    private Long manager;

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

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private List<String> skills;
        private List<Long> employeeIds;
        private Long manager;

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

        public Builder setEmployeeIds(List<Long> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }

        public Builder setManager(Long manager) {
            this.manager = manager;
            return this;
        }

        public ProjectDto build() {
            ProjectDto projectDto = new ProjectDto();
            projectDto.id = this.id;
            projectDto.name = this.name;
            projectDto.description = this.description;
            projectDto.skills = this.skills;
            projectDto.employeeIds = this.employeeIds;
            projectDto.manager = this.manager;
            return projectDto;
        }
    }
}