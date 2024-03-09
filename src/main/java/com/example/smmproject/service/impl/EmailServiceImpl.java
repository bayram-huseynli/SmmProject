package com.example.smmproject.service.impl;

import com.example.smmproject.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    private JavaMailSender javaMailSender;


    @Override
    public String sendEmail(MultipartFile[] file, String to, String[] cc, String subject, String body) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setSubject(subject);

            for(int i = 0; i< file.length; i++){
                mimeMessageHelper.addAttachment(
                        Objects.requireNonNull(file[i].getOriginalFilename()),
                        new ByteArrayResource(file[i].getBytes())
                );
            }

            javaMailSender.send(mimeMessage);

            return "mail send";

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}