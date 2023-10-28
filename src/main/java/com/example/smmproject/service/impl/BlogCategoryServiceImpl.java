package com.example.smmproject.service.impl;

import com.example.smmproject.dto.Request.BlogCategoryRequest;
import com.example.smmproject.dto.Response.BlogCategoryResponse;
import com.example.smmproject.entity.BlogCategory;
import com.example.smmproject.exceptions.BadRequest;
import com.example.smmproject.exceptions.NotFoundException;
import com.example.smmproject.repository.BlogCategoryRepository;
import com.example.smmproject.service.BlogCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {

    private final ModelMapper modelMapper;

    private final BlogCategoryRepository blogCategoryRepository;

    private static final String NOT_FOUND_ERROR="Not found this id";
    public static final String BAD_REQUEST_MESSAGE = "This category already exists";

    public BlogCategoryServiceImpl(ModelMapper modelMapper, BlogCategoryRepository blogCategoryRepository) {
        this.modelMapper = modelMapper;
        this.blogCategoryRepository = blogCategoryRepository;
    }

    @Override
    public List<BlogCategoryResponse> getAll() {
        List<BlogCategory> blogCategories=blogCategoryRepository.findAll();
        return blogCategories.stream().map(blogCategory -> modelMapper.map(blogCategory,BlogCategoryResponse.class)).toList();
    }

    @Override
    public void add(BlogCategoryRequest blogCategoryRequest) {
    if(blogCategoryRepository.existsBlogType(blogCategoryRequest.blogType())){
        throw new BadRequest(NOT_FOUND_ERROR);
    }
        BlogCategory blogCategory=modelMapper.map(blogCategoryRequest,BlogCategory.class);
        blogCategoryRepository.save(blogCategory);
    }

    @Override
    public BlogCategoryResponse getById(Long id) {
        BlogCategory blogCategory=blogCategoryRepository.findById(id).orElseThrow(()->new NotFoundException(NOT_FOUND_ERROR));
        return modelMapper.map(blogCategory,BlogCategoryResponse.class);
    }

    @Override
    public void delete(Long id) {
    BlogCategory blogCategory=blogCategoryRepository.findById(id).orElseThrow(()->new NotFoundException(NOT_FOUND_ERROR));
    blogCategoryRepository.delete(blogCategory);
    }
}
