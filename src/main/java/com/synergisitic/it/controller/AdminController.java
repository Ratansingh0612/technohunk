package com.synergisitic.it.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import com.synergisitic.it.model.User;
import com.synergisitic.it.navigation.AdminNavigationPage;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.service.Userervice;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.AvailableQuestionsBankForm;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserId;
import com.synergisitic.it.web.form.UserListInput;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.control.panel.controller.model.LoginSliderVO;
import com.techquiz.control.panel.service.LoginPageControlService;
import com.techquiz.info.jdbc.service.FacultyService;
import com.techquiz.info.jdbc.service.StudentJdbcService;
import com.techquiz.info.jdbc.service.UploadRecordExcelService;
import com.techquiz.programys.common.BatchAssignmentVO;
import com.techquiz.programys.common.controller.model.QuestionsBankForm;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.BatchVO;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Controller
public class AdminController extends AbstractUserSession{
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(AdminController.class);

	@Autowired
	@Qualifier("AdminServiceImpl")
	private AdminService adminService;
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;

	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	
	@Autowired
	@Qualifier("UserAdminCommonServiceImpl")
	private UserAdminCommonService userAdminCommonService;
	
	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	
	@Autowired
	@Qualifier("StudentJdbcServiceImpl")
	private StudentJdbcService studentJdbcService;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("UploadRecordExcelServiceImpl")
	private UploadRecordExcelService uploadRecordExcelService;
	
	@Autowired
	@Qualifier("FacultyServiceImpl")
	private FacultyService facultyService;
	
	@Autowired
	private Userervice userervice;
	
	@Autowired
	@Qualifier("LoginPageControlServiceImpl")
	private LoginPageControlService loginPageControlService;
	
	
	@RequestMapping(value="adminHome",method=RequestMethod.GET)
	public String navigateToAdminHome() {
		if(logger.isDebugEnabled()){
			logger.debug("navigating to admin home page.");
		}
		return NavigationPage.ADMIN_HOME;
	}
	
