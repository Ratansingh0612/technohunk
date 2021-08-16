package com.synergisitic.it.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.email.service.IAttendanceEmailReminderService;
import com.synergisitic.it.model.Answers;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.navigation.AdminNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.QuestionAndAnswerService;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.CRLFToHTML;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.QuestionAndAnswers;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.info.jdbc.service.UploadRecordExcelService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.trainer.web.rest.api.vo.TestNameTopicsVO;

/**
 * 
 * @author nagendra.yadav
 *
 */

@Controller
public class QuestionAndAnswerController {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(QuestionAndAnswerController.class);
	
	@Autowired
	@Qualifier("QuestionAndAnswerServiceImpl")
	private QuestionAndAnswerService questionAndAnswerService;
	
	@Autowired
	@Qualifier("UserAdminCommonServiceImpl")
	private UserAdminCommonService userAdminCommonService;

	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	
	
	@Autowired
	@Qualifier("AttendanceEmailReminderService")
	private IAttendanceEmailReminderService attendanceEmailReminderService;
	
	@Autowired
	@Qualifier("UploadRecordExcelServiceImpl")
	private UploadRecordExcelService uploadRecordExcelService;
	
	
	@RequestMapping(value="/dummy",method = RequestMethod.GET)
	public String dummyForm(ModelMap model) {
		QuestionAndAnswers questionAndAnswers = new QuestionAndAnswers();
		//command object
		model.addAttribute("questionAndAnswers", questionAndAnswers);
		//return form view
		return "addQuestionAnswer";
	}
	
	@RequestMapping(value="/edit-question-and-answer",method = RequestMethod.POST)
	public String editQuestionAnswerPost(@ModelAttribute("questionAndAnswers") QuestionAndAnswers questionAndAnswers,HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		questionAndAnswers.setLastModifyBy(userId.getLoginId());
		questionAndAnswers.setLastModifyOn(DateUtils.getCurrentJavaDate());
		System.out.println(questionAndAnswers);
		String result=questionAndAnswerService.updateQuestionAndAnswers(questionAndAnswers);
		if(logger.isDebugEnabled()){
			logger.debug("question is updated with answer = "+result);
		}
		//sending email now
		String imageContextPath=DateUtils.getImageContextPath(request);
		String message="This question "+questionAndAnswers.getQuestionText()+" has been update of technology "+questionAndAnswers.getTechnology()+" successfully into the database by "+userId.getLoginId()+" at "+DateUtils.getCurrentDate();
		String mmessage=attendanceEmailReminderService.sendConfirmationEmail(message, "Mr"+" "+"Admin", "javahunk2020@gmail.com", imageContextPath);
	//	System.out.println("------------mmessage-----------  = "+mmessage);
		if(logger.isDebugEnabled()){
			logger.debug("mmessage = "+mmessage);
		}
		QuestionAndAnswers nquestionAndAnswers = new QuestionAndAnswers();
		//command object
		model.addAttribute("questionAndAnswers", nquestionAndAnswers);
		return "redirect:/action/questions-bank?AppMsg=Your question has been updated  into the database successfully.";
	}
	
	@RequestMapping(value="/edit-question-and-answer",method = RequestMethod.GET)
	public String editQuestionAnswer(@RequestParam("questionId") String questionId,HttpSession session,Model model) {
		QuestionAndAnsTestDataVO questionAndAnsTestDataVO=onlineTechTestService.fetchNextQuestionAnswer(questionId,"","","","");
		//QuestionAndAnswers questionAndAnswers = new QuestionAndAnswers();
		//BeanUtils.copyProperties(questionAndAnsTestDataVO, questionAndAnswers);
		//questionAndAnswers.setCorrect(questionAndAnsTestDataVO.getCorrectOption());
		//command object
		model.addAttribute("questionAndAnswers", questionAndAnsTestDataVO);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.EDIT_QUESTION_AND_ANSWER_PAGE;
	}
	
