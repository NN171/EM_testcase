package com.example.EM_testcase.service.jwt;

import com.example.EM_testcase.exception.UserNotFoundException;
import com.example.EM_testcase.model.domain.Role;
import com.example.EM_testcase.model.domain.User;
import com.example.EM_testcase.model.dto.AuthRequest;
import com.example.EM_testcase.model.dto.AuthResponse;
import com.example.EM_testcase.repository.UserRepository;
import com.example.EM_testcase.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(AuthRequest authRequest) {
        var user = User.builder()
                .email(authRequest.getEmail())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .role(Role.valueOf(authRequest.getRole()))
                .build();

        userRepository.save(user);
        var jwt = jwtService.generateToken((UserDetails) user);
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthResponse authenticateUser(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );

        var user = userRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException(authRequest.getEmail()));

        var jwt = jwtService.generateToken((UserDetails) user);

        return AuthResponse.builder()
                .token(jwt)
                .build();
    }
}
