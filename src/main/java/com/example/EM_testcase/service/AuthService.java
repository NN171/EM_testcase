package com.example.EM_testcase.service;

import com.example.EM_testcase.model.dto.AuthRequest;
import com.example.EM_testcase.model.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest authRequest);
    AuthResponse authenticateUser(AuthRequest authRequest);
}