	@RequestMapping(value="/delete-question-and-answer",method = RequestMethod.POST)
	public String deleteQuestionAnswer(@RequestParam("questionId") String questionId,@RequestParam("qbankName") String qbankName,@RequestParam("techName") String techName,HttpSession session,Model model) {
		userAdminCommonService.deleteQuestionFromBankByTech(questionId);
		List<QuestionsForm> questionsInBankList=uploadRecordExcelService.findQuestionsInBankByTech(qbankName,techName);
		model.addAttribute("questionsInBankList", questionsInBankList);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.QUESTION_IS_DELETED_FROM_DATABASE+questionId);
		// Fetch data for all users.
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.QUESTIONS_IN_BANK_PAGE;
}
	 
	
	@RequestMapping(value="/show-question-and-answer",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		QuestionAndAnswers questionAndAnswers = new QuestionAndAnswers();
		//command object
		model.addAttribute("questionAndAnswers", questionAndAnswers);
		//return form view
		//return NavigationPage.ADD_QUESTION_ANSWERS;
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.UPLOAD_QUESTIONS_PAGE;
	}
	
	@RequestMapping(value="/show-question-and-answer",method = RequestMethod.POST)
	@ResponseBody public ApplicationMessageResponse onSubmit(@ModelAttribute("questionAndAnswers") QuestionAndAnswers questionAndAnswers,HttpServletRequest request,Model model){
		if(logger.isDebugEnabled()){
			logger.debug(questionAndAnswers);
		}
		questionAndAnswers.setQuestionText(CRLFToHTML.process(questionAndAnswers.getQuestionText()));
		questionAndAnswers.setDateOfEntry(new Date());
		questionAndAnswers.setLastModifyOn(new Date());
		String loginId=getUserData(request).getLoginId();
		questionAndAnswers.setLastModifyBy(loginId);
		questionAndAnswers.setQuestionOwner(loginId);
		questionAndAnswers.setDescription("NA");
		questionAndAnswers.setQuestionType("Objective");
		String topicName=request.getParameter("topicName");
		questionAndAnswers.setTopic(topicName);
		questionAndAnswers.setChoiceType("Single");
		questionAndAnswers.setMarks(1);
		questionAndAnswers.setNumberOfAnswers(1);
		questionAndAnswers.setCategory(questionAndAnswers.getTechnology());
		String result=questionAndAnswerService.addQuestionAndAnswers(questionAndAnswers,true);
		if(logger.isDebugEnabled()){
			logger.debug("result comming from service layer for this method = "+result);
		}
		
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		appMsg.setStatus("yes");
		appMsg.setMessage(ApplicationMessageConstant.QUESTION_IS_UPLOADED_INTO_DATABASE);
		//return form view
		//model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.QUESTION_IS_UPLOADED_INTO_DATABASE);
		//return AdminNavigationPage.ADMIN_BASE+NavigationPage.UPLOAD_QUESTIONS_PAGE;
		 return appMsg;
	}	
	
	@RequestMapping(value="/upload-question-and-answer",method = RequestMethod.POST)
	 public String onSubmitPage(@ModelAttribute("questionAndAnswers") QuestionAndAnswers questionAndAnswers,HttpServletRequest request,Model model){
		
		if(questionAndAnswers.getQuestionText()!=null && questionAndAnswers.getQuestionText().trim().length()==0){
				model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.SORRY_DATA_SUBMITTED_BY_YOU_ARE_NOT_CORRECT);
				return AdminNavigationPage.ADMIN_BASE+NavigationPage.UPLOAD_QUESTIONS_PAGE;
		}
		if(logger.isDebugEnabled()){
			logger.debug(questionAndAnswers);
		}
		questionAndAnswers.setQuestionText(CRLFToHTML.process(questionAndAnswers.getQuestionText()));
		questionAndAnswers.setDateOfEntry(new Date());
		questionAndAnswers.setLastModifyOn(new Date());
		String loginId=getUserData(request).getLoginId();
		questionAndAnswers.setLastModifyBy(loginId);
		questionAndAnswers.setQuestionOwner(loginId);
		questionAndAnswers.setDescription("NA");
		questionAndAnswers.setQuestionType("Objective");
		String topicName=request.getParameter("topicName");
		questionAndAnswers.setTopic(topicName);
		questionAndAnswers.setChoiceType("Single");
		questionAndAnswers.setMarks(1);
		questionAndAnswers.setNumberOfAnswers(1);
		questionAndAnswers.setCategory(questionAndAnswers.getTechnology());
		String result=questionAndAnswerService.addQuestionAndAnswers(questionAndAnswers,true);
		if(logger.isDebugEnabled()){
			logger.debug("result comming from service layer for this method = "+result);
		}
		
		//ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
	//	appMsg.setStatus("yes");
		//appMsg.setMessage(ApplicationMessageConstant.QUESTION_IS_UPLOADED_INTO_DATABASE);
		//return form view
		List<String> qbankNameList=userAdminCommonService.findQuestionBankByTechName(questionAndAnswers.getTechnology());
		List<String> topics=userAdminCommonService.findTopicsByTechName(questionAndAnswers.getTechnology());
		if(topics!=null && topics.size()==0){
			topics.add("Other");
		}
		model.addAttribute("qbankNameList", qbankNameList);
		model.addAttribute("topics", topics);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.QUESTION_IS_UPLOADED_INTO_DATABASE);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.UPLOAD_QUESTIONS_PAGE;
	}	
	
	
	@RequestMapping(value="/showQuestionForm",method = RequestMethod.GET)
	public String initQuestionForm(ModelMap model) {
		Questions questions= new Questions();
		//command object
		model.addAttribute("questions",questions);
		//return form view
		return NavigationPage.ADD_QUESTIONS;
	}
	
	@RequestMapping(value="/showQuestionForm",method = RequestMethod.POST)
	public String onQuestionSubmit(@ModelAttribute("questions") Questions questions,HttpServletRequest request){
		questions.setDateOfEntry(new Date());
		questions.setLastModifyOn(new Date());
		//String loginId=getUserData(request).getLoginId();
		questions.setLastModifyBy("yadna01");
		questions.setDescription("New User!");
		String result=questionAndAnswerService.addQuestion(questions);
		//return form view
		return NavigationPage.USER_HOME;
	}	
	
	
	@RequestMapping(value="/showAnswerForm",method = RequestMethod.GET)
	public String initAnswerForm(ModelMap model) {
		Answers answers= new Answers();
		//command object
		model.addAttribute("answers",answers);
		//return form view
		return NavigationPage.ADD_ANSWERS;
	}
	
	@RequestMapping(value="/showAnswerForm",method = RequestMethod.POST)
	public String onAnswerSubmit(@ModelAttribute("answers") Answers answers,HttpServletRequest request){
		answers.setDateOfEntry(new Date());
		answers.setLastModifyOn(new Date());
		//String loginId=getUserData(request).getLoginId();
		answers.setLastModifyBy("yadna01");
		answers.setDescription("New User!");
		String result=questionAndAnswerService.addAnswer(answers);
		//return form view
		return NavigationPage.USER_HOME;
	}	
	
	@ModelAttribute("technologyList")
	public List<String> populateTechnologyList() {
		//Data referencing for web framework combo
		List<String> technologyList = new ArrayList<String>();
		/*technologyList.add("Spring MVC");
		technologyList.add("Spring");
		technologyList.add("Oracle");
		technologyList.add("JSF");
		technologyList.add("Core Java");
		technologyList.add("JSP");
		technologyList.add("Servlet");
		technologyList.add("Hibernate");
		technologyList.add("Struts2.0");*/
		List<com.synergisitic.it.web.form.Technology> availableTechList =technolgyCategoryService.findAllTechnolgy();
		for(com.synergisitic.it.web.form.Technology tech: availableTechList){
			technologyList.add(tech.getTname());
		}
		return technologyList;
	}
	
	@ModelAttribute("categoryList")
	public List<String> populateCategoryList() {
		//Data referencing for web framework combo
		List<String> categoryList = new ArrayList<String>();
		categoryList.add("Java");
		categoryList.add("Oracle");
		categoryList.add(".NET");
		categoryList.add("C");
		return categoryList;
	}
	
	@ModelAttribute("questionComplexityList")
	public List<String> questionComplexityList() {
		//Data referencing for web framework combo
		List<String> questionComplexityList = new ArrayList<String>();
		questionComplexityList.add("LOWER");
		questionComplexityList.add("MEDIUM");
		questionComplexityList.add("HIGH");
		return questionComplexityList;
	}
	
	@ModelAttribute("choiceList")
	public List<String> choiceList() {
		//Data referencing for web framework combo
		List<String> choiceList = new ArrayList<String>();
		choiceList.add("SINGLE");
		choiceList.add("MULTIPLE");
		return choiceList;
	}
	
	/**
	 * Fetching the session data for logged in user into the application
	 * @param request
	 * @return
	 */
	private UserId getUserData(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}


}
