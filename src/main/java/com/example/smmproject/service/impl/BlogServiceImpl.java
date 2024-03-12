package com.example.smmproject.service.impl;

import com.example.smmproject.dto.request.BlogRequest;
import com.example.smmproject.dto.response.BlogResponse;
import com.example.smmproject.entity.Blog;
import com.example.smmproject.exceptions.NotFoundException;
import com.example.smmproject.repository.BlogRepository;
import com.example.smmproject.service.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final ModelMapper modelMapper;
    private final BlogRepository blogRepository;


    private static final String NOT_FOUND_ERROR="Not found this id";

    public BlogServiceImpl(ModelMapper modelMapper, BlogRepository blogRepository) {
        this.modelMapper = modelMapper;
        this.blogRepository = blogRepository;
    }


    @Override
    public List<BlogResponse> getAll() {
        List<Blog> blogs=blogRepository.findAll();
        return blogs.stream().map(blog -> modelMapper.map(blog,BlogResponse.class)).toList();
    }

    @Override
    public void add(BlogRequest blogRequest) {
        Blog blog=modelMapper.map(blogRequest,Blog.class);
        blogRepository.save(blog);
    }

    @Override
    public BlogResponse getById(Long id) {
        Blog blog=blogRepository.findById(id).orElseThrow(()-> new NotFoundException(NOT_FOUND_ERROR));
        return modelMapper.map(blog,BlogResponse.class);
    }

    @Override
    public void delete(Long id) {
        Blog blog=blogRepository.findById(id).orElseThrow(()-> new NotFoundException(NOT_FOUND_ERROR));
        blogRepository.delete(blog);

    }
}
