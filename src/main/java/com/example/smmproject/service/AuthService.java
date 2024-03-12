package com.example.smmproject.service;

import com.example.smmproject.dto.request.LoginRequest;
import com.example.smmproject.dto.request.SignupRequest;
import com.example.smmproject.dto.response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    JwtResponse authenticateUser(LoginRequest loginRequest);
    ResponseEntity<String> registerUser(SignupRequest signupRequest);

}
