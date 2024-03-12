package com.example.smmproject.service;

import com.example.smmproject.dto.request.UserRequest;
import com.example.smmproject.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse saveUser(UserRequest userRequest);

    UserResponse findById(Long id);

    UserResponse update(Long userId, UserRequest userRequest);

    void delete(Long id);
}