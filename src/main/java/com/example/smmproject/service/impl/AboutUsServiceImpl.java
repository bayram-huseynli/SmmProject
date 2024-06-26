package com.example.smmproject.service.impl;

import com.example.smmproject.dto.Request.AboutUsRequest;
import com.example.smmproject.dto.Response.AboutUsResponse;
import com.example.smmproject.entity.AboutUs;
import com.example.smmproject.repository.AboutUsRepository;
import com.example.smmproject.service.AboutUsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AboutUsServiceImpl implements AboutUsService {

    private final ModelMapper modelMapper;
    private final AboutUsRepository aboutUsRepository;

    public AboutUsServiceImpl(ModelMapper modelMapper, AboutUsRepository aboutUsRepository) {
        this.modelMapper = modelMapper;
        this.aboutUsRepository = aboutUsRepository;
    }

    public List<AboutUsResponse> findAll(){
        return aboutUsRepository
                .findAll()
                .stream()
                .map(aboutUs -> modelMapper.map(aboutUs, AboutUsResponse.class))
                .toList();
    }
    @Override
    public void create(AboutUsRequest aboutUsRequest){
        AboutUs aboutUs=modelMapper.map(aboutUsRequest,AboutUs.class);
        aboutUsRepository.save(aboutUs);

    }
    @Override
    public AboutUsResponse getById(Long id){
        AboutUs aboutUs=aboutUsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return modelMapper.map(aboutUs,AboutUsResponse.class);
    }
    @Override
    public AboutUsResponse update(Long id, AboutUsRequest aboutUsRequest){
        aboutUsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        AboutUs aboutUs=modelMapper.map(aboutUsRequest,AboutUs.class);
        aboutUs.setId(id);
        return modelMapper.map(aboutUsRepository.save(aboutUs),AboutUsResponse.class);

    }
    @Override
    public void delete(Long id){
        AboutUs aboutUs=aboutUsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        aboutUsRepository.delete(aboutUs);
    }



}
