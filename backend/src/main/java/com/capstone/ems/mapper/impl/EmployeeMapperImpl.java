package com.capstone.ems.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.capstone.ems.domain.dto.EmployeeDto;
import com.capstone.ems.domain.entities.EmployeeEntity;
import com.capstone.ems.domain.entities.ProjectEntity;
import com.capstone.ems.domain.entities.UserEntity;
import com.capstone.ems.mapper.Mapper;

@Component
public class EmployeeMapperImpl implements Mapper<EmployeeEntity, EmployeeDto> {
    @Override
    public EmployeeDto mapTo(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) {
            return null;
        }

        List<Long> managedProjectIds = employeeEntity.getManagedProjectIds() != null ?
                employeeEntity.getManagedProjectIds().stream()
                .map(ProjectEntity::getId)
                .collect(Collectors.toList()) : null;

        return new EmployeeDto.Builder()
                .setEmpId(employeeEntity.getEmpId())
                .setUsername(employeeEntity.getUsername())
                .setEmail(employeeEntity.getEmail())
                .setName(employeeEntity.getName())
                .setSkills(employeeEntity.getSkills())
                .setManagerId(employeeEntity.getManager() != null ? employeeEntity.getManager().getEmpId() : null)
                .setProjectId(employeeEntity.getProject() != null ? employeeEntity.getProject().getId() : null)
                .setUserType(employeeEntity.getUserType())
                .setManagedProjectIds(managedProjectIds)
                .setUserId(employeeEntity.getUser() != null ? employeeEntity.getUser().getUserId() : null)
                .build();
    }

    @Override
    public EmployeeEntity mapFrom(EmployeeDto employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }
        EmployeeEntity manager = null;
        if (employeeDTO.getManagerId() != null) {
            manager = new EmployeeEntity();
            manager.setEmpId(employeeDTO.getManagerId());
        }
        ProjectEntity project = null;
        if (employeeDTO.getProjectId() != null) {
            project = new ProjectEntity();
            project.setId(employeeDTO.getProjectId());
        }

        List<ProjectEntity> managedProjectIds = null;
        if (employeeDTO.getManagedProjectIds() != null) {
            managedProjectIds = employeeDTO.getManagedProjectIds().stream()
                    .map(id -> {
                        ProjectEntity projectEntity = new ProjectEntity();
                        projectEntity.setId(id);
                        return projectEntity;
                    })
                    .collect(Collectors.toList());
        }
        UserEntity user = null;
        if (employeeDTO.getUserId() != null) {
            user = new UserEntity();
            user.setUserId(employeeDTO.getUserId());
        }
        return new EmployeeEntity.Builder()
                .setEmpId(employeeDTO.getEmpId())
                .setUsername(employeeDTO.getUsername())
                .setEmail(employeeDTO.getEmail())
                .setName(employeeDTO.getName())
                .setSkills(employeeDTO.getSkills())
                .setManager(manager)
                .setProject(project)
                .setManagedProjectIds(managedProjectIds)
                .setUserType(employeeDTO.getUserType())
                .setUser(user)
                .build();
    }
}