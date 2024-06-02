package com.capstone.ems.domain.entities;

import java.util.List;

import com.capstone.ems.enums.RequestStatus;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reqId;
    @ManyToOne
    @JoinColumn(name = "managerId", referencedColumnName = "emp_id")
    private EmployeeEntity manager;
    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private ProjectEntity project;

    @ElementCollection
    @CollectionTable(name = "request_employee_ids", joinColumns = @JoinColumn(name = "req_id"))
    @Column(name = "employee_id")
    private List<Long> employeeIds;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    // Getters and Setters
    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long reqId;
        private EmployeeEntity manager;
        private ProjectEntity project;
        private List<Long> employeeIds;
        private RequestStatus status;

        public Builder reqId(Long reqId) {
            this.reqId = reqId;
            return this;
        }

        public Builder manager(EmployeeEntity manager) {
            this.manager = manager;
            return this;
        }

        public Builder project(ProjectEntity project) {
            this.project = project;
            return this;
        }

        public Builder employeeIds(List<Long> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }

        public Builder status(RequestStatus status) {
            this.status = status;
            return this;
        }

        public RequestEntity build() {
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setReqId(reqId);
            requestEntity.setManager(manager);
            requestEntity.setProject(project);
            requestEntity.setEmployeeIds(employeeIds);
            requestEntity.setStatus(status);
            return requestEntity;
        }
    }
}