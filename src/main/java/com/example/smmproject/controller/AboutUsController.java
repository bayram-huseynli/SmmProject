package com.example.smmproject.controller;

import com.example.smmproject.dto.Request.AboutUsRequest;
import com.example.smmproject.dto.Response.AboutUsResponse;
import com.example.smmproject.service.AboutUsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aboutUs/v1")
public class AboutUsController {

    private final AboutUsService aboutUsService;

    public AboutUsController(AboutUsService aboutUsService) {
        this.aboutUsService = aboutUsService;
    }

    @GetMapping
    public ResponseEntity<List<AboutUsResponse>> findAll(){
    return new ResponseEntity<>(aboutUsService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody AboutUsRequest aboutUsRequest){
        aboutUsService.create(aboutUsRequest);
    }

    @GetMapping("/id")
    public AboutUsResponse getById(@PathVariable Long id){
        return aboutUsService.getById(id);
    }

    @PutMapping("/id")
    public void update(@PathVariable Long id,@RequestBody AboutUsRequest aboutUsRequest){
        aboutUsService.update(id,aboutUsRequest);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id){
        aboutUsService.delete(id);
    }





}
