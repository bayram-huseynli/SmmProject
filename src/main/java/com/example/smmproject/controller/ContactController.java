package com.example.smmproject.controller;

import com.example.smmproject.dto.request.ContactUsRequest;
import com.example.smmproject.dto.response.ContactUsResponse;
import com.example.smmproject.service.ContactUsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contactUs")
public class ContactController {
    private final ContactUsService contactUsService;

    public ContactController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }
    @GetMapping("/all")
    public List<ContactUsResponse> getAll(){
        return contactUsService.getAll();
    }
    @PostMapping("/add")
    public Long addContact(ContactUsRequest contactUsRequest){
        return contactUsService.addContactUs(contactUsRequest);
    }

}
