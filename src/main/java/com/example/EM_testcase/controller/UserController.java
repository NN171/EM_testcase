package com.example.EM_testcase.controller;

import com.example.EM_testcase.model.dto.AuthRequest;
import com.example.EM_testcase.model.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/effective/users")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(new AuthResponse());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(new AuthResponse());
    }
}
