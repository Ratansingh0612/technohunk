package com.synergisitic.it.email.service;

import java.io.StringWriter;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.synergisitic.it.email.service.vo.EmailMessageVO;
import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.service.GuestUserService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.techquiz.codings.web.controller.vo.ConsultantsSubmittedCodeVO;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

/**
 * 
 * @author Nagendra
 * @since 10-Sept-2017 
 */
@Service("AttendanceEmailReminderService")
@Scope("singleton")
public class ConsultantRegistrationWelcomeService implements IAttendanceEmailReminderService {

	@Autowired
    @Qualifier("javaMailSender")
	private JavaMailSender mailSender;
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	
	@Autowired
	@Qualifier("GuestUserServiceImpl")
	private GuestUserService guestUserService;

	@Autowired
	@Qualifier("velocityEngine")
	private VelocityEngine velocityEngine;
	
	 @Value("${company.email}")
	 private String companyEmail;
	 
	 @Value("${company.name}")
	 private String companyName;
	
	 @Value("${website.url}")
	 private String websiteUrl;
	 
	 @Value("${company.number}")
	 private String companyNumber;
	 
	 @Value("${company.email.from}")
	 private String companyEmailFrom;
	 
	 @Value("${company.email.cc}")
	 private String companyCcEmail;
	
