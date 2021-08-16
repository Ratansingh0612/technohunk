package com.synergisitic.it.email.service;


/**
 * 
 * @author nagendra.yadav
 *
 */
public class EmailSenderThread extends Thread {
	
	private  UserEmailService bankEmailService;
	private String toEMail;
	private String message;
	private String subject;
	
	public EmailSenderThread(UserEmailService bankEmailService, String toEMail,
			String message,String subject) {
		this.bankEmailService = bankEmailService;
		this.toEMail = toEMail;
		this.message = message;
		this.subject=subject;
	}

	public EmailSenderThread(String tname){
	  super(tname);
	}
	
	public void run() {
		try {
			bankEmailService.sendMail("nagendra.yadav.niit@gmail.com",toEMail,subject,message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}