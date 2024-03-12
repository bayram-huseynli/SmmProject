package com.example.smmproject.service.impl;

import com.example.smmproject.dto.request.FeedBackRequest;
import com.example.smmproject.dto.response.FeedBackResponse;
import com.example.smmproject.entity.Feedback;

import com.example.smmproject.repository.FeedBackRepository;
import com.example.smmproject.service.FeedBackService;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    private final ModelMapper modelMapper;
    private final FeedBackRepository feedBackRepository;
    private final JavaMailSender mailSender;

    public FeedBackServiceImpl(ModelMapper modelMapper, FeedBackRepository feedBackRepository, JavaMailSender mailSender) {
        this.modelMapper = modelMapper;
        this.feedBackRepository = feedBackRepository;
        this.mailSender = mailSender;
    }


    @Override
    public List<FeedBackResponse> findAll() {
        return feedBackRepository
                .findAll()
                .stream()
                .map(feedback -> modelMapper.map(feedback, FeedBackResponse.class))
                .toList();
    }

    @Override
    public void create(FeedBackRequest feedBackRequest) {
        Feedback feedback =modelMapper.map(feedBackRequest, Feedback.class);
        feedBackRepository.save(feedback);
    }

    @Override
    public FeedBackResponse getById(Long id) {
        Feedback feedback = feedBackRepository.findById(id).orElseThrow(RuntimeException::new);
        return modelMapper.map(feedback, FeedBackResponse.class);
    }

    @Override
    public FeedBackResponse update(Long id, FeedBackRequest feedBackRequest) {
        feedBackRepository.findById(id).orElseThrow(RuntimeException::new);
        Feedback feedback =modelMapper.map(feedBackRequest, Feedback.class);
        feedback.setId(id);
        return modelMapper.map(feedBackRepository.save(feedback), FeedBackResponse.class);
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
        Feedback feedback = feedBackRepository.findById(id).orElseThrow(RuntimeException::new);
        feedBackRepository.delete(feedback);

    }
}
