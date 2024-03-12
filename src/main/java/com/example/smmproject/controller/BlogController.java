package com.example.smmproject.controller;

import com.example.smmproject.dto.request.BlogRequest;
import com.example.smmproject.dto.response.BlogResponse;
import com.example.smmproject.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/blog")
public class
BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/all")
    ResponseEntity<List<BlogResponse>> getAll(){
        List<BlogResponse> blogs=blogService.getAll();
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Void> add(BlogRequest blogRequest){
        blogService.add(blogRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<BlogResponse> getById(@PathVariable Long id){
        BlogResponse blogResponse= blogService.getById(id);
        if(blogResponse != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Long> delete(@PathVariable Long id){
        blogService.delete(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
