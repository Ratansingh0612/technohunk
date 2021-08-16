package com.synergisitic.it.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("UserEmailServiceImpl")
public class UserEmailServiceImpl implements UserEmailService {

	@Autowired
	@Qualifier("javaMailSender")
	private MailSender mailSender;

	@Override
	public void sendMail(String from, String to, String subject, String body) {
		    SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(from);
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	}

	@Override
	public void sendMail(String from, String[] to, String subject, String body) {
		// TODO Auto-generated method stub
		
	}
	
	

}
