package com.example.smmproject.controller;

import com.example.smmproject.dto.Request.PortfolioRequest;
import com.example.smmproject.dto.Response.PortfolioResponse;
import com.example.smmproject.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio/")
public class PortfolioController {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }
    @GetMapping("/all")
    ResponseEntity<List<PortfolioResponse>> getAll(){
        List<PortfolioResponse> portfolios=portfolioService.getAll();
        return new ResponseEntity<>(portfolios, HttpStatus.OK);
    }
    @PostMapping("/add")
    ResponseEntity<PortfolioRequest> add(PortfolioRequest portfolioRequest){
        portfolioService.add(portfolioRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getById/{id}")
    ResponseEntity<PortfolioResponse> getById(@PathVariable Long id) {
        PortfolioResponse portfolioResponse = portfolioService.getById(id);
        if (portfolioResponse != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delete/{id}")
    ResponseEntity<Long> delete(@PathVariable Long id){
        portfolioService.delete(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
