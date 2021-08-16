package com.synergisitic.it.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.base.AbstractUserSession;
import com.synergisitic.it.email.service.IAttendanceEmailReminderService;
import com.synergisitic.it.email.service.JavaEmailSender;
import com.synergisitic.it.email.service.vo.EmailMessageVO;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.GuestUserService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.AttemptQuestionAnswerDTO;
import com.synergisitic.it.web.form.GuestUserForm;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserExamDetailStatusVO;
import com.synergisitic.it.web.form.UserExamProgressDataVO;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Controller
public class OnlineTechTestController extends AbstractUserSession {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(OnlineTechTestController.class);
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("AttendanceEmailReminderService")
	private IAttendanceEmailReminderService attendanceEmailReminderService;
	
	@Autowired
	@Qualifier("GuestUserServiceImpl")
	private GuestUserService guestUserService;
	
	@Autowired
	@Qualifier("OnlineJavaEmailSender")
	private JavaEmailSender javaEmailSender;
	
	@RequestMapping(value="load-tech-test",method=RequestMethod.GET)
	public String loadTechTest(@RequestParam(value="testName",required=false) String testName,@RequestParam(value="techName",required=false) String techName,Model model,HttpSession session){
		//Apply check when test is not available
	   session.setAttribute("userSessionId", "UT"+new Date().getTime());
	   AvailableTest availableTest=onlineTechTestService.fetchAllQuestionsByTestName(testName,techName,getUserIdFromSession(session).getLoginId(),(String)session.getAttribute("userSessionId"),false);
	   StringBuilder loadedQuestionIds=new StringBuilder();
	   try {
		   loadedQuestionIds= prepareTestData(session,availableTest,testName);
  	  }catch(Exception ex){
  		  ex.printStackTrace();
  		  model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.SORRY_THERE_IS_SOME_PROBLEM_WITH_TEST);
  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
  	  }
	   pushTestProgressData(session,loadedQuestionIds,testName,techName);
	   model.addAttribute("availableTest", availableTest);
	   session.setAttribute("utestName", testName);
	   session.setAttribute("utechName", techName);
	   return UserNavigationPage.USER_BASE+UserNavigationPage.WELCOME_TEST_PAGE;
	}
	
	/**
	 * 
	 * @return
	 */
	private StringBuilder prepareTestData(HttpSession session,AvailableTest availableTest,String testName) {
		   String questionIds=availableTest.getQuestionIds();
		   //pushing all questionIds into the set
		   
		   //new code to randomize questions which are ready for test for consultants
		   //shuffle
		   String questionIdsInArray[]=questionIds.split(",");
		   if(questionIdsInArray!=null && questionIdsInArray.length>0){
			   List<String> questionidList=Arrays.asList(questionIdsInArray);
			   Collections.shuffle(questionidList);
			   questionIdsInArray =(String[])questionidList.toArray();
		   }
		   //randomize the question
		  /* if(availableTest.isRandQuestion())
		   {
			   System.out.println("randomize");
			   Random rnd = new Random();
			   for(int i=0;i<questionIdsInArray.length;i++)
			   {
				   int index = rnd.nextInt(questionIdsInArray.length);
				   String tmp = questionIdsInArray[i];
				   questionIdsInArray[i] = questionIdsInArray[index];
				   questionIdsInArray[index] = tmp;
			   }
		   }*/
		   /*Set<String> allQuestionSet=new HashSet<String>(questionIdsInArray.length);
		   for(int len=0;len<questionIdsInArray.length;len++){
			   allQuestionSet.add(questionIdsInArray[len]);
		   }*/
		   //Selecting questionId for this user.
		   int finalNumberOfQuestions=0;
		   if(questionIdsInArray.length>=availableTest.getTotalQuestions()){
			   finalNumberOfQuestions=availableTest.getTotalQuestions();
		   } else{
			   finalNumberOfQuestions=questionIdsInArray.length;
		   }
		   
		   Map <Integer,String> questionsMapForTest=new HashMap<Integer,String>(finalNumberOfQuestions);
		   StringBuilder loadedQuestionIds=new StringBuilder();
		   int index=0;
		   for(String randomQId : questionIdsInArray) {
			   index=index+1;
			   questionsMapForTest.put(index,randomQId);
			   loadedQuestionIds.append(randomQId+",");
		       if(index==finalNumberOfQuestions)
		    	break;  
		   }
		   
		   int numberOfAttForUser=onlineTechTestService.findNoOfAttemptsForCurrentTest(testName,availableTest.getTechName(), getUserIdFromSession(session).getLoginId());
		   session.setAttribute("numberOfAttForUser",numberOfAttForUser);
		   session.setAttribute("currentQuestionNo",0);
		   session.setAttribute("testDuration",availableTest.getTestDuration());
		   session.setAttribute("questionsMapForTest",questionsMapForTest);
		   session.setAttribute("testName",testName);
		   session.setAttribute("techName",availableTest.getTechName());
		   //session.setAttribute("userSessionId", "UT"+new Date().getTime());
		   return loadedQuestionIds;
	}
	
	/**
	 *  Method which will persist data when test starts
	 *  first time and it will be used when test is restarted in between.
	 * @param session
	 * @param loadedQuestionIds
	 * @param testName
	 */
	private void pushTestProgressData(HttpSession session,StringBuilder loadedQuestionIds,String testName,String techName) {
		   UserExamProgressDataVO userExamProgressDataVO=new UserExamProgressDataVO();
		   userExamProgressDataVO.setAssignedQuestionIds(loadedQuestionIds.toString());
		   userExamProgressDataVO.setDescription("User Test Data");
		   userExamProgressDataVO.setDoe(getCurrentDate());
		   userExamProgressDataVO.setNoOfHaltLeftForTest(2);
		   userExamProgressDataVO.setTestName(testName);
		   userExamProgressDataVO.setTechName(techName);
		   userExamProgressDataVO.setUserId(getUserIdFromSession(session).getLoginId());
		   userExamProgressDataVO.setUserSessionId((String)session.getAttribute("userSessionId"));
		   //persisting data into the datebase
		   onlineTechTestService.pushProgressDataForUser(userExamProgressDataVO);
	}
	
	/**
	 *  Method will invoked when test is resumed
	 * @param testName
	 * @param session
	 * @return 
	 */
	@RequestMapping(value="leaveTest",method=RequestMethod.GET)
	public String leaveTest(@RequestParam(value="testName",required=false) String testName,@RequestParam(value="techName",required=false) String techName,HttpSession session){
		   //Apply check when test is not available
		  // AvailableTest availableTest=onlineTechTestService.fetchAllQuestionsByTestName(testName,techName,getUserIdFromSession(session).getLoginId(),(String)session.getAttribute("userSessionId"),true);
		   //StringBuilder loadedQuestionIds =prepareTestData(session,availableTest,testName);
		   //pushTestProgressData(session,loadedQuestionIds,testName,techName);
	  	   //return "techTestPage";
	  	   return "redirect:/action/userHomePage";
	}
	
	@RequestMapping(value="resumePreviousTechTest",method=RequestMethod.GET)
	public String resumePreviousTechTest(@RequestParam(value="testName",required=false) String testName,@RequestParam(value="techName",required=false) String techName,HttpSession session){
		   //Apply check when test is not available
			UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
			String userSessionId=onlineTechTestService.findUserTechSessionId(userId.getLoginId(), techName, testName);
			session.setAttribute("userSessionId", userSessionId);
			AvailableTest availableTest=onlineTechTestService.fetchAllQuestionsByTestName(testName,techName,getUserIdFromSession(session).getLoginId(),userSessionId,true);
		    StringBuilder loadedQuestionIds= prepareTestData(session,availableTest,testName);
		    pushTestProgressData(session,loadedQuestionIds,testName,techName);
	  	   //return "techTestPage";
	  	   return UserNavigationPage.USER_BASE+UserNavigationPage.WELCOME_TEST_PAGE;
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	private QuestionAndAnsTestDataVO fetchNextQuestionAnswer(HttpSession session){
	       Integer currentQuestionNo=(Integer)session.getAttribute("currentQuestionNo");
	       Map <Integer,String> questionsForTest=(Map <Integer,String>)session.getAttribute("questionsMapForTest");
	       currentQuestionNo=currentQuestionNo+1;
	       String userSessionId=(String)session.getAttribute("userSessionId");
	       String questionId=questionsForTest.get(currentQuestionNo);
	       QuestionAndAnsTestDataVO questionAndAnsTestDataVO=onlineTechTestService.fetchNextQuestionAnswer(questionId,getUserIdFromSession(session).getLoginId(),(String)session.getAttribute("testName"),(String)session.getAttribute("techName"),userSessionId);
	       questionAndAnsTestDataVO.setId(currentQuestionNo);
		   session.setAttribute("currentQuestionNo",currentQuestionNo);
	       session.setAttribute("currentQuestionId",questionId);
	       session.setAttribute("correctAnswerId",questionAndAnsTestDataVO.getCorrectOption());
           return questionAndAnsTestDataVO;
	}
	
	@RequestMapping(value="start-tech-test",method=RequestMethod.GET)
	public String startTechTest(Model model,HttpSession session){
		   //Create unique session id for a test.....
		   //String userSessionId="UT"+new Date();	
		   UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		   ConsultantsVO  consultantsVO=new ConsultantsVO();	     
		   if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)){
			   guestUserService.updateGuestUserTest(userId.getLoginId(),userId.getId(),ApplicationContant.IN_PROGRESS);
			   String userSessionId=(String)session.getAttribute("userSessionId");
			   guestUserService.updateGuestUserSessionId(userId.getLoginId(),userId.getId(),userSessionId);
		   }
	       model.addAttribute("questionAndAnsTestDataVO",fetchNextQuestionAnswer(session));
	       Map <Integer,String> questionsForTest=(Map <Integer,String>)session.getAttribute("questionsMapForTest");
	       model.addAttribute("totalQuestions",questionsForTest!=null?questionsForTest.size():0);
	       return UserNavigationPage.USER_BASE+NavigationPage.START_TECH_TEST_PAGE;
	}
	
	@RequestMapping(value="jumpToQuestion",method=RequestMethod.GET)
	public String jumpToQuestion(@RequestParam(value="selectedQuestionNo",required=false) int selectedQuestionNo,@RequestParam(value="selectedQuestionId",required=false) String selectedQuestionId,HttpSession session,Model  model){
		//Integer currentQuestionNo=(Integer)session.getAttribute("currentQuestionNo");
         Map <Integer,String> questionsForTest=(Map <Integer,String>)session.getAttribute("questionsMapForTest");
         /*if(selectedQuestionNo==questionsForTest.size()){
        	 model.addAttribute("nextButton","disabled");
         }*/
         //currentQuestionNo=selectedQuestionNo;
         //String questionId=questionsForTest.get(currentQuestionNo);
         String userSessionId=(String)session.getAttribute("userSessionId");
	     QuestionAndAnsTestDataVO questionAndAnsTestDataVO=onlineTechTestService.fetchNextQuestionAnswer(selectedQuestionId,getUserIdFromSession(session).getLoginId(),(String)session.getAttribute("testName"),(String)session.getAttribute("techName"),userSessionId);
	     questionAndAnsTestDataVO.setId(selectedQuestionNo);
		 session.setAttribute("currentQuestionNo",selectedQuestionNo);
	     session.setAttribute("currentQuestionId",selectedQuestionId);
	     session.setAttribute("correctAnswerId",questionAndAnsTestDataVO.getCorrectOption());
         model.addAttribute("questionAndAnsTestDataVO",questionAndAnsTestDataVO);
	     return NavigationPage.START_TECH_TEST_PAGE;
	}
	

	@RequestMapping(value="submitTechAnswer",method=RequestMethod.GET)
	public String submitTechAnswerForQuestion(@RequestParam(value="selectedAnswerId",required=false) String selectedAnswerId,HttpSession session,Model  model){
		if(selectedAnswerId!=null && selectedAnswerId.length()>0) {
			AttemptQuestionAnswerDTO attemptQuestionAnswerDTO=createAttemptQuestionAnswerDTO(selectedAnswerId,session);
			///Hitting database to persist above data
			//new code
			onlineTechTestService.submitTechAnswerForQuestion(attemptQuestionAnswerDTO,false);
		}
        
		Integer currentQuestionNo=(Integer)session.getAttribute("currentQuestionNo");
         Map <Integer,String> questionsForTest=(Map <Integer,String>)session.getAttribute("questionsMapForTest");
         if(currentQuestionNo+1==questionsForTest.size()){
        	 model.addAttribute("nextButton","disabled");
         }
         //this code seems to be not used
         //below code is commented on 13-June-2018
         //attemptQuestionAnswerDTO.setQuestionNo(currentQuestionNo+1);
         model.addAttribute("questionAndAnsTestDataVO",fetchNextQuestionAnswer(session));
	     return NavigationPage.START_TECH_TEST_PAGE;
	}
	
	/**
	 *  This method will be called when user will submit final test.
	 * @param selectedAnswerId
	 *  answerId selected by user for displayed question
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="submitTechTest",method=RequestMethod.POST)
	public String submitTechTest(@RequestParam(value="selectedAnswerId",required=false) String selectedAnswerId,HttpSession session,HttpServletRequest request,Model  model){
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method submitTechTest for sending email...");
		}
	     UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
	     ConsultantsVO  consultantsVO=new ConsultantsVO();	     
	     GuestUserForm guestUserDetail=new GuestUserForm();
	     if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)) {
	    	 consultantsVO.setName(userId.getName());
	    	 consultantsVO.setEmail(userId.getLoginId());
	    	  guestUserDetail = guestUserService.findGuestByEmailId(userId.getLoginId());
	    	  guestUserDetail.setUserid(userId.getLoginId());
	     }
	     else{
	    	 consultantsVO=consultantAssesmentService.findConsultantByUserid(userId.getLoginId());
	    	 guestUserDetail.setEmail(consultantsVO.getEmail());
	    	 guestUserDetail.setMobile(consultantsVO.getMobile());
	    	 guestUserDetail.setName(consultantsVO.getName());
	    	  guestUserDetail.setUserid(userId.getLoginId());
	     }
	     model.addAttribute("guestUserDetail", guestUserDetail);
		AttemptQuestionAnswerDTO attemptQuestionAnswerDTO=createAttemptQuestionAnswerDTO(selectedAnswerId,session);
		
		///Hitting database to persist above data
		String testLink=(String)session.getAttribute("testLink");
		attemptQuestionAnswerDTO.setTestLink(testLink);
		//setting test status @13-06-2018
		attemptQuestionAnswerDTO.setTestStatus(ApplicationContant.COMPLETE_EXAM_STATUS);
		 //updating the test status for GUEST USER ALSO... which we need to validate the test
        if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)) {
        	guestUserService.updateGuestTestStatusByEmailId(userId.getLoginId(), "COMPLETED");
        }
        String weightage=(String)session.getAttribute("weightage");
        if(weightage!=null && "yes".equalsIgnoreCase(weightage)){
        	 UserOnlineExamStatus userOnlineExamStatus=onlineTechTestService.submitTechAnswerForQuestion(attemptQuestionAnswerDTO,false);
        	 String testName=(String)session.getAttribute("testName");
    		 String techName=(String)session.getAttribute("techName");
    		 String userSessionId=(String)session.getAttribute("userSessionId");
    		 String loggedinUserid=getUserIdFromSession(session).getLoginId();
        	 List<UserExamDetailStatusVO> userExamDetailStatusVOs=onlineTechTestService.findTestTechDetailSummary(testName, techName, loggedinUserid, userSessionId);
        	 Map<String,Integer> categoryMap=new LinkedHashMap<String,Integer>();
        	 for(UserExamDetailStatusVO examDetailStatusVO:userExamDetailStatusVOs){
        		 if(categoryMap.containsKey(examDetailStatusVO.getDescription().trim())){
        			 int sum=categoryMap.get(examDetailStatusVO.getDescription().trim())+examDetailStatusVO.getCorrectAnswerCount();
        			 categoryMap.put(examDetailStatusVO.getDescription().trim(), sum);
        		 }else{
        			 categoryMap.put(examDetailStatusVO.getDescription().trim(), examDetailStatusVO.getCorrectAnswerCount());
        		 }
        	 }
        	 clearTestDataFromSession(session);
        	  userOnlineExamStatus=new UserOnlineExamStatus();
        	 //Do special calculation to show the report for weightage
        	  model.addAttribute("categoryMap", categoryMap);
        	 model.addAttribute("test_history_name", "guest-tech-test-details");
     		 return UserNavigationPage.PUBLIC_BASE + "guest-tech-test-history";
        	
        }else {
		UserOnlineExamStatus userOnlineExamStatus=onlineTechTestService.submitTechAnswerForQuestion(attemptQuestionAnswerDTO,true);
		model.addAttribute("userOnlineExamStatusForm",userOnlineExamStatus);
		clearTestDataFromSession(session);
        
        //sending the email
       // String toEmail=onlineTechTestService.findEmailIdByUserId(getUserIdFromSession(session).getLoginId());
        //javaEmailSender.sendMail("abc@gmail.com", toEmail, "your report is generated", "Thanks for participating in online java exam!!!");
        //Here write service to send the mail.
        //which call should be asynchronous
        //EmailMessageVO  emailMessageVO=new EmailMessageVO();
       // emailMessageVO.setSalutation(userId.getSalutation());
        if(userOnlineExamStatus.getExamStatus()!=null && userOnlineExamStatus.getExamStatus().equalsIgnoreCase(ApplicationContant.COMPLETE_EXAM_STATUS))  {	
        	String imageContextPath=DateUtils.getImageContextPath(request);
        	String textMessage="Congratulations! You have successfully completed the "+userOnlineExamStatus.getTestName()+" of "+userOnlineExamStatus.getTechName()+" technology..";
        	EmailMessageVO emailMessageVO=new EmailMessageVO();
        	emailMessageVO.setEmailMessage(textMessage);
        	emailMessageVO.setFrom((String)session.getServletContext().getAttribute("companyEmail"));
        	emailMessageVO.setImageContextPath(imageContextPath);
        	emailMessageVO.setName(consultantsVO.getName());
        	emailMessageVO.setSalutation(userId.getSalutation());
        	emailMessageVO.setToEmail(consultantsVO.getEmail());
        	emailMessageVO.setType(ApplicationContant.SUCCESS);
        	attendanceEmailReminderService.sendCompletedTestEmail(userOnlineExamStatus, emailMessageVO);
			List<QuestionAndAnsTestDataVO> questionList = new ArrayList<QuestionAndAnsTestDataVO>();
        	attendanceEmailReminderService.sendCompletedTestSummaryWithQuizAnsEmail(questionList,userOnlineExamStatus, emailMessageVO);
        	//Sending another email
        	
        }
        if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)) {
        	    model.addAttribute("test_history_name", "guest-tech-test-details");
        		return UserNavigationPage.USER_BASE + "guest-tech-test-history";
        }else{
        	//return UserNavigationPage.USER_BASE+NavigationPage.USER_EXAM_SUMMARY_PAGE;
        	model.addAttribute("test_history_name", "examDetail");
        	return UserNavigationPage.USER_BASE + "guest-tech-test-history";
        }	
       }//end of non weightage 
         
     }
	
	
	/**
	 *  This method will be called when user will submit final test.
	 * @param selectedAnswerId
	 *  answerId selected by user for displayed question
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="test-time-out",method=RequestMethod.POST)
	public String submitTechTest(HttpSession session,HttpServletRequest request,Model  model){
	/*	 String testName=(String)session.getAttribute("testName");
		 String techName=(String)session.getAttribute("techName");
		 AttemptQuestionAnswerDTO attemptQuestionAnswerDTO=new AttemptQuestionAnswerDTO();
         attemptQuestionAnswerDTO.setTestName(testName);
         attemptQuestionAnswerDTO.setTechName(techName);
         attemptQuestionAnswerDTO.setUserSessionId((String)session.getAttribute("userSessionId"));
         attemptQuestionAnswerDTO.setUserId(getUserIdFromSession(session).getLoginId());
         attemptQuestionAnswerDTO.setDateOfTest(getCurrentDate());
         attemptQuestionAnswerDTO.setDescription("Test is time out!");
       ///Hitting database to persist above data
		UserOnlineExamStatus userOnlineExamStatus=onlineTechTestService.genarateSummaryForTest(attemptQuestionAnswerDTO);
		clearTestDataFromSession(session);
        model.addAttribute("userOnlineExamStatus",userOnlineExamStatus); 
	     return UserNavigationPage.USER_BASE+NavigationPage.USER_EXAM_SUMMARY_PAGE;*/
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method testTimeOut when test is timeout..");
		}
	     UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
	     ConsultantsVO  consultantsVO=new ConsultantsVO();	     
	     GuestUserForm guestUserDetail=new GuestUserForm();
	     if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)){
	    	 consultantsVO.setName(userId.getName());
	    	 consultantsVO.setEmail(userId.getLoginId());
	    	  guestUserDetail = guestUserService.findGuestByEmailId(userId.getLoginId());
	    	  guestUserDetail.setUserid(userId.getLoginId());
	     }
	     else{
	    	 consultantsVO=consultantAssesmentService.findConsultantByUserid(userId.getLoginId());
	    	 guestUserDetail.setEmail(consultantsVO.getEmail());
	    	 guestUserDetail.setMobile(consultantsVO.getMobile());
	    	 guestUserDetail.setName(consultantsVO.getName());
	    	  guestUserDetail.setUserid(userId.getLoginId());
	     }
	     model.addAttribute("guestUserDetail", guestUserDetail);
		//AttemptQuestionAnswerDTO attemptQuestionAnswerDTO=createAttemptQuestionAnswerDTO(selectedAnswerId,session);
	     String testName=(String)session.getAttribute("testName");
		 String techName=(String)session.getAttribute("techName");
		 AttemptQuestionAnswerDTO attemptQuestionAnswerDTO=new AttemptQuestionAnswerDTO();
         attemptQuestionAnswerDTO.setTestName(testName);
         attemptQuestionAnswerDTO.setTechName(techName);
         attemptQuestionAnswerDTO.setUserSessionId((String)session.getAttribute("userSessionId"));
         attemptQuestionAnswerDTO.setUserId(getUserIdFromSession(session).getLoginId());
         attemptQuestionAnswerDTO.setDateOfTest(getCurrentDate());
         attemptQuestionAnswerDTO.setDescription("Test is time out!");
         attemptQuestionAnswerDTO.setRole(userId.getRole());
         attemptQuestionAnswerDTO.setTestStatus(ApplicationContant.IN_COMPLETE_EXAM_STATUS);
		///Hitting database to persist above data
		String testLink=(String)session.getAttribute("testLink");
		attemptQuestionAnswerDTO.setTestLink(testLink);
		UserOnlineExamStatus userOnlineExamStatus=onlineTechTestService.genarateSummaryForTest(attemptQuestionAnswerDTO);
        clearTestDataFromSession(session);
        model.addAttribute("userOnlineExamStatusForm",userOnlineExamStatus);
        
        //updating the test status for GUEST USER ALSO... which we need to validate the test
        if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)) {
        	guestUserService.updateGuestTestStatusByEmailId(userId.getLoginId(), ApplicationContant.IN_COMPLETE_EXAM_STATUS);
        }
        
        //sending the email
       // String toEmail=onlineTechTestService.findEmailIdByUserId(getUserIdFromSession(session).getLoginId());
        //javaEmailSender.sendMail("abc@gmail.com", toEmail, "your report is generated", "Thanks for participating in online java exam!!!");
        //Here write service to send the mail.
        //which call should be asynchronous
        //EmailMessageVO  emailMessageVO=new EmailMessageVO();
       // emailMessageVO.setSalutation(userId.getSalutation());
        if(userOnlineExamStatus.getExamStatus().equalsIgnoreCase(ApplicationContant.COMPLETE_EXAM_STATUS))  {	
		String imageContextPath=DateUtils.getImageContextPath(request);
		String textMessage="Congratulations! You have successfully completed the "+userOnlineExamStatus.getTestName()+" of "+userOnlineExamStatus.getTechName()+" technology..";
		EmailMessageVO emailMessageVO=new EmailMessageVO();
		emailMessageVO.setEmailMessage(textMessage);
		emailMessageVO.setFrom((String)session.getServletContext().getAttribute("companyEmail"));
		emailMessageVO.setImageContextPath(imageContextPath);
		emailMessageVO.setName(consultantsVO.getName());
		emailMessageVO.setSalutation(userId.getSalutation());
		emailMessageVO.setToEmail(consultantsVO.getEmail());
		emailMessageVO.setType(ApplicationContant.SUCCESS);
		attendanceEmailReminderService.sendCompletedTestEmail(userOnlineExamStatus, emailMessageVO);
        }
        if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)) {
        	    model.addAttribute("test_history_name", "guest-tech-test-details");
        		return UserNavigationPage.USER_BASE + "guest-tech-test-history";
        }else{
        	//return UserNavigationPage.USER_BASE+NavigationPage.USER_EXAM_SUMMARY_PAGE;
        	model.addAttribute("test_history_name", "examDetail");
        	return UserNavigationPage.USER_BASE + "guest-tech-test-history";
        }	
		
	}
	
	/**
	 * This method will show all available online test.
	 * @param session
	 * @param model
	 * @return
	 *  next page where user will nevaigate
	 */  
	@RequestMapping(value="user-available-test",method=RequestMethod.GET)
	public String allAssignedTestToUser(HttpSession session,Model  model){
		 List<AssignedTestUserForm> assignedTestUserList =onlineTechTestService.findAssignedTestByUserId(getUserIdFromSession(session).getLoginId());
		 model.addAttribute("assignedTestUserList", assignedTestUserList);
		 return UserNavigationPage.USER_BASE+"user-available-test";
	}
	
	
	
	
	/**
	 *  Method which will clear all the test data when user finally submits the
	 *  test.
	 * @param session
	 *   Object of HttpSession which is used to delete the data from the session
	 */
	private void clearTestDataFromSession(HttpSession session) {
		   if(logger.isDebugEnabled()){
			   logger.debug("Inside the method clearTestDataFromSession.");
		   }
		   session.removeAttribute("currentQuestionNo");
		   session.removeAttribute("questionsMapForTest");
		   session.removeAttribute("testName");
		   session.removeAttribute("techName");
		   session.removeAttribute("utestName");
		   session.removeAttribute("utechName");
		   session.removeAttribute("currentQuestionNo");
	       session.removeAttribute("currentQuestionId");
	       session.removeAttribute("correctAnswerId");
	       session.removeAttribute("testDuration");
	       session.removeAttribute("userSessionId");
	       session.removeAttribute("testLink");
	}

	/**
	 *  Method which will store status for question attempt by the user
	 * @param selectedAnswerId
	 * @param session
	 * @return
	 */
	private AttemptQuestionAnswerDTO createAttemptQuestionAnswerDTO(String selectedAnswerId,HttpSession session){
		 String questionId=(String)session.getAttribute("currentQuestionId");
		 String weightage=(String)session.getAttribute("weightage");
		 String correctAnswerId=(String)session.getAttribute("correctAnswerId");
		 String testName=(String)session.getAttribute("testName");
		 String techName=(String)session.getAttribute("techName");
		 AttemptQuestionAnswerDTO attemptQuestionAnswerDTO=new AttemptQuestionAnswerDTO();
		 attemptQuestionAnswerDTO.setWeightage(weightage);
         attemptQuestionAnswerDTO.setCorrectAnswerCount(selectedAnswerId.equals(correctAnswerId)?1:0);
         attemptQuestionAnswerDTO.setCorrectAnswerId(correctAnswerId);
         attemptQuestionAnswerDTO.setDateOfTest(getCurrentDate());
         attemptQuestionAnswerDTO.setQuestionId(questionId);
         attemptQuestionAnswerDTO.setSelectedAnswerId(selectedAnswerId);
         attemptQuestionAnswerDTO.setTestName(testName);
         attemptQuestionAnswerDTO.setTechName(techName);
         attemptQuestionAnswerDTO.setUserId(getUserIdFromSession(session).getLoginId());
         attemptQuestionAnswerDTO.setUserSessionId((String)session.getAttribute("userSessionId"));
         attemptQuestionAnswerDTO.setNoOfAttemts((Integer)session.getAttribute("numberOfAttForUser"));
         attemptQuestionAnswerDTO.setRole(getUserIdFromSession(session).getRole());
         return attemptQuestionAnswerDTO;
	}

	@Override
	public UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
	
	@ModelAttribute("testNames")
	public List<String> loadAvailableTests(){
	List<TestConfiguration> availableTestList =onlineTechTestService.findAllAvailableTest();
	List<String> testNames = new ArrayList<String>();
	for(TestConfiguration c: availableTestList){
		testNames.add(c.getTestName());
	}
	return testNames;
}

	
}
