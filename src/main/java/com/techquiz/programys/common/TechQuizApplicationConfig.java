package com.techquiz.programys.common;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

/**
 * 
 * @author Nagendra
 *
 */
@Service
public class TechQuizApplicationConfig  implements ServletContextAware{
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(TechQuizApplicationConfig.class);

	private ServletContext servletContext;
	
	 @Value("${company.email}")
	 private String companyEmail;
	 
	 @Value("${company.name}")
	 private String companyName;
	 
		
	 @Value("${company.number}")
	 private String companyNumber;
	 
	 @Value("${company.address}")
	 private String companyAddress;
	 
	 @Value("${company.study.mat}")
	 private String companyStudyMat;
	 
	 @Value("${guest.questions.no}")
	 private String guestQuestionsNo;
	 
	 @Value("${guest.right.answers.show}")
	 private String guestRightAnswersShow;
	 
	 @Value("${guest.wrong.answers.show}")
	 private String guestWrongAnswersShow;
	 
	 
	 @Value("${company.url}")
	 private String companyUrl;
	 
	 @Value("${app.base.url}")
	 private String appBaseUrl;
	 
	// @Value("#{website.url ?: 'www.comingsoon.com'}")
	 private String websiteUrl="www.jobsjobs.com";
	 
	
	@PostConstruct
	public void initConfig(){
		if(logger.isDebugEnabled()) {
				logger.debug("Initializing Servlet Context");
				logger.debug("companyEmail = "+companyEmail);
				logger.debug("appBaseUrl = "+appBaseUrl);
				logger.debug("companyName = "+companyName);
				logger.debug("websiteUrl = "+websiteUrl);
				logger.debug("companyNumber = "+companyNumber);
				logger.debug("companyAddress = "+companyAddress);
				logger.debug("companyStudyMat = "+companyStudyMat);
				logger.debug("guestQuestionsNo = "+guestQuestionsNo);
				logger.debug("companyUrl = "+companyUrl);
		}
		servletContext.setAttribute("companyEmail", companyEmail);
		servletContext.setAttribute("appBaseUrl", appBaseUrl);
		servletContext.setAttribute("companyName", companyName);
		servletContext.setAttribute("websiteUrl", websiteUrl);
		servletContext.setAttribute("companyNumber", companyNumber);
		servletContext.setAttribute("companyAddress", companyAddress);
		servletContext.setAttribute("companyStudyMat", companyStudyMat);
		servletContext.setAttribute("guestQuestionsNo", guestQuestionsNo);
		servletContext.setAttribute("companyUrl", companyUrl);
		servletContext.setAttribute("guestRightAnswersShow", guestRightAnswersShow);
		servletContext.setAttribute("guestWrongAnswersShow", guestWrongAnswersShow);
	}
	
	
	@Override
	public void setServletContext(ServletContext servletContext) {
			this.servletContext=servletContext;
	}

}
