package com.capstone.ems.domain.dto;

import com.capstone.ems.domain.entities.UserEntity;
import com.capstone.ems.enums.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ReqResTest {

    @Mock
    private UserEntity mockUser;

    private ReqRes reqRes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reqRes = new ReqRes();
    }

    @Test
    void testGettersAndSetters() {
        int statusCode = 200;
        String error = "No error";
        String message = "Success";
        String token = "token123";
        String refreshToken = "refreshToken456";
        String expirationTime = "2024-06-02T12:00:00Z";
        String name = "John Doe";
        UserType role = UserType.ADMIN;
        String email = "john.doe@example.com";
        String password = "password123";
        UserEntity user = mockUser;
        List<UserEntity> usersList = new ArrayList<>();
        usersList.add(mockUser);

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
        reqRes.setOurUsers(user);
        reqRes.setOurUsersList(usersList);

        assertEquals(statusCode, reqRes.getStatusCode());
        assertEquals(error, reqRes.getError());
        assertEquals(message, reqRes.getMessage());
        assertEquals(token, reqRes.getToken());
        assertEquals(refreshToken, reqRes.getRefreshToken());
        assertEquals(expirationTime, reqRes.getExpirationTime());
        assertEquals(name, reqRes.getName());
        assertEquals(role, reqRes.getRole());
        assertEquals(email, reqRes.getEmail());
        assertEquals(password, reqRes.getPassword());
        assertEquals(user, reqRes.getOurUsers());
        assertEquals(usersList, reqRes.getOurUsersList());
    }

    @Test
    void testBuilder() {
        int statusCode = 200;
        String error = "No error";
        String message = "Success";
        String token = "token123";
        String refreshToken = "refreshToken456";
        String expirationTime = "2024-06-02T12:00:00Z";
        String name = "John Doe";
        UserType role = UserType.ADMIN;
        String email = "john.doe@example.com";
        String password = "password123";
        UserEntity user = mockUser;
        List<UserEntity> usersList = new ArrayList<>();
        usersList.add(mockUser);

        when(mockUser.getRole()).thenReturn(role);

        ReqRes builtReqRes = ReqRes.builder()
                .statusCode(statusCode)
                .error(error)
                .message(message)
                .token(token)
                .refreshToken(refreshToken)
                .expirationTime(expirationTime)
                .name(name)
                .role(role)
                .email(email)
                .password(password)
                .ourUsers(user)
                .ourUsersList(usersList)
                .build();

        assertEquals(statusCode, builtReqRes.getStatusCode());
        assertEquals(error, builtReqRes.getError());
        assertEquals(message, builtReqRes.getMessage());
        assertEquals(token, builtReqRes.getToken());
        assertEquals(refreshToken, builtReqRes.getRefreshToken());
        assertEquals(expirationTime, builtReqRes.getExpirationTime());
        assertEquals(name, builtReqRes.getName());
        assertEquals(role, builtReqRes.getRole());
        assertEquals(email, builtReqRes.getEmail());
        assertEquals(password, builtReqRes.getPassword());
        assertEquals(user, builtReqRes.getOurUsers());
        assertEquals(usersList, builtReqRes.getOurUsersList());
    }
}