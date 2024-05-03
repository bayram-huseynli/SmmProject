package com.example.smmproject.service.impl;

import com.example.smmproject.dto.request.ContactUsRequest;
import com.example.smmproject.dto.response.ContactUsResponse;
import com.example.smmproject.entity.ContactUs;
import com.example.smmproject.exceptions.NotFoundException;
import com.example.smmproject.repository.ContactUsRepository;
import com.example.smmproject.service.ContactUsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactUsServiceImpl implements ContactUsService {
    private final ContactUsRepository contactUsRepository;
    private final ModelMapper modelMapper;

    private static final String NOT_FOUND_ERROR = "not found this id";

    public ContactUsServiceImpl(ContactUsRepository contactUsRepository, ModelMapper modelMapper) {
        this.contactUsRepository = contactUsRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ContactUsResponse> getAll() {
        List<ContactUs> contacts=contactUsRepository.findAll();
        return contacts.stream().map(contacts1->modelMapper.map(contacts,ContactUsResponse.class)).toList();
    }

    @Override
    public Long addContactUs(ContactUsRequest contactUsRequest) {
        ContactUs contact=modelMapper.map(contactUsRequest,ContactUs.class);
        contactUsRepository.save(contact);
        return contact.getId();
    }

    public void delete(Long id){
        ContactUs contactUs = contactUsRepository.findById(id).orElseThrow(()-> new NotFoundException(NOT_FOUND_ERROR));
        contactUsRepository.delete(contactUs);

    }
}