	/**
	 * 
	 * @return
	 */
	@Override
	@Async
	public String sendConfirmationEmail(String emailMessage,String name,String toEmail,String imageContextPath){
		  
		MimeMessage message = this.mailSender.createMimeMessage();
		    try {
		    	InternetAddress fromAddress = new InternetAddress(companyEmail, companyName);
		    	message.setFrom(fromAddress);
		    	message.setSubject("Regarding confirmation message from "+companyName);
		    	message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));
		    	message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(toEmail));
		        message.setSentDate(new Date());
		
		       MimeMultipart multipart = new MimeMultipart("related");
		       BodyPart messageBodyPart = new MimeBodyPart();
		       
		       //picking template to email from velocity
		       String templateName="message-confirmation-email.vm";
		       Template template = this.velocityEngine.getTemplate("./templates/" + templateName);
		       
		       VelocityContext velocityContext = new VelocityContext();
		       velocityContext.put("userid", name);
		       velocityContext.put("emailMessage", emailMessage);
		       velocityContext.put("websiteUrl", websiteUrl);
		       velocityContext.put("companyName", companyName);
	           StringWriter stringWriter = new StringWriter();
		       template.merge(velocityContext, stringWriter);
		       System.out.println(" :-" + stringWriter.toString());
		       
		       messageBodyPart.setContent(stringWriter.toString(), "text/html");
		       multipart.addBodyPart(messageBodyPart);

		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String imageURI=imageContextPath+"welcome-test.jpg";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(imageURI)));
		       messageBodyPart.setHeader("Content-ID", "<image>");
		       multipart.addBodyPart(messageBodyPart);
		 
		       //adding multipart into the email message which has to send
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
	public String sendWelcomeEmailToConsultant(ConsultantsVO consultantsVO,String imageContextPath){
		    MimeMessage message = this.mailSender.createMimeMessage();
		    try {
		    	InternetAddress fromAddress = new InternetAddress(companyEmail, companyName);
		    	message.setFrom(fromAddress);
		    	message.setSubject("Regarding profile creation in "+companyName+" for online technical assessment.");
		    	message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(consultantsVO.getEmail()));
		        message.setSentDate(new Date());
		
		       MimeMultipart multipart = new MimeMultipart("related");
		       BodyPart messageBodyPart = new MimeBodyPart();
		       String templateName="profile-creation-welcome.vm";
		       Template template = this.velocityEngine.getTemplate("./templates/" + 
		        templateName);
		       VelocityContext velocityContext = new VelocityContext();
		       velocityContext.put("consultantsVO", consultantsVO);
		       velocityContext.put("companyName", companyName);
		       velocityContext.put("websiteUrl", websiteUrl);
		       velocityContext.put("companyNumber", companyNumber);
		       velocityContext.put("companyEmail", companyEmail);
	           StringWriter stringWriter = new StringWriter();
		       template.merge(velocityContext, stringWriter);
		       System.out.println(" :-" + stringWriter.toString());
		       messageBodyPart.setContent(stringWriter.toString(), "text/html");
		       multipart.addBodyPart(messageBodyPart);
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/5345jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://www.gmail.com/img/fddfe.jpg")));
		       String imageURI=imageContextPath+"welcome.png";
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
	 *  This method  is used to send email to the user once his test
	 *  is completed
	 *  
	 *  @textMessage this is message which is sent to the user in  the email
	 *  @param userOnlineExamStatus 
	 *  @us
	 */
	@Async
	public String sendCompletedTestEmail(UserOnlineExamStatus userOnlineExamStatus, EmailMessageVO emailMessageVO)
	{  
		MimeMessage message = this.mailSender.createMimeMessage();
		    try {
		    	InternetAddress fromAddress = new InternetAddress(companyEmailFrom, companyName);
		    	message.setFrom(fromAddress);
		    	message.setSubject("Regarding online tech test result summary - "+emailMessageVO.getName()+".");
		    	message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(emailMessageVO.getToEmail()));
		    	message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(companyCcEmail));
		    	//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailMessageVO.getToEmail()));
		        message.setSentDate(new Date());
		
		       MimeMultipart multipart = new MimeMultipart("related");
		       BodyPart messageBodyPart = new MimeBodyPart();
		       
		       //picking template to email from velocity
		       String templateName="test-complete-email.vm";
		       Template template = this.velocityEngine.getTemplate("./templates/" + templateName);
		       
		       VelocityContext velocityContext = new VelocityContext();
		      // velocityContext.put("emailMessage", textMessage);
		       velocityContext.put("userOnlineExamStatus", userOnlineExamStatus);
		      // velocityContext.put("userId", userId);
		       velocityContext.put("emailMessageVO", emailMessageVO);
		       velocityContext.put("companyName", companyName);
		       velocityContext.put("websiteUrl", websiteUrl);
		       double smarks=userOnlineExamStatus.getSecureMarks();
		       double totalMarks=userOnlineExamStatus.getTotalMarks();
			   double cmarks = smarks/totalMarks;
			   NumberFormat defaultFormat = NumberFormat.getPercentInstance();
			   defaultFormat.setMinimumFractionDigits(1);
			   String calucatedSecureMarkPer=defaultFormat.format(cmarks);
			   velocityContext.put("calucatedSecureMarkPer", calucatedSecureMarkPer);
		       //* $emailMessageVO.userid
			   //Bug fixed @ 29-AUG-2018 Not Attempted Questions question in  summary report
			   int notAttemptedQuestions=userOnlineExamStatus.getTotalMarks()-(userOnlineExamStatus.getTotalCorrectAnswer()+userOnlineExamStatus.getTotalWrongAnswer());
			   velocityContext.put("notAttemptedQuestions", notAttemptedQuestions);
	           StringWriter stringWriter = new StringWriter();
		       template.merge(velocityContext, stringWriter);
		      // System.out.println(" :-" + stringWriter.toString());
		       
		       messageBodyPart.setContent(stringWriter.toString(), "text/html");
		       multipart.addBodyPart(messageBodyPart);
		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String cimage=emailMessageVO.getImageContextPath()+"results.jpg";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(cimage)));
		       messageBodyPart.setHeader("Content-ID", "<cimage>");
		       multipart.addBodyPart(messageBodyPart);
		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String imageURI=emailMessageVO.getImageContextPath()+"college_students.jpg";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(imageURI)));
		       messageBodyPart.setHeader("Content-ID", "<image>");
		       multipart.addBodyPart(messageBodyPart);
		 
		       //adding multipart into the email message which has to send
		       message.setContent(multipart);
		       this.mailSender.send(message);
		     } catch (Exception exe) {
		     exe.printStackTrace();
		    }
		return ApplicationContant.SUCCESS;
	}
	
	
	/**
	 *  This method  is used to send email to the user once his test
	 *  is completed
	 *  
	 *  @textMessage this is message which is sent to the user in  the email
	 *  @param userOnlineExamStatus 
	 *  @us
	 */
	@Async
	@Override
	public String sendCodingProblemSummaryEmail(ConsultantsSubmittedCodeVO consultantsSubmittedCodeVO, EmailMessageVO emailMessageVO)
	{  
		MimeMessage message = this.mailSender.createMimeMessage();
		    try {
		    	InternetAddress fromAddress = new InternetAddress(companyEmailFrom, companyName);
		    	message.setFrom(fromAddress);
		    	message.setSubject("Regarding online coding problem result summary - "+emailMessageVO.getName()+".");
		    	message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(emailMessageVO.getToEmail()));
		    	message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(companyCcEmail));
		    	//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailMessageVO.getToEmail()));
		        message.setSentDate(new Date());
		
		       MimeMultipart multipart = new MimeMultipart("related");
		       BodyPart messageBodyPart = new MimeBodyPart();
		       
		       //picking template to email from velocity
		       String templateName="coding-problem-summary.vm";
		       Template template = this.velocityEngine.getTemplate("./templates/" + templateName);
		       
		       VelocityContext velocityContext = new VelocityContext();
		      // velocityContext.put("emailMessage", textMessage);
		       velocityContext.put("consultantsSubmittedCodeVO", consultantsSubmittedCodeVO);
		      // velocityContext.put("userId", userId);
		       velocityContext.put("emailMessageVO", emailMessageVO);
		       velocityContext.put("companyName", companyName);
		       velocityContext.put("websiteUrl", websiteUrl);
		       //* $emailMessageVO.userid
		       
	           StringWriter stringWriter = new StringWriter();
		       template.merge(velocityContext, stringWriter);
		      // System.out.println(" :-" + stringWriter.toString());
		       
		       messageBodyPart.setContent(stringWriter.toString(), "text/html");
		       multipart.addBodyPart(messageBodyPart);
		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String cimage=emailMessageVO.getImageContextPath()+"results.jpg";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(cimage)));
		       messageBodyPart.setHeader("Content-ID", "<cimage>");
		       multipart.addBodyPart(messageBodyPart);
		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String imageURI=emailMessageVO.getImageContextPath()+"/codings/coding-regards.png";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(imageURI)));
		       messageBodyPart.setHeader("Content-ID", "<image>");
		       multipart.addBodyPart(messageBodyPart);
		 
		       //adding multipart into the email message which has to send
		       message.setContent(multipart);
		       this.mailSender.send(message);
		     } catch (Exception exe) {
		     exe.printStackTrace();
		    }
		return ApplicationContant.SUCCESS;
	}


	
	/**
	 *  This method  is used to send email to the user once his test
	 *  is completed
	 *  
	 *  @textMessage this is message which is sent to the user in  the email
	 *  @param userOnlineExamStatus 
	 *  @us
	 */
	
	@Async
	@Override
	public String sendCompletedTestSummaryWithQuizAnsEmail(List<QuestionAndAnsTestDataVO> questionList ,UserOnlineExamStatus userOnlineExamStatus, EmailMessageVO emailMessageVO)	{
		 questionList = new ArrayList<QuestionAndAnsTestDataVO>();
		 AvailableGuestTest testData=guestUserService.loadAvailableTestByTechTestName(userOnlineExamStatus.getTechName(),userOnlineExamStatus.getTestName());
			// System.out.println(testData.toString());
		String questionIdsInArray[] = testData.getQuestionIds().split(",");
		String questionId="";
		for (String q : questionIdsInArray) {
			questionId=q;
			QuestionAndAnsTestDataVO question = onlineTechTestService.fetchNextQuestionAnswer(q, userOnlineExamStatus.getUserId(), userOnlineExamStatus.getTestName(),userOnlineExamStatus.getTechName(),
					userOnlineExamStatus.getUserSessionId());
			String selectedAnswerId = onlineTechTestService
					.findExamDetail(userOnlineExamStatus.getUserId(), userOnlineExamStatus.getTestName(),userOnlineExamStatus.getTechName(), userOnlineExamStatus.getUserSessionId(), q).getSelectedAnswerId();
			question.setSelectedOption(selectedAnswerId);
			questionList.add(question);
		}
		
		MimeMessage message = this.mailSender.createMimeMessage();
		    try {
		    	InternetAddress fromAddress = new InternetAddress(companyEmailFrom, companyName);
		    	message.setFrom(fromAddress);
		    	message.setSubject("Regarding online tech test result summary with questions & answer @ candidate name : "+emailMessageVO.getName());
		    	message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(companyCcEmail));
		    	//message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(companyCcEmail));
		    	//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailMessageVO.getToEmail()));
		        message.setSentDate(new Date());
		
		       MimeMultipart multipart = new MimeMultipart("related");
		       BodyPart messageBodyPart = new MimeBodyPart();
		       //picking template to email from velocity
		       String templateName="guest-exam-details-summary.vm";
		       Template template = this.velocityEngine.getTemplate("./templates/" + templateName);
		       VelocityContext velocityContext = new VelocityContext();
		      // velocityContext.put("emailMessage", textMessage);
		       velocityContext.put("questionList", questionList);
		      // velocityContext.put("userId", userId);
		       velocityContext.put("userOnlineExamStatus", userOnlineExamStatus);
		       velocityContext.put("emailMessageVO", emailMessageVO);
		       velocityContext.put("companyName", companyName);
		       velocityContext.put("websiteUrl", websiteUrl);
		       //* $emailMessageVO.userid
		       double smarks=userOnlineExamStatus.getSecureMarks();
		       double totalMarks=userOnlineExamStatus.getTotalMarks();
			   double cmarks = smarks/totalMarks;
			   NumberFormat defaultFormat = NumberFormat.getPercentInstance();
			   defaultFormat.setMinimumFractionDigits(1);
			   String calucatedSecureMarkPer=defaultFormat.format(cmarks);
			   velocityContext.put("calucatedSecureMarkPer", calucatedSecureMarkPer);
		       
	           StringWriter stringWriter = new StringWriter();
		       template.merge(velocityContext, stringWriter);
		     //  System.out.println(" :-" + stringWriter.toString());
		       System.out.println("Email has been sent!!!!!");
		       messageBodyPart.setContent(stringWriter.toString(), "text/html");
		       multipart.addBodyPart(messageBodyPart);
		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String cimage=emailMessageVO.getImageContextPath()+"results.jpg";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(cimage)));
		       messageBodyPart.setHeader("Content-ID", "<cimage>");
		       multipart.addBodyPart(messageBodyPart);
		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String imageURI=emailMessageVO.getImageContextPath()+"pquestion.png";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(imageURI)));
		       messageBodyPart.setHeader("Content-ID", "<image2>");
		       multipart.addBodyPart(messageBodyPart);
		       
		       messageBodyPart = new MimeBodyPart();
		       //DataSource fds = new FileDataSource("D:/eeeeeee.jpg");
		       //messageBodyPart.setDataHandler(new DataHandler(new URL("http://sdfs/img/eeee.jpg")));
		       String correctIcon=emailMessageVO.getImageContextPath()+"icon/currect-icon-35.png";
		       //pick image from below URL
		       messageBodyPart.setDataHandler(new DataHandler(new URL(correctIcon)));
		       messageBodyPart.setHeader("Content-ID", "<image3>");
		       multipart.addBodyPart(messageBodyPart);
		 
		       //adding multipart into the email message which has to send
		       message.setContent(multipart);
		       this.mailSender.send(message);
		     } catch (Exception exe) {
		     exe.printStackTrace();
		    }
		return ApplicationContant.SUCCESS;
	}
	
}
