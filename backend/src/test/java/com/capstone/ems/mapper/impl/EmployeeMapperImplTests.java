package com.capstone.ems.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capstone.ems.domain.dto.EmployeeDto;
import com.capstone.ems.domain.entities.EmployeeEntity;
import com.capstone.ems.domain.entities.ProjectEntity;
import com.capstone.ems.domain.entities.UserEntity;
import com.capstone.ems.enums.UserType;
import com.capstone.ems.mapper.impl.EmployeeMapperImpl;

class EmployeeMapperImplTests {

    private EmployeeMapperImpl employeeMapper;

    @BeforeEach
    void setUp() {
        employeeMapper = new EmployeeMapperImpl();
    }

    @Test
    void testMapToWithNullInput() {
        assertNull(employeeMapper.mapTo(null));
    }

    @Test
    void testMapToWithCompleteData() {
        EmployeeEntity employeeEntity = createEmployeeEntity();

        EmployeeDto employeeDto = employeeMapper.mapTo(employeeEntity);

        assertNotNull(employeeDto);
        assertEquals(1L, employeeDto.getEmpId());
        assertEquals("johndoe", employeeDto.getUsername());
        assertEquals("john.doe@example.com", employeeDto.getEmail());
        assertEquals("John Doe", employeeDto.getName());
        assertEquals(Arrays.asList("Java", "Python"), employeeDto.getSkills());
        assertEquals(2L, employeeDto.getManagerId());
        assertEquals(3L, employeeDto.getProjectId());
        assertEquals(UserType.ADMIN, employeeDto.getUserType());
        assertEquals(Arrays.asList(4L, 5L), employeeDto.getManagedProjectIds());
        assertEquals(6L, employeeDto.getUserId());
    }

    @Test
    void testMapFromWithNullInput() {
        assertNull(employeeMapper.mapFrom(null));
    }

    @Test
    void testMapFromWithCompleteData() {
        EmployeeDto employeeDto = createEmployeeDto();

        EmployeeEntity employeeEntity = employeeMapper.mapFrom(employeeDto);

        assertNotNull(employeeEntity);
        assertEquals(1L, employeeEntity.getEmpId());
        assertEquals("johndoe", employeeEntity.getUsername());
        assertEquals("john.doe@example.com", employeeEntity.getEmail());
        assertEquals("John Doe", employeeEntity.getName());
        assertEquals(Arrays.asList("Java", "Python"), employeeEntity.getSkills());
        assertNotNull(employeeEntity.getManager());
        assertEquals(2L, employeeEntity.getManager().getEmpId());
        assertNotNull(employeeEntity.getProject());
        assertEquals(3L, employeeEntity.getProject().getId());
        assertEquals(UserType.ADMIN, employeeEntity.getUserType());
        assertNotNull(employeeEntity.getManagedProjectIds());
        assertEquals(2, employeeEntity.getManagedProjectIds().size());
        assertTrue(employeeEntity.getManagedProjectIds().stream().anyMatch(p -> p.getId().equals(4L)));
        assertTrue(employeeEntity.getManagedProjectIds().stream().anyMatch(p -> p.getId().equals(5L)));
        assertNotNull(employeeEntity.getUser());
        assertEquals(6L, employeeEntity.getUser().getUserId());
    }

    private EmployeeEntity createEmployeeEntity() {
        EmployeeEntity manager = new EmployeeEntity.Builder()
                .setEmpId(2L)
                .build();

        ProjectEntity project = new ProjectEntity.Builder()
                .setId(3L)
                .build();

        List<ProjectEntity> managedProjectIds = Arrays.asList(
                new ProjectEntity.Builder().setId(4L).build(),
                new ProjectEntity.Builder().setId(5L).build()
        );

        UserEntity user = UserEntity.builder()
                .userId(6L)
                .build();

        return new EmployeeEntity.Builder()
                .setEmpId(1L)
                .setUsername("johndoe")
                .setEmail("john.doe@example.com")
                .setName("John Doe")
                .setSkills(Arrays.asList("Java", "Python"))
                .setManager(manager)
                .setProject(project)
                .setManagedProjectIds(managedProjectIds)
                .setUserType(UserType.ADMIN)
                .setUser(user)
                .build();
    }

    private EmployeeDto createEmployeeDto() {
        return new EmployeeDto.Builder()
                .setEmpId(1L)
                .setUsername("johndoe")
                .setEmail("john.doe@example.com")
                .setName("John Doe")
                .setSkills(Arrays.asList("Java", "Python"))
                .setManagerId(2L)
                .setProjectId(3L)
                .setUserType(UserType.ADMIN)
                .setManagedProjectIds(Arrays.asList(4L, 5L))
                .setUserId(6L)
                .build();
    }
}