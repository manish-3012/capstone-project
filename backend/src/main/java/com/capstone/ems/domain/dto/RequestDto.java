package com.capstone.ems.domain.dto;

import java.util.List;
import com.capstone.ems.enums.RequestStatus;

public class RequestDto {
    private Long reqId;
    private Long managerId;
    private Long projectId;
    private List<Long> employeeIds;
    private RequestStatus status;

    // Getters and Setters
    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
        private Long managerId;
        private Long projectId;
        private List<Long> employeeIds;
        private RequestStatus status;

        public Builder reqId(Long reqId) {
            this.reqId = reqId;
            return this;
        }

        public Builder managerId(Long managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder projectId(Long projectId) {
            this.projectId = projectId;
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

        public RequestDto build() {
            RequestDto requestDto = new RequestDto();
            requestDto.setReqId(reqId);
            requestDto.setManagerId(managerId);
            requestDto.setProjectId(projectId);
            requestDto.setEmployeeIds(employeeIds);
            requestDto.setStatus(status);
            return requestDto;
        }
    }
}