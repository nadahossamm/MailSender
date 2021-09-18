package com.example.newone;

import com.example.newone.services.EmailService;
import com.example.newone.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class UserApi {
	public static void main(String[] args) {
		SpringApplication.run(UserApi.class, args);

	}
//
//@EventListener(ApplicationReadyEvent.class)
//	public void run()
//{
//	emailService.sendMail("nada.hossam19621@gmail.com");
//}
}
