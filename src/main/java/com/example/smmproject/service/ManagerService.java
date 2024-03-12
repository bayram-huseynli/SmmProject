package com.example.smmproject.service;

import com.example.smmproject.dto.request.ManagerRequest;
import com.example.smmproject.dto.response.ManagerResponse;

import java.util.List;

public interface ManagerService {

    List<ManagerResponse> findAll();

    void create(ManagerRequest managerRequest);

    ManagerResponse getById(Long id);

    ManagerResponse update(Long id, ManagerRequest managerRequest);

    void delete(Long id);
}
