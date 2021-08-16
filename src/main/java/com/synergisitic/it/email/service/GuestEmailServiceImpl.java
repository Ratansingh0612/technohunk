package com.synergisitic.it.email.service;

import java.io.StringWriter;
import java.net.URL;
import java.util.Date;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.GuestUserForm;
import com.techquiz.codings.web.controller.vo.CodingProblmesLinkVO;


@Service("GuestEmailServiceImpl")
public class GuestEmailServiceImpl implements GuestEmailService {
	
	@Autowired
    @Qualifier("javaMailSender")
	private JavaMailSender mailSender;

	@Autowired
	@Qualifier("velocityEngine")
	private VelocityEngine velocityEngine;
	
	 @Value("${company.email}")
	 private String companyEmail;
	 
	 @Value("${company.name}")
	 private String companyName;
	 
	 @Value("${company.email.cc}")
	 private String companyCcEmail;
	 
	 
	 @Value("${company.email.from}")
	 private String companyEmailFrom;
	 
	 
	 @Value("${online.tech.test.email.subject}")
	 private String techTestEmailSubject;
	 
	 
	 @Value("${online.tech.coding.email.subject}")
	 private String techCodingEmailSubject;
	 
	
	/**
	 * 
	 * @return
	 */
	@Override
	@Async
	public String sendTechTestEmailAsLink(GuestUserForm  guestUserForm,String imageContextPath){
		    MimeMessage message = this.mailSender.createMimeMessage();
		    
		    try {
		    	InternetAddress fromAddress = new InternetAddress(companyEmailFrom, companyName);
		    	message.setFrom(fromAddress);
		    	message.setSubject(techTestEmailSubject+"Test name - "+guestUserForm.getTestName()+")");
		    	//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(guestUserForm.getEmail()));
		    	//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(companyCcEmail));
		    	message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(guestUserForm.getEmail()));
		    	message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(companyCcEmail));
		        message.setSentDate(new Date());
		       MimeMultipart multipart = new MimeMultipart("related");
		       BodyPart messageBodyPart = new MimeBodyPart();
		       String templateName="online-test-link.vm";
		       Template template = this.velocityEngine.getTemplate("./templates/" + 
		        templateName);
		       VelocityContext velocityContext = new VelocityContext();
		       velocityContext.put("username", guestUserForm.getName());
		       if("Male".equalsIgnoreCase(guestUserForm.getGender())) {
		    	   velocityContext.put("salutation", "Mr.");
		       }
		       else{
		    	   velocityContext.put("salutation","Ms.");
		       }
		       velocityContext.put("onlinetestlink", guestUserForm.getGeneratedTestLink());
		       velocityContext.put("companyName", companyName);
		       velocityContext.put("techName", guestUserForm.getTechName());
		       velocityContext.put("testName", guestUserForm.getTestName());
	           StringWriter stringWriter = new StringWriter();
		       template.merge(velocityContext, stringWriter);
		       System.out.println(" :-" + stringWriter.toString());
		       messageBodyPart.setContent(stringWriter.toString(), "text/html");
		       multipart.addBodyPart(messageBodyPart);
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/fs.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://www.gmail.com.com/img/rewr.jpg")));
		       String imageURI=imageContextPath+"/images/welcome-test.jpg";
		       messageBodyPart.setDataHandler(new DataHandler(new URL(imageURI)));
		       messageBodyPart.setHeader("Content-ID", "<image>");
		       multipart.addBodyPart(messageBodyPart);
		       message.setContent(multipart);
		       this.mailSender.send(message);
		     } catch (Exception exe) {
		    	 	exe.printStackTrace();
		    }
		return ApplicationContant.SUCCESS;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@Override
	@Async
	public String sendCodingProblemEmailAsLink(CodingProblmesLinkVO  coding,String imageContextPath){
		    MimeMessage message = this.mailSender.createMimeMessage();
		    
		    try {
		    	InternetAddress fromAddress = new InternetAddress(companyEmailFrom, companyName);
		    	message.setFrom(fromAddress);
		    	message.setSubject(techCodingEmailSubject+"Problem name - "+coding.getProblemTitle()+")");
		    	//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(guestUserForm.getEmail()));
		    	//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(companyCcEmail));
		    	message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(coding.getEmail()));
		    	message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(companyCcEmail));
		        message.setSentDate(new Date());
		       MimeMultipart multipart = new MimeMultipart("related");
		       BodyPart messageBodyPart = new MimeBodyPart();
		       String templateName="online-coding-link.vm";
		       Template template = this.velocityEngine.getTemplate("./templates/" + 
		        templateName);
		       VelocityContext velocityContext = new VelocityContext();
		       velocityContext.put("username", coding.getName());
		       if("Male".equalsIgnoreCase(coding.getGender())) {
		    	   velocityContext.put("salutation", "Mr.");
		       }
		       else{
		    	   velocityContext.put("salutation","Ms.");
		       }
		       velocityContext.put("onlinetestlink", coding.getGeneratedCodeLink());
		       velocityContext.put("companyName", companyName);
		       velocityContext.put("techName", coding.getTechName());
		       velocityContext.put("codingTitle", coding.getProblemTitle());
	           StringWriter stringWriter = new StringWriter();
		       template.merge(velocityContext, stringWriter);
		       System.out.println(" :-" + stringWriter.toString());
		       messageBodyPart.setContent(stringWriter.toString(), "text/html");
		       multipart.addBodyPart(messageBodyPart);
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/fs.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://www.gmail.com.com/img/rewr.jpg")));
		       String imageURI=imageContextPath+"/images/codings/coding-regards.png";
		       messageBodyPart.setDataHandler(new DataHandler(new URL(imageURI)));
		       messageBodyPart.setHeader("Content-ID", "<image>");
		       multipart.addBodyPart(messageBodyPart);
		       message.setContent(multipart);
		       this.mailSender.send(message);
		     } catch (Exception exe) {
		    	 	exe.printStackTrace();
		    }
		return ApplicationContant.SUCCESS;
	}


}
