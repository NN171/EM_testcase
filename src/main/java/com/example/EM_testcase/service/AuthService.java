package com.example.EM_testcase.service;

import com.example.EM_testcase.model.dto.AuthRequest;

public interface AuthService {
    String login(AuthRequest authRequest);
}
