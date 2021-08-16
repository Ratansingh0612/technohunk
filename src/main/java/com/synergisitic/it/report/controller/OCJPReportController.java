package com.synergisitic.it.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.synergisitic.it.base.AbstractUserSession;
import com.synergisitic.it.report.model.OCJPReportCard;
import com.synergisitic.it.report.model.OCJPReportCardWrapper;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.UserId;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class OCJPReportController extends AbstractUserSession {
	
	public OCJPReportController(){
		System.out.println("@((((((((((((((((WEEEEEEEEEEEEEEEEEEEEEEEEDDDDDDD");
		System.out.println("@((((((((((((((((WEEEEEEEEEEEEEEEEEEEEEEEEDDDDDDD");
		System.out.println("@((((((((((((((((WEEEEEEEEEEEEEEEEEEEEEEEEDDDDDDD");
		System.out.println("@((((((((((((((((WEEEEEEEEEEEEEEEEEEEEEEEEDDDDDDD");
		
	}
	
	
	@Autowired
	@Qualifier("AdminServiceImpl")
	private AdminService adminService;
	private static final Log logger = LogFactory.getLog(OCJPReportController.class);
	
	@PostConstruct
	public void init(){
		System.out.println("adminService=                      "+adminService);
		System.out.println("adminService=                      "+adminService);
		System.out.println("adminService=                      "+adminService);
		
	}
	
	@RequestMapping(value="ocjpReportCard",method=RequestMethod.GET)
	public ModelAndView ocjpReportCard(HttpSession session) {
		System.err.println(")))))))))))))))))@*****ocjpReportCard **********");
		/*String userid=getUserIdFromSession(session).getLoginId();	
		if(logger.isDebugEnabled()){
			logger.debug("ocjpReportCard method (userid = "+userid);
		}
		getUserIdFromSession(session).getLoginId();		*/
		String userid="1522010080";
    	 List<OCJPReportCard> ocjpReportCards=adminService.findReportCardByUserid(userid);
    	 OCJPReportCardWrapper cardWrapper=new OCJPReportCardWrapper();
    	 cardWrapper.setOcjpReportCards(ocjpReportCards);
    	 cardWrapper.setUserid(userid);
    	 cardWrapper.setPhoto("deleteIcon5.jpg");
   	  	List<OCJPReportCardWrapper> ocjpReportCardWrappersList = new ArrayList<OCJPReportCardWrapper>();
   	    ocjpReportCardWrappersList.add(cardWrapper);
   	    
   	  	JRDataSource jrDataSource = new JRBeanCollectionDataSource(ocjpReportCardWrappersList);
    	// In order to use Spring's built-in Jasper support,
    	// We are required to pass our datasource as a map parameter
    	// parameterMap is the Model of our application
    	Map<String, Object> parameterMap = new HashMap<String, Object>();
    	parameterMap.put("datasource", jrDataSource); //datasource actual java objects
    	// pdfReport is the View of our application
    	// This is declared inside the /WEB-INF/jasper-views.xml
    	//pdfReportCard name of the pdf view configured inside the jasper-view.xml
    	ModelAndView 	modelAndView = new ModelAndView("pdfReportCard", parameterMap);
    	return modelAndView;
	}
	
	@Override
	public UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
}
