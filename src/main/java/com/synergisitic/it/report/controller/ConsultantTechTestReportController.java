package com.synergisitic.it.report.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.synergisitic.it.report.model.ConsultantTechTestVOWrapper;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.trainer.service.IConsultantAssesmentService;

@Controller
public class ConsultantTechTestReportController {
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@PostMapping("/consultant-tech-test-report/excel")
	public ModelAndView generateConsultantTechTestReportAsExcel(@RequestParam(value="techName",required=false) String ptechName,@RequestParam(value="testName",required=false) String ptestName,@RequestParam(value="batchName",required=false) String sbatchName) {
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		if(users!=null) {
			Collections.sort(users);
		}
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(users);
    	// In order to use Spring's built-in Jasper support,
    	// We are required to pass our datasource as a map parameter
    	// parameterMap is the Model of our application
    	Map<String, Object> parameterMap = new HashMap<String, Object>();
    	parameterMap.put("datasource", jrDataSource); //datasource actual java objects
    	// pdfReport is the View of our application
    	// This is declared inside the /WEB-INF/jasper-views.xml
    	//pdfReportCard name of the pdf view configured inside the jasper-view.xml
    	ModelAndView 	modelAndView = new ModelAndView("consultant-tech-test-report-excel", parameterMap);
    	return modelAndView;
		// model is type of hashMap
	/*	model.addAttribute("users", users);
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");*/
	}
	
	@PostMapping("/consultant-tech-test-report/pdf")
	public ModelAndView generateConsultantTechTestReportAsPdf(@RequestParam(value="pptechName",required=false) String ptechName,@RequestParam(value="pptestName",required=false) String ptestName,@RequestParam(value="ppbatchName",required=false) String sbatchName,HttpSession session) {
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		int sno=1;
		String dot="";
		List<ConsultantTechTestVOWrapper> consultantTechTestVOWrapperList=new ArrayList<ConsultantTechTestVOWrapper>();
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		for(UserForm  form: users){
			form.setId(sno++);
			if(form.getTechTestStatus()!=null && "complete".equalsIgnoreCase(form.getTechTestStatus())){
				form.setTechTestStatus("Completed");
			}
			ConsultantTechTestVOWrapper consultantTechTestVOWrapper=new ConsultantTechTestVOWrapper();
			consultantTechTestVOWrapper.setAvgScore("0.0");
			consultantTechTestVOWrapper.setConsultantNo("Consultant List("+(users!=null?users.size():0)+")");
			consultantTechTestVOWrapper.setDot(dot);
			consultantTechTestVOWrapper.setGroupName(sbatchName);
			consultantTechTestVOWrapper.setLeftImage("students.png");
			Calendar now = Calendar.getInstance();
		    // 
		    String currentYear=now.get(Calendar.YEAR)+"";
			consultantTechTestVOWrapper.setMainHeading("Online Technical Test Report - "+currentYear);
			consultantTechTestVOWrapper.setRightImage("bar.png");
			consultantTechTestVOWrapper.setTechName(ptechName);
			consultantTechTestVOWrapper.setTestName(ptestName);
			consultantTechTestVOWrapper.setTrainerName(userId.getName());	
			consultantTechTestVOWrapper.setId(form.getId());
			consultantTechTestVOWrapper.setName(form.getFirstName());
			consultantTechTestVOWrapper.setDot(form.getDot());
			consultantTechTestVOWrapper.setTechTestStatus(form.getTechTestStatus());
			consultantTechTestVOWrapper.setLoginid(form.getLoginid());
			consultantTechTestVOWrapper.setScore(form.getScore());
			consultantTechTestVOWrapperList.add(consultantTechTestVOWrapper);
		}
		if(consultantTechTestVOWrapperList!=null){
			Collections.sort(consultantTechTestVOWrapperList);
		}
		
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(consultantTechTestVOWrapperList);
    	// In order to use Spring's built-in Jasper support,
    	// We are required to pass our datasource as a map parameter
    	// parameterMap is the Model of our application
    	Map<String, Object> parameterMap = new HashMap<String, Object>();
    	parameterMap.put("datasource", jrDataSource); //datasource actual java objects
    	// pdfReport is the View of our application
    	// This is declared inside the /WEB-INF/jasper-views.xml
    	//pdfReportCard name of the pdf view configured inside the jasper-view.xml
    	ModelAndView 	modelAndView = new ModelAndView("consultant-tech-test-report-pdf", parameterMap);
    	return modelAndView;
		// model is type of hashMap
	/*	model.addAttribute("users", users);
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");*/
	}
	
	@GetMapping("/consultant-tech-test-report")
	public ModelAndView generateConsultantTechTestReport(@RequestParam(value="techName",required=false) String ptechName,@RequestParam(value="testName",required=false) String ptestName,@RequestParam(value="batchName",required=false) String sbatchName) {
		sbatchName="CS-VI-B";
		ptechName="Core-Java";
		ptestName="CORE_JAVA_OOPS";
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		if(users!=null) {
			Collections.sort(users);
		}
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(users);
    	// In order to use Spring's built-in Jasper support,
    	// We are required to pass our datasource as a map parameter
    	// parameterMap is the Model of our application
    	Map<String, Object> parameterMap = new HashMap<String, Object>();
    	parameterMap.put("datasource", jrDataSource); //datasource actual java objects
    	// pdfReport is the View of our application
    	// This is declared inside the /WEB-INF/jasper-views.xml
    	//pdfReportCard name of the pdf view configured inside the jasper-view.xml
    	ModelAndView 	modelAndView = new ModelAndView("consultant-tech-test-report", parameterMap);
    	return modelAndView;
		// model is type of hashMap
	/*	model.addAttribute("users", users);
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");*/
	}

}