	@RequestMapping(value="successStatus",method=RequestMethod.GET)
	public String successStatus() {
		if(logger.isDebugEnabled()){
			logger.debug("navigating to admin home page.");
		}
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,Model model) {
		if(logger.isDebugEnabled()){
			logger.debug("navigating to admin home page.");
		}
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();
	
		List<LoginSliderVO> loginSliderVOs=loginPageControlService.findLoginPageContents();
		if(loginSliderVOs!=null && loginSliderVOs.size()>0)
		model.addAttribute("loginContentVO",loginSliderVOs.get(0));
		
		return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGIN_PAGE;
	}
	//http:localhost/OnlineTest/action/home.jsp
	//http:localhost/OnlineTest/home.jsp
	
	
	/**
	 * This method display the list of all the assigned questions for the selected 
	 * technology
	 * @return
	 */
	@RequestMapping(value="questionsList",method=RequestMethod.POST)
	public String questionsList(Model model,@RequestParam("tttechnology") String selectedTech) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method questionsList.");
		}
		List<QuestionsForm> assignedQuestion=adminService.findAllAssignedQuestionByTech(selectedTech);
		model.addAttribute("questionsList", assignedQuestion);
		model.addAttribute("techName",selectedTech);
		return NavigationPage.QUESTIONS_LIST;
	}
	
	
	/**
	 * This method display the list of all the assignedTestUser List
	 * @return
	 */
	@RequestMapping(value="completedTestList",method=RequestMethod.POST)
	public String completedTestList(Model model,@RequestParam("tttechnology") String selectedTech) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method completedTestList.");
		}
		UserListInput userListInput=new UserListInput();
		userListInput.setSelectedGroupName("Users");
		userListInput.setSelectedTech(selectedTech);
		model.addAttribute("userListInput", userListInput);
		List<AssignedTestUserForm> assignedTestUserList=adminService.findAllCompletedTestListByTech(selectedTech);
		model.addAttribute("assignedTestUserList", assignedTestUserList);
		List<String> userGroupList=studentJdbcService.findAllDifferentGroups();
		model.addAttribute("userGroupList",userGroupList);
		model.addAttribute("techName",selectedTech);
		model.addAttribute("userId",selectedTech);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.RESET_TEST_USERS;
	}

	/**
	 * This method display the list of all the assignedTestUser List
	 * @return
	 */
	@RequestMapping(value="map-consultant-batch",method=RequestMethod.GET)
	public String mapConsultantBatch(@RequestParam(value="selectedTrainerName",required=false) String selectedTrainerName,Model model) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method completedTestList.");
		}
		List<BatchAssignmentVO> batchAssignmentVOs=new ArrayList<BatchAssignmentVO>();
		if(selectedTrainerName==null || selectedTrainerName.length()==0)
			batchAssignmentVOs=facultyService.findAllGroupBatchNamesByTrainerId();
		else {
			User user=userService.findUserByLoginId(selectedTrainerName.split("-")[1]);
			batchAssignmentVOs=facultyService.findGroupBatchNamesByTrainerId(user.getId());
		}
			for(BatchAssignmentVO  batchAssignmentVO : batchAssignmentVOs) {
			User user=userService.findUserById(batchAssignmentVO.getBaid());
			if(user!=null)
			batchAssignmentVO.setTrainerName(user.getFirstName()+" "+user.getLastName());
		}
		model.addAttribute("batchAssignmentVOs", batchAssignmentVOs);
		List<String> batchNameList =  consultantAssesmentService.findActiveBatches();
		Collections.sort(batchNameList);
		model.addAttribute("batchNameList", batchNameList);
		List<UserForm> trainerList=userervice.findAllTrainer();
		List<String> trainerNameList=new ArrayList<String>();
		for(UserForm userForm : trainerList){
			trainerNameList.add(userForm.getFirstName()+" "+userForm.getLastName()+"-"+userForm.getLoginid());
		}
		model.addAttribute("trainerNameList", trainerNameList);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.MAP_CONSULTANT_BATCH;
	}
	
	/**
	 * This method display the list of all the assignedTestUser List
	 * @return
	 */
	@RequestMapping(value="map-consultant-batch",method=RequestMethod.POST)
	public String mapConsultantBatchPost(@RequestParam("selectedTrainerName") String selectedTrainerName,@RequestParam("batchName") String batchName,HttpSession session,Model model) {
		 if(logger.isDebugEnabled()) {
				logger.debug("Inside the method mapConsultantBatchPost.");
			}
		BatchAssignmentVO assignmentVO=new  BatchAssignmentVO();
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		assignmentVO.setAdminid(userId.getLoginId());
		assignmentVO.setBatch(batchName);
		assignmentVO.setDoc(new Date());
		assignmentVO.setTrainerName(selectedTrainerName.split("-")[0]);
		User user=userService.findUserByLoginId(selectedTrainerName.split("-")[1]);
		assignmentVO.setBaid(user.getId());
		BatchVO batchVO=userAdminCommonService.findBatchByBatchName(batchName);
		assignmentVO.setBatchid(batchVO.getBid()+"");
		assignmentVO.setComment(batchVO.getComment());
		String result=facultyService.associateBatchWithTrainer(assignmentVO);
		 if(logger.isDebugEnabled()) {
				logger.debug("..........result  = "+result);
		}
		 if("success".equalsIgnoreCase(result)) {
			 return "redirect:/action/map-consultant-batch?ApplicationMessage=Batch is associated with trainer successfully."+"&selectedTrainerName="+selectedTrainerName;
		 }else{
			 return "redirect:/action/map-consultant-batch?ApplicationMessage=Batch "+batchName+" is already associated with trainer "+assignmentVO.getTrainerName()+"&selectedTrainerName="+selectedTrainerName;
		 }
	}
	
	/**
	 * This method display the list of all the assignedTestUser List
	 * @return
	 */
	@RequestMapping(value="completedTestListByGroup",method=RequestMethod.POST)
	public String completedTestListByGroup(@ModelAttribute("userListInput") UserListInput userListInput,Model model) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method completedTestList.");
		}
		//userListInput.setSelectedTech(selectedTech);
		model.addAttribute("userListInput", userListInput);
		List<AssignedTestUserForm> assignedTestUserList=adminService.findAllCompletedTestListByTechAndGroup(userListInput.getSelectedTech(),userListInput.getSelectedGroupName());
		model.addAttribute("assignedTestUserList", assignedTestUserList);
		List<String> userGroupList=studentJdbcService.findAllDifferentGroups();
		model.addAttribute("userGroupList",userGroupList);
		model.addAttribute("techName",userListInput.getSelectedTech());
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.RESET_TEST_USERS;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="resetUserTest",method=RequestMethod.POST)
	public String resetUserTest(Model model,@RequestParam(value="hTestName",required=false) String testName,
			@RequestParam(value="huserId",required=false) String userId) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method resetUserTest.");
		}
		String result=adminService.resetUserTest(testName, userId);
		if(logger.isInfoEnabled()) {
			logger.info("result = "+result);
		}
		List<AssignedTestUserForm> assignedTestUserList=adminService.findAllCompletedTestListByTech(testName);
		model.addAttribute("assignedTestUserList", assignedTestUserList);
		model.addAttribute("techName",testName);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.TEST_RESET_SUCCESSFULLY_FOR_USER+" "+userId);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.RESET_TEST_USERS;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="admin-available-questions-bank-test",method=RequestMethod.GET)
	public String adminAvailableQuestionsBankTest(Model model,HttpSession session,HttpServletRequest request){
		if(logger.isDebugEnabled()) {
			logger.debug(".........Inside the method adminAvailableQuestionsBank.......");
		}
		session.setAttribute("techName", request.getParameter("techName"));
		session.setAttribute("testName", request.getParameter("testName"));
		session.setAttribute("validity", request.getParameter("validity"));
		session.setAttribute("testDuration", request.getParameter("testDuration"));
		session.setAttribute("random", request.getParameter("random"));
		//This gives you the login id of the logged user.......................
				UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
				String loginid=userId.getLoginId();
				String currentLoggedInRole=userId.getRole();
				List<QuestionsBankForm> availableQuestionsBank=new ArrayList<QuestionsBankForm>();
				if(ApplicationContant.ADMIN_ROLE.equalsIgnoreCase(currentLoggedInRole)){
					  availableQuestionsBank =uploadRecordExcelService.findAllQuestionsBank();
				}else{
					 availableQuestionsBank =uploadRecordExcelService.findQuestionsBankByUserid(loginid);
				}
				model.addAttribute("availableQuestionsBank", availableQuestionsBank);
				return AdminNavigationPage.ADMIN_BASE+CommonNavigationPage.AVAILABLE_QUESTIONS_BANK_TEST_PAGE;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="admin-available-questions-bank-tes",method=RequestMethod.GET)
	public String adminAvailableQuestionsBank(Model model){
		if(logger.isDebugEnabled()) {
			logger.debug(".........Inside the method adminAvailableQuestionsBank.......");
		}
	    List<AvailableQuestionsBankForm> availableQuestionsBank =adminService.findAllAvailableQuestionBank();
		model.addAttribute("availableQuestionsBank", availableQuestionsBank);
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.AVAILABLE_QUESTIONS_BANK_PAGE;
	}
	
	
	/**
	 * 
	 * @return
	 */
