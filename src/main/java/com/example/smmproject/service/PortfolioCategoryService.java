package com.example.smmproject.service;

import com.example.smmproject.dto.Request.PortfolioCategoryRequest;
import com.example.smmproject.dto.Response.PortfolioCategoryResponse;


import java.util.List;

public interface PortfolioCategoryService {
    List<PortfolioCategoryResponse> getAll();
    void add(PortfolioCategoryRequest portfolioCategoryRequest);
    PortfolioCategoryResponse getById(Long id);
    void delete(Long id);
}
