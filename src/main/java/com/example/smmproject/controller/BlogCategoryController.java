package com.example.smmproject.controller;


import com.example.smmproject.dto.request.BlogCategoryRequest;

import com.example.smmproject.dto.response.BlogCategoryResponse;

import com.example.smmproject.service.BlogCategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogCategory")
public class BlogCategoryController {

    private final BlogCategoryService blogCategoryService;

    public BlogCategoryController(BlogCategoryService blogCategoryService) {
        this.blogCategoryService = blogCategoryService;
    }

    @GetMapping("/all")
    ResponseEntity<List<BlogCategoryResponse>> getAll(){
        List<BlogCategoryResponse> blogs=blogCategoryService.getAll();

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Void> add(BlogCategoryRequest blogCategoryRequest){
        blogCategoryService.add(blogCategoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<BlogCategoryResponse> getById(@PathVariable Long id){
        BlogCategoryResponse blogCategoryResponse= blogCategoryService.getById(id);
        return new ResponseEntity<>(blogCategoryResponse,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Long> delete(@PathVariable Long id){
        blogCategoryService.delete(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
