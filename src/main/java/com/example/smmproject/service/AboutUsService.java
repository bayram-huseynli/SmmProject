package com.example.smmproject.service;

import com.example.smmproject.dto.request.AboutUsRequest;
import com.example.smmproject.dto.response.AboutUsResponse;

import java.util.List;

public interface AboutUsService {

    List<AboutUsResponse> findAll();

    void create(AboutUsRequest aboutUsRequest);

    AboutUsResponse getById(Long id);

    AboutUsResponse update(Long id, AboutUsRequest aboutUsRequest);

    void delete(Long id);

}
