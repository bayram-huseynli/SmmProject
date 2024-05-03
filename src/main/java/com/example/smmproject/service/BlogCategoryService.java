package com.example.smmproject.service;

import com.example.smmproject.dto.request.BlogCategoryRequest;
import com.example.smmproject.dto.response.BlogCategoryResponse;

import java.util.List;

public interface BlogCategoryService {

    List<BlogCategoryResponse> getAll();

    void add(BlogCategoryRequest blogCategoryRequest);

    BlogCategoryResponse getById(Long id);

    BlogCategoryResponse updateCategory(Long id,BlogCategoryRequest blogCategoryRequest);

    void delete(Long id);
}
