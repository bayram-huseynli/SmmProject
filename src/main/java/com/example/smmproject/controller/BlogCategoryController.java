package com.example.smmproject.controller;


import com.example.smmproject.dto.Request.BlogCategoryRequest;
import com.example.smmproject.dto.Request.BlogRequest;
import com.example.smmproject.dto.Response.BlogCategoryResponse;
import com.example.smmproject.dto.Response.BlogResponse;
import com.example.smmproject.service.BlogCategoryService;
import com.example.smmproject.service.BlogService;
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
    ResponseEntity<List<BlogResponse>> getAll(){
        List<BlogCategoryResponse> blogs=blogCategoryService.getAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<BlogCategoryRequest> add(BlogCategoryRequest blogCategoryRequest){
        blogCategoryService.add(blogCategoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<BlogCategoryResponse> getById(@PathVariable Long id){
        BlogCategoryResponse blogCategoryResponse= blogCategoryService.getById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Long> delete(@PathVariable Long id){
        blogCategoryService.delete(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
