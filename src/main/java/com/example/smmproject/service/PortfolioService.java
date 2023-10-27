package com.example.smmproject.service;

import com.example.smmproject.dto.Request.PortfolioRequest;
import com.example.smmproject.dto.Response.PortfolioResponse;

import java.util.List;

public interface PortfolioService {
    List<PortfolioResponse> getAll();
    void add(PortfolioRequest portfolioRequest);
    PortfolioResponse getById(Long id);
    void delete(Long id);


}
