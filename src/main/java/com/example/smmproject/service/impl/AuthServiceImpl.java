package com.example.smmproject.service.impl;

import com.example.smmproject.dto.request.LoginRequest;
import com.example.smmproject.dto.request.SignupRequest;
import com.example.smmproject.dto.response.JwtResponse;
import com.example.smmproject.entity.ERole;
import com.example.smmproject.entity.Role;
import com.example.smmproject.entity.User;
import com.example.smmproject.exceptions.BadRequest;
import com.example.smmproject.exceptions.NotFoundException;
import com.example.smmproject.repository.RoleRepository;
import com.example.smmproject.repository.UserRepository;
import com.example.smmproject.security.JwtUtils;
import com.example.smmproject.service.AuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public AuthServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtils jwtUtils, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }


    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new NotFoundException(""));
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        JwtResponse jwtResponse = new JwtResponse(jwt, "Bearer", userDetails.getId(), userDetails.getEmail(), roles);

        logger.info("[AUTHENTICATE USER] User '{}' has been authenticated successfully.", loginRequest.getEmail());

        return jwtResponse;
    }

    @Override
    public ResponseEntity<String> registerUser(SignupRequest signUpRequest) {
        logger.info("[REGISTER USER] Starting user registration for email: {}", signUpRequest.getEmail());

        if (Boolean.TRUE.equals(userRepository.existsByEmail(signUpRequest.getEmail()))) {
            logger.info("[REGISTER USER] Email already exists, checking verification status: {}", signUpRequest.getEmail());

           userRepository.findByEmail(signUpRequest.getEmail())
                    .orElseThrow(() -> new BadRequest("7002L"));

        }

        else {
            logger.info("[REGISTER USER] Email not found, creating new user: {}", signUpRequest.getEmail());
            String password = signUpRequest.getPassword();

            User newUser = new User();
            newUser.setEmail(signUpRequest.getEmail())
                    .setPassword(encoder.encode(password))
                    .setFirstName(signUpRequest.getFirstName())
                    .setLastName(signUpRequest.getLastName())
                    .setPhoneNumber(signUpRequest.getPhoneNumber());
            Set<String> strRoles = signUpRequest.getRole();
            Set<Role> roles = new HashSet<>();

            if (CollectionUtils.isEmpty(strRoles)) {
                        roles.add(roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new NotFoundException("7003L")));
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "ROLE_ADMIN" -> roles.add(roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new NotFoundException("")));
                        case "ROLE_USER" -> roles.add(roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new NotFoundException("")));
                        default -> throw new NotFoundException("");
                    }
                });
            }
            newUser.setRoles(roles);


            if (strRoles != null && strRoles.contains("admin")) {
                logger.info("[REGISTER USER] Attempting to send admin email for user: {}", signUpRequest.getEmail());
                logger.info("[REGISTER USER] Admin email sent successfully for user: {}", signUpRequest.getEmail());
            }
            userRepository.save(newUser);
            logger.info("[REGISTER USER] OTP email sent for new user: {}", signUpRequest.getEmail());
            logger.info("[REGISTER USER] User '{}' has been registered successfully.", signUpRequest.getEmail());
        }

        logger.info("[REGISTER USER] Generating login token for user: {}", signUpRequest.getEmail());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(signUpRequest.getEmail());
        loginRequest.setPassword(signUpRequest.getPassword());
        String token = authenticateUser(loginRequest).getToken();
        logger.info("[REGISTER USER] Login token generated successfully for user: {}", signUpRequest.getEmail());

        return ResponseEntity.ok(token);
    }



}
