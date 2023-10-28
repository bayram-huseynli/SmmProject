package com.example.smmproject.service;

import com.example.smmproject.dto.Request.BlogCategoryRequest;
import com.example.smmproject.dto.Response.BlogCategoryResponse;

import java.util.List;

public interface BlogCategoryService {

    List<BlogCategoryResponse> getAll();

    void add(BlogCategoryRequest blogCategoryRequest);

    BlogCategoryResponse getById(Long id);

    void delete(Long id);
}
