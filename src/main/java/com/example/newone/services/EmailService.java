package com.example.newone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
   // static VerificationService verificationService=new VerificationService();

    public  String  sendMail(String to,String name)
    {
        String vf =VerificationService.getVerificationCode();
        System.out.println("sending");
        SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
        simpleMailMessage.setFrom("myheroprogramming@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("My Hero Verification");
        simpleMailMessage.setText("Hello "+ name +" hope this email finds you well" +
                "\n Here is your Verification code "+vf);
        javaMailSender.send(simpleMailMessage);
        System.out.println("send");
        return vf;
    }

}
