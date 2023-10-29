package com.example.smmproject.controller;

import com.example.smmproject.dto.Request.ContactUsRequest;
import com.example.smmproject.dto.Response.ContactUsResponse;
import com.example.smmproject.service.ContactUsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactUs")
public class ContactUsController {

    private final ContactUsService contactUsService;

    public ContactUsController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ContactUsResponse>> findAll(){
        return new ResponseEntity<>(contactUsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void create (@RequestBody ContactUsRequest contactUsRequest){
        contactUsService.create(contactUsRequest);
    }

    @GetMapping("getById/{id}")
    public ContactUsResponse getById(@PathVariable Long id){
        return contactUsService.getById(id);
    }

    @PutMapping("update/{id}")
    public void update(@PathVariable Long id,@RequestBody ContactUsRequest contactUsRequest){
        contactUsService.update(id,contactUsRequest);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        contactUsService.delete(id);
    }

}
