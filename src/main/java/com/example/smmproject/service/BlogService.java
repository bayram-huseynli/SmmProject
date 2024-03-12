package com.example.smmproject.service;

import com.example.smmproject.dto.request.BlogRequest;
import com.example.smmproject.dto.response.BlogResponse;

import java.util.List;

public interface BlogService {

    List<BlogResponse> getAll();

    void add(BlogRequest blogRequest);

    BlogResponse getById(Long id);

    void delete(Long id);
}
