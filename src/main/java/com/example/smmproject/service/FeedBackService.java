package com.example.smmproject.service;

import com.example.smmproject.dto.request.FeedBackRequest;
import com.example.smmproject.dto.response.FeedBackResponse;

import java.util.List;

public interface FeedBackService {

    List<FeedBackResponse> findAll();

    void create(FeedBackRequest feedBackRequest);

    FeedBackResponse getById(Long id);

    FeedBackResponse update(Long id, FeedBackRequest feedBackRequest);
    void sendEmail(String toEmail,String subject,String body);

    void delete(Long id);
}
