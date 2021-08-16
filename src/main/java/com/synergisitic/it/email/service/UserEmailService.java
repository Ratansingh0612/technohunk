package com.synergisitic.it.email.service;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface UserEmailService {

	public void sendMail(String from,String to,String subject,String body);
	public void sendMail(String from, String[] to, String subject, String body);

}
