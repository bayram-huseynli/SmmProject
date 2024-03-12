package com.example.smmproject.controller;

import com.example.smmproject.dto.request.AboutUsRequest;
import com.example.smmproject.dto.response.AboutUsResponse;
import com.example.smmproject.service.AboutUsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aboutUs")
public class AboutUsController {

    private final AboutUsService aboutUsService;

    public AboutUsController(AboutUsService aboutUsService) {
        this.aboutUsService = aboutUsService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<AboutUsResponse>> findAll(){
    return new ResponseEntity<>(aboutUsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void create(@RequestBody AboutUsRequest aboutUsRequest){
        aboutUsService.create(aboutUsRequest);
    }

    @GetMapping("getById/{id}")
    public AboutUsResponse getById(@PathVariable Long id){
        return aboutUsService.getById(id);
    }

    @PutMapping("update/{id}")
    public void update(@PathVariable Long id,@RequestBody AboutUsRequest aboutUsRequest){
        aboutUsService.update(id,aboutUsRequest);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        aboutUsService.delete(id);
    }





}