//	@RequestMapping(value="configureTest",method=RequestMethod.GET)
//	public String showConfigureTest(Model model,HttpSession session){
//		if(logger.isDebugEnabled()) {
//			logger.debug("Inside the method showConfigureTest.");
//		}
//		List<QuestionsForm> assignedQuestion=new ArrayList<QuestionsForm>();
//		List<QuestionsForm> configuredQuestionsListFromSession=(List<QuestionsForm>)session.getAttribute("configuredQuestionsListFromSession");
//		List<String> userGroupList=studentJdbcService.findAllDifferentGroups();
//		model.addAttribute("userGroupList",userGroupList);
//		if(configuredQuestionsListFromSession==null){
//			model.addAttribute("questionsList", assignedQuestion);
//		}else{
//			 model.addAttribute("questionsList", configuredQuestionsListFromSession);
//		}
//		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.CONFIGURE_TEST_PAGE;
//	}
//	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="addQToConfigureTest",method=RequestMethod.POST)
	public String addQuestionToConfigureTest(@RequestParam("selectedQuestionIds") String[] selectedQuestionIds,HttpSession sesion,Model model){
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method showConfigureTest.");
		}
		List<QuestionsForm> assignedQuestion=userAdminCommonService.findAllQuestionByQuestionIds(selectedQuestionIds);
		model.addAttribute("questionsList", assignedQuestion);
		//accessing previous questions from the session
		List<QuestionsForm> configuredQuestionsListFromSession=(List<QuestionsForm>)sesion.getAttribute("configuredQuestionsListFromSession");
		if(configuredQuestionsListFromSession==null){
			sesion.setAttribute("configuredQuestionsListFromSession",assignedQuestion);
			model.addAttribute("questionsList", assignedQuestion);
		}else{
			for(QuestionsForm questionsForm:assignedQuestion){
				configuredQuestionsListFromSession.add(questionsForm);
			}
			model.addAttribute("questionsList", configuredQuestionsListFromSession);
		}
		//model.addAttribute("techName","Core Java");
		return AdminNavigationPage.TRAINER_BASE+AdminNavigationPage.CONFIGURE_TEST_PAGES;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="update-configure-test",method=RequestMethod.POST)
	public String updateConfigureTest(Model model,@RequestParam(value="techName",required=false) String techName,
			@RequestParam(value="testName",required=false) String testName,@RequestParam(value="testid",required=false) int testid,
			@RequestParam(value="validity",required=false) int validity,
			@RequestParam(value="testDuration",required=false) int testDuration,
			@RequestParam(value="markQuestion",required=false) String markQuestion,
			@RequestParam(value="testInstruction",required=false) String testInstruction,
			@RequestParam(value="noOfAttempts",required=false) String noOfAttempts,
			@RequestParam(value="durationOnEachQ",required=false) String durationOnEachQ,
			@RequestParam(value="scbox[]",required=false) String scbox[],
			@RequestParam(value="random",required=false) boolean randQuestion,HttpServletRequest request,
			HttpSession session) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method questionsList.");
		}
		scbox=request.getParameterValues("scbox");
		TestConfiguration testConfiguration=new TestConfiguration();
		//Computing time on each questions
		//
		int timeOnEachQuestion=0;
		if(scbox!=null){
			timeOnEachQuestion=testDuration/scbox.length;
		}
		testConfiguration.setId(testid);
		testConfiguration.setValidity(validity);
		testConfiguration.setDurationOnEachQ(timeOnEachQuestion);
		testConfiguration.setTestInstruction(testInstruction);
		testConfiguration.setMarkQuestion(1);
		testConfiguration.setTestDuration(testDuration);
		testConfiguration.setTotalQuestions(scbox!=null?scbox.length:0);
		testConfiguration.setTestName(testName);
		testConfiguration.setTechName(techName==null?"Misc Tech":techName);
		testConfiguration.setQuestionIds(convertArrayIntoString(scbox));
		testConfiguration.setNoOfAttempts(1);
		testConfiguration.setDateOfEntry(getCurrentDate());
		testConfiguration.setLastModifyOn(getCurrentDate());
		testConfiguration.setLastModifyBy(getUserIdFromSession(session).getLoginId());
		//setting random option for both
		testConfiguration.setRandQuestion(randQuestion);
		testConfiguration.setRandOption(randQuestion);
		try {
				adminService.updateConfiguredTest(testConfiguration,true);
		}catch(Exception ex) {
			 ex.printStackTrace();
		}
		session.removeAttribute("configuredQuestionsListFromSession");
		//List<Questions> assignedQuestion=adminService.findAllAssignedQuestionByTech(selectedTech);
		//model.addAttribute("questionsList", assignedQuestion);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.TEST_IS_UPDATED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="configuretest",method=RequestMethod.POST)
	public String createNewTest(Model model,@RequestParam(value="techName",required=false) String techName,
			@RequestParam(value="operation",required=false) String operation,
			@RequestParam(value="testName",required=false) String testName,
			@RequestParam(value="validity",required=false) int validity,
			@RequestParam(value="testDuration",required=false) int testDuration,
			@RequestParam(value="markQuestion",required=false) String markQuestion,
			@RequestParam(value="testInstruction",required=false) String testInstruction,
			@RequestParam(value="noOfAttempts",required=false) String noOfAttempts,
			@RequestParam(value="durationOnEachQ",required=false) String durationOnEachQ,
			@RequestParam(value="scbox[]",required=false) String scbox[],
			@RequestParam(value="random",required=false) boolean randQuestion,HttpServletRequest request,
			HttpSession session) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method questionsList.");
		}
		scbox=request.getParameterValues("scbox");
		TestConfiguration testConfiguration=new TestConfiguration();
		//Computing time on each questions
		//
		int timeOnEachQuestion=0;
		if(scbox!=null){
			timeOnEachQuestion=testDuration/scbox.length;
		}
		testConfiguration.setValidity(validity);
		testConfiguration.setDurationOnEachQ(timeOnEachQuestion);
		testConfiguration.setTestInstruction(testInstruction);
		testConfiguration.setMarkQuestion(1);
		testConfiguration.setTestDuration(testDuration);
		testConfiguration.setTotalQuestions(scbox!=null?scbox.length:0);
		testConfiguration.setTestName(testName);
		testConfiguration.setTechName(techName==null?"Misc Tech":techName);
		testConfiguration.setQuestionIds(convertArrayIntoString(scbox));
		testConfiguration.setNoOfAttempts(1);
		testConfiguration.setDateOfEntry(getCurrentDate());
		testConfiguration.setLastModifyOn(getCurrentDate());
		testConfiguration.setLastModifyBy(getUserIdFromSession(session).getLoginId());
		//setting random option for both
		testConfiguration.setRandQuestion(randQuestion);
		testConfiguration.setRandOption(randQuestion);
		try {
				adminService.addNewTechTest(testConfiguration,operation==null?false:true);
		}catch(Exception ex){
			 ex.printStackTrace();
			if(logger.isErrorEnabled())
				logger.error("Error is saving the configured test "+ex.getMessage());
			List<QuestionsForm> assignedQuestion=new ArrayList<QuestionsForm>();
			List<QuestionsForm> configuredQuestionsListFromSession=(List<QuestionsForm>)session.getAttribute("configuredQuestionsListFromSession");
			List<String> userGroupList=studentJdbcService.findAllDifferentGroups();
			model.addAttribute("userGroupList",userGroupList);
			if(configuredQuestionsListFromSession==null){
				model.addAttribute("questionsList", assignedQuestion);
			}else{
				 model.addAttribute("questionsList", configuredQuestionsListFromSession);
			}
			model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.THIS_TEST_IS_ALREADY_CONFIGURED_BY_YOU);
			return UserNavigationPage.TRAINER_BASE+AdminNavigationPage.CONFIGURE_TEST_PAGE;
		}
		session.removeAttribute("configuredQuestionsListFromSession");
		//List<Questions> assignedQuestion=adminService.findAllAssignedQuestionByTech(selectedTech);
		//model.addAttribute("questionsList", assignedQuestion);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.TEST_IS_CONFIGURED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	
	/*//Action for delete button on All User page
	@RequestMapping(value="allOnlineAdminTest",method=RequestMethod.GET)
	public String showUserHistory(Model model) {
		List<TestConfiguration> availableTestList =onlineTechTestService.findAllAvailableTest();
		model.addAttribute("availableTestList",availableTestList);
		 return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.AVAILABLE_ALL_ONLINE_TEST_PAGE;
	}*/
	
	//Action for delete button on All User page
	@RequestMapping(value="usersTestHistory",method=RequestMethod.GET)
	public String showUserHistory(@RequestParam("loginid") String loginid,Model model) {
		List<UserOnlineExamStatusForm> userOnlineExamStatusList=userService.findAllUserOnlineExamStatus(loginid);
		model.addAttribute("userOnlineExamStatusList",userOnlineExamStatusList);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.USER_TEST_HISTORY;	
	}
	
	
	//Action for delete button on All User page
	@RequestMapping(value="online-available-tests",method=RequestMethod.GET)
	public String onlineAvailableTests(Model model) {
		List<TestConfiguration>  testConfigurationsList=adminService.findAllAvailableOnlineTests();
		model.addAttribute("testConfigurationsList",testConfigurationsList);
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.AVAILABLE_ALL_ONLINE_TEST_PAGE;	
	}
	
	//Action for delete button on All User page
		@RequestMapping(value="testsConfigureByTrainer",method=RequestMethod.GET)
		public String testsConfigureByTrainer(HttpSession session,Model model) {
			String loggedUserid=getUserIdFromSession(session).getLoginId();
			List<TestConfiguration>  testConfigurationsList=adminService.findConfiguredTestByTrainer(loggedUserid);
			model.addAttribute("testConfigurationsList",testConfigurationsList);
			return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.AVAILABLE_ALL_ONLINE_TEST_PAGE;	
		}
	
	
	/**
	 * 
	 * @param scbox
	 *   array of question ids.
	 * @return
	 *   list of question ids, comma separated
	 */
	private String convertArrayIntoString(String scbox[]){
		StringBuilder questionList=new StringBuilder();
		for(int index=0;index<scbox.length;index++)
		questionList.append(scbox[index]+",");
		return questionList.toString();
	}

	@Override
	public UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
	
	@ModelAttribute("testNames")
	public List<String> loadAvailableTests(){
		List<String> technologyList = new ArrayList<String>();
		List<com.synergisitic.it.web.form.Technology> availableTechList =technolgyCategoryService.findAllTechnolgy();
		for(com.synergisitic.it.web.form.Technology tech: availableTechList){
			technologyList.add(tech.getTname());
		}
		return technologyList;
  }
	@RequestMapping(value = "/findUsersByName", method = RequestMethod.GET)
	public String findUsersByName(@RequestParam(value="userId")String userName,@RequestParam(value = "hTestName")String testName,Model model) {
		List<AssignedTestUserForm> usersList=adminService.findUsersByName(userName,testName);
		model.addAttribute("assignedTestUserList", usersList);
		model.addAttribute("userId",userName);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.RESET_TEST_USERS;
	}
	
	/**
	 * This method display the list of all the assignedTestUser List
	 * @return
	 */
	@RequestMapping(value="searchApplicationUsers",method=RequestMethod.POST)
	public String searchApplicationUsers(Model model,@RequestParam("tttechnology") String selectedTech) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method completedTestList.");
		}
		UserListInput userListInput=new UserListInput();
		userListInput.setSelectedGroupName("Users");
		userListInput.setSelectedTech(selectedTech);
		model.addAttribute("userListInput", userListInput);
		List<AssignedTestUserForm> assignedTestUserList=adminService.findAllCompletedTestListByTech(selectedTech);
		model.addAttribute("assignedTestUserList", assignedTestUserList);
		List<String> userGroupList=studentJdbcService.findAllDifferentGroups();
		model.addAttribute("userGroupList",userGroupList);
		model.addAttribute("techName",selectedTech);
		model.addAttribute("userId",selectedTech);
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.RESET_TEST_USERS;
	}
	
	/*@RequestMapping(value="configure-test",method=RequestMethod.GET)
	public String showConfigureTest(Model model,HttpSession session){
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method showConfigureTest.");
		}
		List<QuestionsForm> assignedQuestion=new ArrayList<QuestionsForm>();
		List<QuestionsForm> configuredQuestionsListFromSession=(List<QuestionsForm>)session.getAttribute("configuredQuestionsListFromSession");
		List<String> userGroupList=studentJdbcService.findAllDifferentGroups();
		model.addAttribute("userGroupList",userGroupList);
		if(configuredQuestionsListFromSession==null){
			model.addAttribute("questionsList", assignedQuestion);
		}else{
			 model.addAttribute("questionsList", configuredQuestionsListFromSession);
		}
		return   AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.CONFIGURE_TEST_PAGES;
	}*/
	
	@ModelAttribute("techList")
	public List<String> loadTechList() {
		//Data referencing for web framework combo
		List<String> techList = new ArrayList<>();
		List<com.synergisitic.it.web.form.Technology> availableTechList =technolgyCategoryService.findAllTechnolgy();
		for(com.synergisitic.it.web.form.Technology tech: availableTechList){
			techList.add(tech.getTname());
		}
		return techList;
	}
}
