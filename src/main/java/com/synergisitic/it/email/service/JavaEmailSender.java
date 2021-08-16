package com.synergisitic.it.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("OnlineJavaEmailSender")
public class JavaEmailSender {
	
	 @Autowired
	    @Qualifier("javaMailSender")
	    private MailSender mailSender;
	    
	    public void sendMail(String from, String to, String subject, String body) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(from);
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	        
	    }

}
