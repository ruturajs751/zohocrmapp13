package com.zohocrm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImp implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendMail(String to, String sub, String emailBody) {
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(emailBody);
		mailMessage.setText(emailBody);
		
		javaMailSender.send(mailMessage);
	}

}
