package com.example.smmproject.controller;

import com.example.smmproject.dto.Request.PortfolioCategoryRequest;

import com.example.smmproject.dto.Response.PortfolioCategoryResponse;

import com.example.smmproject.service.PortfolioCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolioCategory/")
public class PortfolioCategoryController {
    private final PortfolioCategoryService portfolioCategoryService;


    public PortfolioCategoryController(PortfolioCategoryService portfolioCategoryService) {
        this.portfolioCategoryService = portfolioCategoryService;
    }
    @GetMapping("/all")
    ResponseEntity<List<PortfolioCategoryResponse>> getAll(){
        List<PortfolioCategoryResponse> portfolios=portfolioCategoryService.getAll();
        return new ResponseEntity<>(portfolios, HttpStatus.OK);
    }
    @PostMapping("/add")
    ResponseEntity<PortfolioCategoryRequest> add(PortfolioCategoryRequest portfolioCategoryRequest){
        portfolioCategoryService.add(portfolioCategoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getById/{id}")
    ResponseEntity<PortfolioCategoryResponse> getById(@PathVariable Long id){
        portfolioCategoryService.getById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Long> delete (@PathVariable Long id){
        portfolioCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
