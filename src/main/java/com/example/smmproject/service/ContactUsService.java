package com.example.smmproject.service;

import com.example.smmproject.dto.request.ContactUsRequest;
import com.example.smmproject.dto.response.ContactUsResponse;

import java.util.List;

public interface ContactUsService {
    List<ContactUsResponse> getAll();
    Long addContactUs(ContactUsRequest contactUsRequest);

    void delete(Long id);
}
