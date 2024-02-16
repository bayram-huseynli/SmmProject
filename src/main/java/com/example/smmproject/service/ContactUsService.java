package com.example.smmproject.service;

import com.example.smmproject.dto.Request.ContactUsRequest;
import com.example.smmproject.dto.Response.ContactUsResponse;

import java.util.List;

public interface ContactUsService {

    List<ContactUsResponse> findAll();

    void create(ContactUsRequest contactUsRequest);

    ContactUsResponse getById(Long id);

    ContactUsResponse update(Long id,ContactUsRequest contactUsRequest);
    void sendEmail(String toEmail,String subject,String body);

    void delete(Long id);
}
