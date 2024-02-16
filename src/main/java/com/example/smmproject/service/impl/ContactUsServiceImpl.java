package com.example.smmproject.service.impl;

import com.example.smmproject.dto.Request.ContactUsRequest;
import com.example.smmproject.dto.Response.ContactUsResponse;
import com.example.smmproject.entity.ContactUs;
import com.example.smmproject.repository.ContactUsRepository;
import com.example.smmproject.service.ContactUsService;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    private final ModelMapper modelMapper;
    private final ContactUsRepository contactUsRepository;
    private final JavaMailSender mailSender;

    public ContactUsServiceImpl(ModelMapper modelMapper, ContactUsRepository contactUsRepository, JavaMailSender mailSender) {
        this.modelMapper = modelMapper;
        this.contactUsRepository = contactUsRepository;
        this.mailSender = mailSender;
    }


    @Override
    public List<ContactUsResponse> findAll() {
        return contactUsRepository
                .findAll()
                .stream()
                .map(contactUs -> modelMapper.map(contactUs,ContactUsResponse.class))
                .toList();
    }

    @Override
    public void create(ContactUsRequest contactUsRequest) {
        ContactUs contactUs=modelMapper.map(contactUsRequest,ContactUs.class);
        contactUsRepository.save(contactUs);
    }

    @Override
    public ContactUsResponse getById(Long id) {
        ContactUs contactUs=contactUsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return modelMapper.map(contactUs,ContactUsResponse.class);
    }

    @Override
    public ContactUsResponse update(Long id, ContactUsRequest contactUsRequest) {
        contactUsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        ContactUs contactUs=modelMapper.map(contactUsRequest,ContactUs.class);
        contactUs.setId(id);
        return modelMapper.map(contactUsRepository.save(contactUs),ContactUsResponse.class);
    }

    public void sendEmail(String toEmail,
                          String subject,
                          String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

    }

    @Override
    public void delete(Long id) {
        ContactUs contactUs=contactUsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        contactUsRepository.delete(contactUs);

    }
}
