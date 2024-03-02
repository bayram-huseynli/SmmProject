package com.example.smmproject.controller;

import com.example.smmproject.service.impl.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class EmailSendController {

   private final EmailServiceImpl emailService;


   @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", required = false)MultipartFile[] file,String to, String[] cc,String subject,String body){
       return emailService.sendEmail(file , to , cc , subject , body);
   }






}
