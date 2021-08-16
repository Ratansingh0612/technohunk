package com.techquiz.trainer.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.navigation.AdminNavigationPage;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.GuestUserService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.QuestionBankService;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.TopicsService;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.service.impl.ConsultantServiceImpl;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.AssignTestUserForm;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.GuestUserForm;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserId;
import com.synergisitic.it.web.form.UserListInput;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.info.jdbc.service.FacultyService;
import com.techquiz.info.jdbc.service.IUserRoleService;
import com.techquiz.info.jdbc.service.StudentJdbcService;
import com.techquiz.programys.common.controller.model.QuestionsBankForm;
import com.techquiz.programys.common.service.IContentsService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.programys.common.vo.TopicVO;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;
import com.techquiz.trainer.web.controller.vo.CourseContentsDetailVO;

/**
 * 
 * @author Nagendra
 *
 */
@Controller
@Scope("singleton")
public class TrainerAdminConfigurationController {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(TrainerAdminConfigurationController.class);
	
	
	@Autowired
	@Qualifier("QuestionBankServiceImpl")
	private QuestionBankService questionBankService;
	
	
	@Autowired
	@Qualifier("StudentJdbcServiceImpl")
	private StudentJdbcService studentJdbcService;
	
	
	@Autowired
	@Qualifier("FacultyServiceImpl")
	private FacultyService facultyService;
	
	

	@Autowired
	@Qualifier("ConsultantServiceImpl")
	private ConsultantServiceImpl consultantService;
	
	
	
	
	/**
	 * 
	 * @return
	 */
	
	@Autowired
	@Qualifier("UserRoleService")
	private IUserRoleService userRoleService;
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("AdminServiceImpl")
	private AdminService adminService;
	
	@Autowired
	@Qualifier("GuestUserServiceImpl")
	private GuestUserService guestUserService;
	
	@Autowired
	@Qualifier("ContentsService")
	private IContentsService 	contentsService;
	
	@Autowired
	@Qualifier("TopicsServiceImpl")
	private TopicsService topicsService;
	
	@Autowired
	@Qualifier("UserAdminCommonServiceImpl")
	private UserAdminCommonService userAdminCommonService;
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;


	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;

	@RequestMapping(value = "test-test", method = RequestMethod.GET)
	public String testetst(Model model,HttpSession session) {
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.SORRY_YOU_HAVE_NOT_CONFIGURED_ANY_TEST_SO_FAR);
		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	@RequestMapping(value = "test-trainer", method = RequestMethod.GET)
	public String testTrainer(Model model,HttpSession session) {
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.SORRY_YOU_HAVE_NOT_CONFIGURED_ANY_TEST_SO_FAR);
		return UserNavigationPage.TRAINER_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	@RequestMapping(value = "delete-test", method = RequestMethod.GET)
	public String deleteTest(Model model,HttpSession session) {
		String techName = "";
		String testName = "";
		//List<TestConfiguration> configurations=userAdminCommonService.findAvailableTestsByTech(techName);
		model.addAttribute("tname", testName);
		model.addAttribute("selectedGroupName", techName);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.DELETE_TEST_PAGE; 
	}
	
	
	@RequestMapping(value="configure-test",method=RequestMethod.GET)
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
		return   UserNavigationPage.TRAINER_BASE+UserNavigationPage.CONFIGURE_TEST_PAGE;
	}
	
	
	@RequestMapping(value="edit-configure-test",method=RequestMethod.GET)
	public String showEditConfigureTest(Model model,String techName,String testName,HttpSession session){
		TestConfiguration testConfiguration=onlineTechTestService.findAvailableTestTechTestName(techName,testName);
		String questionIds=testConfiguration.getQuestionIds();
		String[] selectedQuestionIds=questionIds.split(",");
		List<QuestionsForm> questionsList=userAdminCommonService.findAllQuestionByQuestionIds(selectedQuestionIds);
		model.addAttribute("questionsList", questionsList);
		model.addAttribute("testConfiguration", testConfiguration);
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method showConfigureTest.");
		}
		List<QuestionsForm> configuredQuestionsListFromSession=(List<QuestionsForm>)session.getAttribute("configuredQuestionsListFromSession");
		List<String> userGroupList=studentJdbcService.findAllDifferentGroups();
		model.addAttribute("userGroupList",userGroupList);
		if(configuredQuestionsListFromSession==null){
			model.addAttribute("questionsList", questionsList);
		}else{
			 model.addAttribute("questionsList", configuredQuestionsListFromSession);
		}
		return   UserNavigationPage.TRAINER_BASE+UserNavigationPage.EDIT_CONFIGURE_TEST_PAGE;
	}
	

	
	@RequestMapping(value="availabl   e-tests",method=RequestMethod.GET)
	public String availableTests(Model model,HttpSession session){
		List<TestConfiguration> availableTechList=new ArrayList<TestConfiguration>();
		//This gives you the login id of the logged user.......................
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String loginid=userId.getLoginId();
		String currentLoggedInRole=userId.getRole();
		//Data referencing for web framework combo
		List<String> techList = new ArrayList<>();
		if(ApplicationContant.ADMIN_ROLE.equalsIgnoreCase(currentLoggedInRole)){
			List<com.synergisitic.it.web.form.Technology> availableTechnologyList =technolgyCategoryService.findAllTechnolgy();
			for(com.synergisitic.it.web.form.Technology tech: availableTechnologyList){
				techList.add(tech.getTname());
			}
		}else{
			techList =onlineTechTestService.findTechListByUserid(loginid);
		}
		
		if(ApplicationContant.ADMIN_ROLE.equalsIgnoreCase(currentLoggedInRole)){
			availableTechList=onlineTechTestService.findAllAvailableTest();
		}else{
			availableTechList=onlineTechTestService.findAllAvailableTestByUserId(loginid);
		}
		model.addAttribute("techList",techList);
		model.addAttribute("availableTechList",availableTechList);
		return   UserNavigationPage.TRAINER_BASE+UserNavigationPage.AVAILABLE_TESTS_PAGE;
	}
	
	@RequestMapping(value="add-qconfigure-test",method=RequestMethod.POST)
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
				if(configuredQuestionsListFromSession.contains(questionsForm)){
					continue;
				}
				configuredQuestionsListFromSession.add(questionsForm);
			}
			model.addAttribute("questionsList", configuredQuestionsListFromSession);
		}
		//model.addAttribute("techName","Core Java");
		return UserNavigationPage.TRAINER_BASE+AdminNavigationPage.CONFIGURE_TEST_PAGE;
	}
	
	@RequestMapping(value="delete-question-basket",method=RequestMethod.POST)
	public String addQuestionToConfigureTest(HttpSession sesion,Model model){
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method delete-question-basket.");
		}
		sesion.removeAttribute("configuredQuestionsListFromSession");
		List<QuestionsForm> assignedQuestion=new ArrayList<QuestionsForm>();
		model.addAttribute("questionsList", assignedQuestion);
		return UserNavigationPage.TRAINER_BASE+AdminNavigationPage.CONFIGURE_TEST_PAGE;
	}
	
	
	

	@RequestMapping(value = "search-consultant-test-history", method = RequestMethod.GET)
	public String searchConsultantTestHistory(HttpSession session, Model model) {
		// Fetch data for all users.
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.SEARCH_CONSULTANT_TEST_HISTORY_PAGE;
	}
	
	@RequestMapping(value = "search-consultant", method = RequestMethod.GET)
	public String searchConsultant(HttpSession session, Model model) {
		// Fetch data for all users.
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.SEARCH_CONSULTANT_PAGE;
	}
	
	
	
	@RequestMapping(value = "search-assign-test-to-user", method = RequestMethod.GET)
	public String serachAssignTestToUser(HttpSession session, Model model) {
		// Fetch data for all users.
		String userRole = getUserRoleFromSession(session);
		List<String> userGroupList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			userGroupList = userRoleService.findActiveBatchForConsultant();
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			userGroupList = studentJdbcService.findAllDifferentGroups();
		}
		List<TestConfiguration> availableTestList = onlineTechTestService.findAllAvailableTest();

		List<AssignTestUserForm> userList = new ArrayList<AssignTestUserForm>();
		// model is type of hashMap
		model.addAttribute("userList", userList);
		model.addAttribute("userGroupList", userGroupList);

		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList){
			if(!testNames.contains(c.getTestName())){
				testNames.add(c.getTestName());
			}
			if(!techNames.contains(c.getTechName())){
				techNames.add(c.getTechName());
			}
		}	
		model.addAttribute("techNames", techNames);
		model.addAttribute("testNames", testNames);
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.SERACH_ASSIGN_TEST_TO_USER_PAGE;
	}
	
	@RequestMapping(value = "findAllConsultantsWithSearchString", method = RequestMethod.GET)
	public @ResponseBody List<UserForm> findAllConsultantsWithSearchString(@RequestParam("searchKey") String searchKey) {
		//System.out.println("hey I am in the controller...");
		List<UserForm> users = consultantAssesmentService.findAllConsultantsWithSearchString(searchKey);
		System.out.println("Controller User list: "+users);
		return users;
	}
	
	@RequestMapping(value = "search-assign-test-to-user", method = RequestMethod.POST)
	public String serachAssignTestToUserPost(Model model, HttpServletRequest request) {
		String testName = request.getParameter("testName");
		String techName = request.getParameter("techName");
		String[] userids = request.getParameterValues("userCb");
		//String groupName = request.getParameter("selectedGroupName");
		
		List<AssignedTestUserForm> assignedTestUserFormList = new ArrayList<AssignedTestUserForm>();
		for (String userid : userids) {
			AssignedTestUserForm assigned = new AssignedTestUserForm();
			assigned.setTechName(techName);
			assigned.setTestName(testName);
			//assigned.setGroupName(groupName);
			assigned.setResetDate(new Date());
			assigned.setUserId(userid);
			assigned.setModifyBy(getUserData(request).getLoginId());
			assigned.setAssignDate(new Date());
			assigned.setTestStatus(ApplicationContant.NOT_STARTED);
			assigned.setAttamptLimit(ApplicationContant.DEFAULT_ATTEMPT_LIMIT);
			assignedTestUserFormList.add(assigned);
		}
		onlineTechTestService.assignedTestToUsers(assignedTestUserFormList);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.TEST_IS_ASSIGNED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	@RequestMapping(value = "assign-test-to-user", method = RequestMethod.GET)
	public String assignExam(HttpSession session, Model model) {
		// Fetch data for all users.
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> userGroupList = new ArrayList<String>();
		List<TestConfiguration> availableTestList=new ArrayList<TestConfiguration>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			 availableTestList = onlineTechTestService.findAllAvailableTestByUserId(userid.getLoginId());
			userGroupList = facultyService.findGroupNamesByTrainerId(userid.getId());
			if(userGroupList.size()==0){
				userGroupList = consultantAssesmentService.findActiveBatches();
				 availableTestList = onlineTechTestService.findAllAvailableTest();
			}
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			 availableTestList = onlineTechTestService.findAllAvailableTest();
			 userGroupList =  consultantAssesmentService.findActiveBatches();
		}
		if(availableTestList==null || availableTestList.size()==0){
			model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
					ApplicationMessageConstant.SORRY_YOU_HAVE_NOT_CONFIGURED_ANY_TEST_SO_FAR);
			return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
		}

		List<AssignTestUserForm> userList = new ArrayList<AssignTestUserForm>();
		// model is type of hashMap
		model.addAttribute("userList", userList);
		model.addAttribute("userGroupList", userGroupList);

		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList){
			if(!testNames.contains(c.getTestName())){
				testNames.add(c.getTestName());
			}
			if(!techNames.contains(c.getTechName())){
				techNames.add(c.getTechName());
			}
		}	
		model.addAttribute("techNames", techNames);
		model.addAttribute("testNames", testNames);
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.ASSIGN_TEST_TO_USER_PAGE;
	}
	
	@RequestMapping(value = "assign-test-to-selected-users", method = RequestMethod.GET)
	public String assignTestToSelected(HttpSession session, Model model) {
		// Fetch data for all users.
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> userGroupList = new ArrayList<String>();
		List<TestConfiguration> availableTestList=new ArrayList<TestConfiguration>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			 availableTestList = onlineTechTestService.findAllAvailableTestByUserId(userid.getLoginId());
			userGroupList = facultyService.findGroupNamesByTrainerId(userid.getId());
			if(userGroupList.size()==0){
				userGroupList = consultantAssesmentService.findActiveBatches();
				 availableTestList = onlineTechTestService.findAllAvailableTest();
			}
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			 availableTestList = onlineTechTestService.findAllAvailableTest();
			 userGroupList =  consultantAssesmentService.findActiveBatches();
		}
		if(availableTestList==null || availableTestList.size()==0){
			model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
					ApplicationMessageConstant.SORRY_YOU_HAVE_NOT_CONFIGURED_ANY_TEST_SO_FAR);
			return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
		}

		List<AssignTestUserForm> userList = new ArrayList<AssignTestUserForm>();
		// model is type of hashMap
		model.addAttribute("userList", userList);
		model.addAttribute("userGroupList", userGroupList);

		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList){
			if(!testNames.contains(c.getTestName())){
				testNames.add(c.getTestName());
			}
			if(!techNames.contains(c.getTechName())){
				techNames.add(c.getTechName());
			}
		}	
		model.addAttribute("techNames", techNames);
		model.addAttribute("testNames", testNames);
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.ASSIGN_TEST_TO_SELECTED_USERS_PAGE;
	}
	
	
	@RequestMapping(value = "assign-test-to-user", method = RequestMethod.POST)
	public String assignExam(Model model, HttpServletRequest request) {
		String testName = request.getParameter("testName");
		String[] userids = request.getParameterValues("userCb");
		String groupName = request.getParameter("selectedGroupName");
		List<AssignedTestUserForm> assignedTestUserFormList = new ArrayList<AssignedTestUserForm>();
		for (String userid : userids) {
			AssignedTestUserForm assigned = new AssignedTestUserForm();
			assigned.setTechName(testName);
			assigned.setGroupName(groupName);
			assigned.setResetDate(new Date());
			assigned.setUserId(userid);
			assigned.setModifyBy(getUserData(request).getLoginId());
			assigned.setAssignDate(new Date());
			assigned.setTestStatus(ApplicationContant.NOT_STARTED);
			assigned.setAttamptLimit(ApplicationContant.DEFAULT_ATTEMPT_LIMIT);
			assignedTestUserFormList.add(assigned);
		}
		onlineTechTestService.assignedTestToUsers(assignedTestUserFormList);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.TEST_IS_ASSIGNED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	
	
	@RequestMapping(value = "manage-registered-user", method = RequestMethod.GET)
	public String manageRegisteredUser(Model model,HttpSession session) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.MANAGE_REGISTERED_USER__PAGE;
	}
	
	
	@RequestMapping(value = "assigned-group-tests", method = RequestMethod.GET)
	public String assignedGroupTests(Model model,HttpSession session) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			//batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
			batchList =  consultantAssesmentService.findActiveBatches();
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.ASSIGNED_GROUP_TESTS_PAGE;
	}
	
	
	
	@RequestMapping(value = "lock-consultant-account", method = RequestMethod.GET)
	public String lockConsultantAccount(Model model,HttpSession session) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			//batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
			batchList =  consultantAssesmentService.findActiveBatches();
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		//UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		//List<TestConfiguration> testConfigurationsList = adminService.findConfiguredTestByTrainer(userId.getLoginId());
		//model.addAttribute("testConfigurationsList", testConfigurationsList);
		/*List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		String ptechName="";
		String ptestName="";
		for (TestConfiguration c : testConfigurationsList){
			if(ptechName.length()==0){
				ptechName=c.getTechName();
				ptestName=c.getTestName();
			}
			if(ptechName.equals(c.getTechName())){
				testNames.add(c.getTestName());
			}
			techNames.add(c.getTechName());
		}	*/
		
		//List<UserForm> users = consultantAssesmentService.findConsultantByBatch(batchName);
		// model is type of hashMap
	//	model.addAttribute("users", users);
		
		//model.addAttribute("testNames", testNames);
		//model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.LOCK_CONSULTANT_ACCOUNT__PAGE;
	}
	
	
	@RequestMapping(value = "delete-consultant-test", method = RequestMethod.GET)
	public String deleteConsultantTest(Model model,HttpSession session) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);

		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<TestConfiguration> testConfigurationsList =new ArrayList<TestConfiguration>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			testConfigurationsList = adminService.findConfiguredTestByTrainer(userId.getLoginId());
		}else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			testConfigurationsList = adminService.findAllAvailableOnlineTests();
		}
		model.addAttribute("testConfigurationsList", testConfigurationsList);
		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		String ptechName="";
		String ptestName="";
		for (TestConfiguration c : testConfigurationsList){
			if(ptechName.length()==0){
				ptechName=c.getTechName();
				ptestName=c.getTestName();
			}
			if(ptechName.equals(c.getTechName())){
				testNames.add(c.getTestName());
			}
			techNames.add(c.getTechName());
		}	
		
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		// model is type of hashMap
		model.addAttribute("users", users);
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.DELETE_CONSULTANT_TEST__PAGE;
	}
	
	
	
	@RequestMapping(value = "guest-test-search-history", method = RequestMethod.GET)
	 public String guestSearchTestHistory(String searchString,Model model,HttpSession session) {
		// List<UserForm> searchGuestUserList=consultantAssesmentService.findGuestTestHistoryWithNameEmail(searchString,true);
		 return UserNavigationPage.TRAINER_BASE + UserNavigationPage.GUEST_SEARCH_HISTORY_DETAIL_PAGE;
	}
	
	
	/**
	 * 
	 * @param searchString
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "find-guest-reset-test-search-history", method = RequestMethod.GET)
	@ResponseBody public List<UserForm> findGuestResetSearchTestHistory(String searchString,Model model,HttpSession session) {
		 List<UserForm> searchGuestUserList=consultantAssesmentService.findGuestResetTestHistoryWithNameEmail(searchString,true);
		 if(searchGuestUserList!=null){
			 Collections.sort(searchGuestUserList);
		 }
		 return searchGuestUserList;
	}
	
	/**
	 * 
	 * @param searchString
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "search-guest-email-name", method = RequestMethod.GET)
	@ResponseBody public List<GuestUserForm> searchGuestWithEmailName(String searchString,Model model,HttpSession session) {
		List<GuestUserForm>  guestUsersList= guestUserService.findGuestUserWithSearchString(searchString);
		List<GuestUserForm>  guesFilteredList=new ArrayList<GuestUserForm>();
		for(GuestUserForm guestUserForm:guestUsersList){
			    if(!guesFilteredList.contains(guestUserForm)){
			    	guesFilteredList.add(guestUserForm);
			    }
		}
		/* if(guestUsersList!=null){
			 Collections.sort(guestUsersList);
		 }*/
		 return guesFilteredList;
	}


	
	/**
	 * 
	 * @param searchString
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "find-guest-test-search-history", method = RequestMethod.GET)
	@ResponseBody public List<UserForm> findGuestSearchTestHistory(String searchString,Model model,HttpSession session) {
		 List<UserForm> searchGuestUserList=consultantAssesmentService.findGuestTestHistoryWithNameEmail(searchString,true);
		 if(searchGuestUserList!=null){
			 Collections.sort(searchGuestUserList);
		 }
		 return searchGuestUserList;
	}
	
	
	
	/**
	 * 
	 * @param userid email id for guest
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "guest-performance-report", method = RequestMethod.POST)
	 public String guestPerformanceReport(String userid,Model model,HttpSession session) {
		 List<UserForm> searchGuestUserList=consultantAssesmentService.findGuestTestHistoryByEmail(userid,true);
		 if(searchGuestUserList!=null){
			 Collections.sort(searchGuestUserList);
		 }
		 
		 Map<String,List<UserForm>> testResultReportMap=new LinkedHashMap<String,List<UserForm>>();
		 Set<String> testNames=new LinkedHashSet<String>();
		 
		 for(UserForm userForm:searchGuestUserList) {
			 			 testNames.add(userForm.getTestName());
			 			if(testResultReportMap.containsKey(userForm.getTestName())){
			 				List<UserForm> sguestList=testResultReportMap.get(userForm.getTestName());
			 				sguestList.add(userForm);
			 				testResultReportMap.put(userForm.getTestName(), sguestList);
			 			}else{
			 				List<UserForm> tguestList=new ArrayList<UserForm>();
			 				tguestList.add(userForm);
			 				testResultReportMap.put(userForm.getTestName(), tguestList);
			 			}
		 }
		 GuestUserForm guestUserForm=guestUserService.findGuestByEmailId(userid);
		 if(searchGuestUserList!=null && searchGuestUserList.size()>0){
			 model.addAttribute("guestUser",guestUserForm);
		 }
		 model.addAttribute("testNames", testNames);
		 model.addAttribute("testResultReportMap", testResultReportMap);
		 model.addAttribute("searchGuestUserList", searchGuestUserList);
		 return UserNavigationPage.TRAINER_BASE + UserNavigationPage.SGUEST_TEST_PERFORMANCE_REPORT;
	}
	
	
	
	@RequestMapping(value = "guest-test-status", method = RequestMethod.GET)
	public String guestTestStatus(Model model,HttpSession session) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);

		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<TestConfiguration> testConfigurationsList =new ArrayList<TestConfiguration>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			testConfigurationsList = adminService.findConfiguredTestByTrainer(userId.getLoginId());
		}else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			testConfigurationsList = adminService.findAllAvailableOnlineTests();
		}
		model.addAttribute("testConfigurationsList", testConfigurationsList);
		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		String ptechName="";
		String ptestName="";
		for (TestConfiguration c : testConfigurationsList){
			if(ptechName.length()==0){
				ptechName=c.getTechName();
				ptestName=c.getTestName();
			}
			if(ptechName.equals(c.getTechName())){
				testNames.add(c.getTestName());
			}
			if(!techNames.contains(c.getTechName()))
			techNames.add(c.getTechName());
		}	
		
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		if(users!=null) {
			Collections.sort(users);
		}
		// model is type of hashMap
		model.addAttribute("users", users);
		
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.GUEST_TEST_STATUS_PAGE;
	}
	
	
	@RequestMapping(value = "consultant-test-status", method = RequestMethod.GET)
	public String consultantTestStatus(Model model,HttpSession session) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
			if(batchList.size()==0){
				batchList =  consultantAssesmentService.findActiveBatches();
			}
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);

		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<TestConfiguration> testConfigurationsList=new ArrayList<TestConfiguration>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			testConfigurationsList = adminService.findConfiguredTestByTrainer(userId.getLoginId());
		}else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			testConfigurationsList = onlineTechTestService.findAllAvailableTest();
		}
		model.addAttribute("testConfigurationsList", testConfigurationsList);
		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		String ptechName="";
		String ptestName="";
		for (TestConfiguration c : testConfigurationsList){
			if(ptechName.length()==0){
				ptechName=c.getTechName();
				ptestName=c.getTestName();
			}
			if(ptechName.equals(c.getTechName())){
				testNames.add(c.getTestName());
			}
			if(!techNames.contains(c.getTechName()))
			techNames.add(c.getTechName());
		}	
		
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		if(users!=null) {
			Collections.sort(users);
		}
		// model is type of hashMap
		model.addAttribute("users", users);
		
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.CONSULTANT_TEST_STATUS_PAGE;
	}
	
	@RequestMapping(value = "consultant-test-status-details", method = RequestMethod.GET)
	public String consultantTestStatusDetails(Model model,HttpSession session) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.CONSULTANT_TEST_STATUS_DETAILS_PAGE;
	}
	
	
	@RequestMapping(value = "search-consultant-test-status-details", method = RequestMethod.POST)
	public String searchConsultantTestStatusDetails(@RequestParam(value="searchConsultantId",required=false) String consultantId,Model model,HttpSession session) {
		
		List<String> techNameList=new ArrayList<String>();
		List<UserOnlineExamStatusForm> userOnlineExamStatusList = userService.findAllUserOnlineExamStatus(consultantId);
		ConsultantsVO consultantsVO=consultantAssesmentService.findConsultantByUserid(consultantId);
		model.addAttribute("consultantsVO", consultantsVO);
		model.addAttribute("userOnlineExamStatusList", userOnlineExamStatusList);
		
		for(UserOnlineExamStatusForm userOnlineExamStatusForm:userOnlineExamStatusList){
			if(!techNameList.contains(userOnlineExamStatusForm.getTechName())){
				techNameList.add(userOnlineExamStatusForm.getTechName());
			}
		}
		// model is type of hashMap
		model.addAttribute("techNameList", techNameList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.SEARCH_CONSULTANT_TEST_STATUS_DETAILS_PAGE;
	}
	
	@RequestMapping(value = "consultant-group-test-reset", method = RequestMethod.POST)
	public String consultantGroupTestResetPost(Model model,@RequestParam(value="batchName",required=false) String batchName,
				@RequestParam(value="testName",required=false) String testName,@RequestParam(value="techName",required=false) String techName,@RequestParam(value="groupName",required=false) String groupName,@RequestParam(value="withHistory",required=false) String withHistory) {
			if(logger.isDebugEnabled()) {
				logger.debug("Inside the method resetConsultantTest.");
			}
			String result="";
			if(withHistory!=null && withHistory.equals("yes")) {
					 result=adminService.resetConsultantGroupTestByTech(techName,testName, groupName,true);
						if(logger.isInfoEnabled()) {
								logger.info("result = "+result);
						}
				}else{
						 result=adminService.resetConsultantGroupTestByTech(techName,testName, groupName,false);
				}
			model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
					ApplicationMessageConstant.TEST_RESET_SUCCESSFULLY_FOR_USER_GROUP);
			return UserNavigationPage.ADMIN_BASE
					+ UserNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	@RequestMapping(value = "consultant-group-test-reset", method = RequestMethod.GET)
	public String consultantGroupTestReset(HttpSession session,Model model) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);	
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<TestConfiguration> testConfigurationsList=new ArrayList<TestConfiguration>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			 testConfigurationsList = adminService.findConfiguredTestByTrainer(userId.getLoginId());
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			testConfigurationsList =  adminService.findAllAvailableOnlineTests();
		}
		model.addAttribute("testConfigurationsList", testConfigurationsList);
		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		String ptechName="";
		String ptestName="";
		for (TestConfiguration c : testConfigurationsList){
			if(ptechName.length()==0){
				ptechName=c.getTechName();
				ptestName=c.getTestName();
			}
			if(ptechName.equals(c.getTechName())){
				testNames.add(c.getTestName());
			}
			techNames.add(c.getTechName());
		}	
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		// model is type of hashMap
		model.addAttribute("users", users);
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.ADMIN_BASE
				+ UserNavigationPage.CONSULTANT_GROUP_RESET_TEST_PAGE;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="assign-consultant-tech-test",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse assignConsultantTechTest(Model model,@RequestParam(value="batchName",required=false) String batchName,
			@RequestParam(value="testName",required=false) String testName,@RequestParam(value="techName",required=false) String techName,@RequestParam(value="consultantid",required=false) String consultantid,HttpSession session) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method resetConsultantTest.");
		}
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		AssignedTestUserForm assigned = new AssignedTestUserForm();
		assigned.setTestName(testName);
		assigned.setTechName(techName);
		assigned.setUserId(consultantid);
		assigned.setModifyBy(userId.getLoginId());
		assigned.setAssignDate(new Date());
		assigned.setTestStatus(ApplicationContant.NOT_STARTED);
		assigned.setAttamptLimit(ApplicationContant.DEFAULT_ATTEMPT_LIMIT);
		// Random rnd = new Random();
		// assigned.setLink(String.valueOf(((userid+testName).hashCode()+rnd.nextLong(10000))));
		assigned.setLink(String.valueOf(System.currentTimeMillis()));
		System.out.println(assigned.getLink());
		onlineTechTestService.addAssignedTest(assigned);
		//String result=adminService.resetConsultantTestByTech(techName,testName, consultantid);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setStatus(ApplicationMessageConstant.TEST_IS_ASSIGNED_SUCCESSFULLY_TO_USER);
		return applicationMessageResponse;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="reset-consultant-test-ajax",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse resetConsultantTest(Model model,@RequestParam(value="batchName",required=false) String batchName,
			@RequestParam(value="testName",required=false) String testName,@RequestParam(value="techName",required=false) String techName,@RequestParam(value="consultantid",required=false) String consultantid,@RequestParam(value="withHistory",required=false) String withHistory,@RequestParam(value="userSessionId",required=false) String userSessionId) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method resetConsultantTest.");
		}
		if(withHistory!=null && withHistory.equals("yes")) {
		String result=adminService.resetConsultantTestByTech(techName,testName, consultantid,true,userSessionId);
		if(logger.isInfoEnabled()) {
			logger.info("result = "+result);
		}
		}else{
			String result=adminService.resetConsultantTestByTech(techName,testName, consultantid,false,userSessionId);
		}
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setStatus(ApplicationMessageConstant.TEST_RESET_SUCCESSFULLY_FOR_USER);
		return applicationMessageResponse;
	}
	
	
	
	@RequestMapping(value = "consultant-test-reset", method = RequestMethod.GET)
	public String resetConsultantTest(HttpSession session,Model model) {
		String userRole = getUserRoleFromSession(session);
		UserId userid=getUserIdFromSession(session);	
		List<String> batchList = new ArrayList<String>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			batchList = facultyService.findGroupNamesByTrainerId(userid.getId());
			if(batchList.size()==0){
				batchList =  consultantAssesmentService.findActiveBatches();
			}
		} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			batchList =  consultantAssesmentService.findActiveBatches();
		}
		if(batchList!=null){
			Collections.sort(batchList,Collections.reverseOrder());
		}
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(0);
		}
		
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);

		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<TestConfiguration> testConfigurationsList=new ArrayList<TestConfiguration>();
		if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
			testConfigurationsList = adminService.findConfiguredTestByTrainer(userId.getLoginId());
		}else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
			testConfigurationsList = adminService.findAllAvailableOnlineTests();
		}
		model.addAttribute("testConfigurationsList", testConfigurationsList);
		List<String> testNames = new ArrayList<String>();
		List<String> techNames = new ArrayList<String>();
		String ptechName="";
		String ptestName="";
		for (TestConfiguration c : testConfigurationsList){
			if(ptechName.length()==0){
				ptechName=c.getTechName();
				ptestName=c.getTestName();
			}
			if(ptechName.equals(c.getTechName())){
				testNames.add(c.getTestName());
			}
			if(!techNames.contains(c.getTechName()))
			techNames.add(c.getTechName());
		}	
		
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(ptechName, ptestName, sbatchName, true);
		// model is type of hashMap
		model.addAttribute("users", users);
		
		model.addAttribute("testNames", testNames);
		model.addAttribute("techNames", techNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.CONSULTANT_TEST_RESET_PAGE;
	}
	
	
	@RequestMapping(value = "select-interview-status", method = RequestMethod.GET)
	public String showInterviewedBatch(Model model) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		model.addAttribute("nextAction", "select-screening-interview");
		// List<String>
		// batchList=consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		// model.addAttribute("nextAction","startConsultantInterview");
		model.addAttribute("pageTitle", "Screening Interview Status");
		model.addAttribute("nextTitle", "Status");
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.SELECT_INTERVIEW_STATUS_PAGE;
	}
	
	
	/*@RequestMapping(value = "upload-questions-answers", method = RequestMethod.GET)
	public String uploadQuestionAnswers(Model model) {
		// Fetch data for all users.
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.UPLOAD_QUESTIONS_ANSWERS_PAGE;
	}*/
	
	
	@RequestMapping(value = "send-exam-link", method = RequestMethod.GET)
	public String sendExamLink(Model model,HttpSession session) {
		// Fetch data for all users.
		// Fetch data for all users.
				String userRole = getUserRoleFromSession(session);
				List<String> userGroupList = new ArrayList<String>();
				UserId userid=getUserIdFromSession(session);	
				if (ApplicationContant.TRAINER_ROLE.equals(userRole)) {
					userGroupList = facultyService.findGroupNamesByTrainerId(userid.getId());
				} else if (ApplicationContant.ADMIN_ROLE.equals(userRole)) {
					userGroupList =  consultantAssesmentService.findActiveBatches();
				}
				List<TestConfiguration> availableTestList = onlineTechTestService.findAllAvailableTest();

				List<AssignTestUserForm> userList = new ArrayList<AssignTestUserForm>();
				// model is type of hashMap
				model.addAttribute("userList", userList);
				model.addAttribute("userGroupList", userGroupList);

				List<String> testNames = new ArrayList<String>();
				List<String> techNames = new ArrayList<String>();
				for (TestConfiguration c : availableTestList){
					testNames.add(c.getTestName());
					
					if(!techNames.contains(c.getTechName()))
					techNames.add(c.getTechName());
					
				}	
				model.addAttribute("techNames", techNames);
				model.addAttribute("testNames", testNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.SEND_EXAM_LINK_PAGE;
	}
	
	

//	@RequestMapping(value = "sendExamLink", method = RequestMethod.POST)
//	public String sendExamLink(Model model, HttpServletRequest request) {
//
//		String testName = request.getParameter("testName");
//		String[] userids = request.getParameterValues("userCb");
//		String currentUserId = getUserData(request).getLoginId();
//		for (String userid : userids) {
//			AssignedTestUserForm assigned = new AssignedTestUserForm();
//			assigned.setTechName(testName);
//			assigned.setUserId(userid);
//			assigned.setModifyBy(currentUserId);
//			assigned.setAssignDate(new Date());
//			assigned.setTestStatus(ApplicationContant.NOT_STARTED);
//			assigned.setAttamptLimit(ApplicationContant.DEFAULT_ATTEMPT_LIMIT);
//			// Random rnd = new Random();
//			// assigned.setLink(String.valueOf(((userid+testName).hashCode()+rnd.nextLong(10000))));
//			assigned.setLink(String.valueOf(System.currentTimeMillis()));
//			System.out.println(assigned.getLink());
//
//			onlineTechTestService.addAssignedTest(assigned);
//
//			// generate test url for email
//			String requestURI = request.getRequestURI();
//			String contextPath = request.getContextPath();
//			String fullURL = request.getRequestURL().toString();
//			String url = fullURL.substring(0, fullURL.length() - requestURI.length());
//			String TestLinkUrl = url + contextPath + "/MTID/" + assigned.getLink();
//			System.out.println("++++++test link: " + TestLinkUrl);
//			// adminemail
//			String toEmail = (String) request.getSession().getServletContext()
//					.getInitParameter(ApplicationContant.ADMIN_EMAIL_ID);
//			System.out.println("email comming from web.xml   =  " + toEmail);
//			String loggedUserRole = getUserRoleFromSession(request.getSession());
//			System.out.println("loggedUserRole  =  " + loggedUserRole);
//			// send link to the user
//			try {
//				if (ApplicationContant.TRAINER_ROLE.equalsIgnoreCase(loggedUserRole)) {
//					toEmail = onlineTechTestService.findEmailIdByConsultantId(userid);
//				} else {
//					toEmail = onlineTechTestService.findEmailIdByUserId(userid);
//				}
//			} catch (Exception ex) {
//				System.out.println(ex.getMessage());
//			}
//			System.out.println("sending an email to   =  " + toEmail);
//			// javaEmailSender.sendMail("abc@gmail.com", toEmail,
//			// "your test link is generated", TestLinkUrl);
//			new EmailSenderThread(userEmailService, toEmail, TestLinkUrl,
//					ApplicationMessageConstant.YOUR_TEST_LINK_IS_GENERATED).start();
//		}
//
//		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
//				ApplicationMessageConstant.TEST_LINK_IS_SENT_TO_USERS);
//		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
//	}
//	@RequestMapping(value = "add-session-batch", method = RequestMethod.GET)
//	public String showSessionBatch(Model model) {
//		TrainingSessionsDetailVO trainingSessionsDetailVO = new TrainingSessionsDetailVO();
//		model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVO);
//		List<String> batchList = consultantAssesmentService.findActiveBatches();
//		if (batchList != null && batchList.size() > 0) {
//			String currentBatch = batchList.get(batchList.size() - 1);
//			model.addAttribute("currentBatch", currentBatch);
//			List<ConsultantsVO> consultantsVOList = consultantAssesmentService
//					.findConsultantsByBatch(currentBatch);
//			model.addAttribute("consultantList", consultantsVOList);
//		}
//		model.addAttribute("batchList", batchList);
//		return UserNavigationPage.TRAINER_BASE
//				+ UserNavigationPage.ADD_SESSION_BATCH_PAGE;
//	}
//	
	
	@RequestMapping(value = "add-contents-course-details", method = RequestMethod.GET)
	public String addConsultantCourseDetail(Model model) {
		Map<Integer, String> languageList = consultantAssesmentService
				.findAllLanguages();
		List<String> courseList = consultantAssesmentService.findAvailableCourses();
		CourseContentsDetailVO courseContentsDetailVO = new CourseContentsDetailVO();
		model.addAttribute("courseContentsDetailVO", courseContentsDetailVO);
		model.addAttribute("languageList", languageList);
		model.addAttribute("courseList", courseList);
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.ADD_CONTENTS_COURSE_DETAILS;

	}
	
	@RequestMapping(value = "add-contents-course-details", method = RequestMethod.POST)
	public String addConsultantCourseDetailPost(@RequestParam("technologyname") String techId,@RequestParam("course") String courseId,@RequestParam("topics") String topicsids,HttpSession session,Model model) {
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String loggedUserid = userSession.getLoginId();
		List<CourseContentsDetailVO> contentsDetailVOs=new ArrayList<CourseContentsDetailVO>();
		String splittedTopicId[]=topicsids.split(",");
		for(String topicid:splittedTopicId) {
			CourseContentsDetailVO contentsDetailVO=new CourseContentsDetailVO();
			contentsDetailVO.setCourse(courseId);
			contentsDetailVO.setTechnologyid(techId);
			contentsDetailVO.setDescription("NA");
			contentsDetailVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
			contentsDetailVO.setDom(DateUtils.getCurrentTimeIntoTimestamp());
			contentsDetailVO.setTechnologyname(techId);
			contentsDetailVO.setTopicid(topicid);
			contentsDetailVO.setTopicname(topicid);
			contentsDetailVO.setUserid(loggedUserid);
			contentsDetailVOs.add(contentsDetailVO);
		}
		
		contentsService.addTopicsCourse(contentsDetailVOs);
		model.addAttribute("nextActionMessage","Please click here to add another course contents detail.");
		model.addAttribute("nextAction","action/add-contents-course-detail");
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.COURSE_IS_ADDED_MESSAGE);
	 	return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.SUCCESS_OPERATION_PAGE;
	 	
	}
	
	@RequestMapping(value = "add-consultant", method = RequestMethod.GET)
	public String addConsltant(Model model) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		// List<String> streamList=consultantAssesmentService.findAllStream();
		ConsultantsVO consultant = new ConsultantsVO();
		consultant.setGender("Male");
		model.addAttribute("batchList", batchList);
		// model.addAttribute("streamList",streamList);
		model.addAttribute("consultant", consultant);
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.ADD_CONSULTANT_PAGE;
	}
	
	
	@RequestMapping(value = "add-batch", method = RequestMethod.GET)
	public String addbatch(Model model) {
		 List<BatchVO> batchVOs=userAdminCommonService.findBatches();
		BatchVO batch = new BatchVO();
		model.addAttribute("batch", batch);
		model.addAttribute("batchVOs", batchVOs);
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.ADD_BATCH_PAGE;
	}
	
	@RequestMapping(value = "add-batch", method = RequestMethod.POST)
	@ResponseBody public ApplicationMessageResponse addbatchPost(@ModelAttribute BatchVO batchVO,HttpSession session,Model model) {
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		batchVO.setUserid(userSession.getLoginId());
		batchVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		batchVO.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		userAdminCommonService.addBatch(batchVO);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setMessage(batchVO.getBatch()+" has been created successfully.....");
		return applicationMessageResponse;
/*		model.addAttribute("AppMessage",batchVO.getBatch()+" has been created successfully.....");
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.ADD_BATCH_PAGE;*/
	}
	
	
	
//	@RequestMapping(value = "show-technology-progress", method = RequestMethod.GET)
//	public String findTechnologyStatus(Model model) {
//		List<String> batchList = consultantAssesmentService.findActiveBatches();
//		model.addAttribute("batchList", batchList);
//		// List<String>
//		// batchList=consultantAssesmentService.findActiveBatches();
//		model.addAttribute("batchList", batchList);
//		return UserNavigationPage.TRAINER_BASE
//				+ UserNavigationPage.SHOW_TECHNOLOGIES_PROGRESS_PAGE;
//	}
	
	@RequestMapping(value = "update-consultant-details", method = RequestMethod.POST)
	@ResponseBody public ApplicationMessageResponse updateConsultantDetails(@ModelAttribute ConsultantsVO consultantsVO,HttpSession session,Model model) {
		consultantsVO.setAdminid(getUserIdFromSession(session).getLoginId());
		consultantService.updateConsultantGroupByUserid(consultantsVO);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus("success");
		applicationMessageResponse.setMessage("Consultant records has been updated successfully");
		return applicationMessageResponse;
	}
	
	
	@RequestMapping(value = "show-hide-test-change-status", method = RequestMethod.POST)
	public String showHideTestChangeStatus(@RequestParam(value="batchName",required=false) String batchName,@RequestParam(value="techName",required=false) String techName,@RequestParam(value="testName",required=false) String testName,@RequestParam(value="cstatus",required=false) String cstatus,Model model) {
		onlineTechTestService.updateAssignedTestStatus(batchName, techName, testName, cstatus);	
	   // Fetch data for all users.
	   List<String> userGroupList = consultantAssesmentService
						.findActiveBatches();
				model.addAttribute("userGroupList", userGroupList);
		if(batchName!=null && batchName.length()>0) {		
			List<AssignedTestUser> assignedTestUsersList=onlineTechTestService.findAllAssignedTests(batchName);
			if(assignedTestUsersList==null || assignedTestUsersList.size()==0) {
				model.addAttribute("ApplicationMessage", "Sorry no test is assigned to the group "+batchName);
			}
			model.addAttribute("assignedTestUsersList",assignedTestUsersList);
		}else {
			model.addAttribute("ApplicationMessage", "Please select a group.");
			model.addAttribute("assignedTestUsersList",new ArrayList<AssignedTestUser>());
		}
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.SHOW_HIDE_TESTS_PAGE;
	}
	
	@RequestMapping(value = "show-hide-tests", method = RequestMethod.GET)
	public String showHideTests(@RequestParam(value="batchName",required=false) String batchName,Model model) {
		// Fetch data for all users.
	   List<String> userGroupList = consultantAssesmentService
						.findActiveBatches();
				model.addAttribute("userGroupList", userGroupList);
		if(batchName!=null && batchName.length()>0) {		
			List<AssignedTestUser> assignedTestUsersList=onlineTechTestService.findAllAssignedTests(batchName);
			if(assignedTestUsersList==null || assignedTestUsersList.size()==0) {
				model.addAttribute("ApplicationMessage", "Sorry no test is assigned to the group "+batchName);
			}
			model.addAttribute("assignedTestUsersList",assignedTestUsersList);
		}else {
			model.addAttribute("ApplicationMessage", "Please select a group.");
			model.addAttribute("assignedTestUsersList",new ArrayList<AssignedTestUser>());
		}
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.SHOW_HIDE_TESTS_PAGE;
	}
	
	// Display All User Page
	@RequestMapping(value = "show-all-consultants", method = RequestMethod.GET)
	public String showAllConsultants(@RequestParam(value="batchName",required=false) String batchName,@RequestParam(value="email",required=false) String email,Model model) {
		UserListInput userListInput = new UserListInput();
		if(email!=null && email.trim().length()>0){
			consultantAssesmentService.deleteConsultantByEmailId(email);
			model.addAttribute("ApplicationMessage", "Consultant with "+email+" userid is deleted successfully from the database");
		}
		if(batchName==null || batchName.length()==0)
		userListInput.setSelectedGroupName("All");
		else
			userListInput.setSelectedGroupName(batchName);
		// Fetch data for all users.
		List<ConsultantsVO> consultantsVOs=new ArrayList<ConsultantsVO>();
		if(batchName!=null && batchName.length()>0 && !batchName.equalsIgnoreCase("All")) {
			consultantsVOs = consultantAssesmentService
					.findConsultantsByBatch(batchName);
		}else{
			consultantsVOs = consultantAssesmentService
					.findAllConsultants();
			
		}
		
		List<UserForm> users = new ArrayList<UserForm>();
		for (ConsultantsVO consultantsVO : consultantsVOs) {
			UserForm userForm = new UserForm();
			userForm.setFirstName(consultantsVO.getName());
			userForm.setEmail(consultantsVO.getEmail());
			userForm.setPassword(consultantsVO.getPassword());
			userForm.setBatch(consultantsVO.getBatch());
			userForm.setLoginid(consultantsVO.getUserid());
			if (ApplicationContant.USER_LOCKED.equalsIgnoreCase(consultantsVO
					.getLockStatus())) {
				userForm.setLockStatus(ApplicationContant.USER_LOCKED);
			} else {
				userForm.setLockStatus(ApplicationContant.USER_UNLOCKED);
			}
			users.add(userForm);
		}
		// Fetch data for all users.
		List<String> userGroupList = consultantAssesmentService
				.findActiveBatches();
		model.addAttribute("userGroupList", userGroupList);
		// model is type of hashMap
		model.addAttribute("imageURL", "action/findConsultantImage");
		model.addAttribute("users", users);
		model.addAttribute("userListInput", userListInput);
		return UserNavigationPage.TRAINER_BASE
				+ UserNavigationPage.SHOW_ALL_USERS_PAGE;
	}
	
	
	@RequestMapping(value="add-question-bank",method=RequestMethod.GET)
	public String addQuestionBank(Model model){
		QuestionsBankForm questionBankVO=new QuestionsBankForm();
		//model is type of hashMap
		model.addAttribute("questionBankVO",questionBankVO);
		model.addAttribute("action","add-question-bank");
		model.addAttribute("buttonLable","Add Question Bank");
		return UserNavigationPage.TRAINER_BASE+UserNavigationPage.ADD_EDIT_QUESTION_BANK_PAGE;	
	}
	
	@RequestMapping(value="add-question-bank",method=RequestMethod.POST)
	public String addQuestionBankPost(@ModelAttribute("questionBankVO") QuestionsBankForm  questionsBankForm,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug(questionsBankForm);
		}
		
		String status=questionBankService.checkQuestionBankTechName(questionsBankForm.getTechName(), questionsBankForm.getQbankname());
		if("exist".equalsIgnoreCase(status)){
			//model is type of hashMap
			model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,"This \""+questionsBankForm.getQbankname()+"\" "+ApplicationMessageConstant.QUESTION_BANK_ALREADY_EXIST_INTO_DB_MESSAGE);
			model.addAttribute("questionBankVO",questionsBankForm);
			model.addAttribute("action","add-question-bank");
			model.addAttribute("buttonLable","Add Question Bank");
			return UserNavigationPage.TRAINER_BASE+UserNavigationPage.ADD_EDIT_QUESTION_BANK_PAGE;	
		}
		
		questionsBankForm.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		questionsBankForm.setOwnerName(getUserIdFromSession(session).getLoginId());
		//Here Service Integration
		questionBankService.addQuestionBank(questionsBankForm);
		//request.setAttribute("allTechs",allTechs);
		model.addAttribute("buttonLable","Add Question Bank");
		model.addAttribute("action","add-question-bank");
		model.addAttribute("nextActionMessage","Please click here to add another question bank.");
		model.addAttribute("nextAction","action/add-question-bank");
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.QUESTION_BANK_NAME_IS_ADDED_MESSAGE);
	 	return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.SUCCESS_OPERATION_PAGE;
	}
	
	
	@RequestMapping(value="add-topic",method=RequestMethod.GET)
	public String showUserTechnologyPage(Model model){
		TopicVO topicVO=new TopicVO();
		//model is type of hashMap
		model.addAttribute("topicVO",topicVO);
		model.addAttribute("action","addTopic");
		model.addAttribute("buttonLable","Add");
		return UserNavigationPage.TRAINER_BASE+UserNavigationPage.ADD_EDIT_TOPICS_PAGE;	
	}

	
	@RequestMapping(value="add-topic",method=RequestMethod.POST)
	public String submitTechForm(@ModelAttribute("topicVO") TopicVO topicVO,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug(topicVO);
		}
		topicVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		topicVO.setLastUpdate(DateUtils.getCurrentTimeIntoTimestamp());
		topicVO.setAdminid(getUserIdFromSession(session).getLoginId());
		//Here Service Integration
		topicsService.addTopic(topicVO);
		//request.setAttribute("allTechs",allTechs);
		model.addAttribute("buttonLable","Add");
		model.addAttribute("action","addTopic");
		model.addAttribute("nextActionMessage","Please click here to add another topic.");
		model.addAttribute("nextAction","action/addTopic");
		topicVO.setTopic("");
		topicVO.setDescription("");
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.TOPIC_IS_ADDED_MESSAGE);
	 	return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.SUCCESS_OPERATION_PAGE;
	}

	
	
	@RequestMapping(value="show-available-tests", method=RequestMethod.GET)
	public String showAvailableTests(Model model, HttpSession session)
	{
		//code for technology name
		List<String> techList = new ArrayList<>();
		List<com.synergisitic.it.web.form.Technology> availableTechologyList =technolgyCategoryService.findAllTechnolgy();
		for(com.synergisitic.it.web.form.Technology tech: availableTechologyList){
			techList.add(tech.getTname());
		}
		
		
		//we want the tests to be showed up according to user
		//so we will need userid
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String loginid=userId.getLoginId();
		
		
		//now code for available tests of that specific userid
		List<TestConfiguration> availableTestList=onlineTechTestService.findAllAvailableTestByUserId(loginid);
		System.out.println("0099999 = "+availableTestList);
		model.addAttribute("techList",techList);
		model.addAttribute("availableTestList",availableTestList);
		return   UserNavigationPage.TRAINER_BASE+UserNavigationPage.SHOW_AVAILABLE_TESTS_PAGE;
	}
	
	
	


	private UserId getUserData(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}


	public String getUserRoleFromSession(HttpSession session) {
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId.getRole();
	}
	
//	@Override
	public UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
	
	
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
	
	
	
	
	@ModelAttribute("technologyList")
	public Map<Integer,String> populateTechnologyList() {
		//Data referencing for web framework combo
		Map<Integer,String> technologyList = new LinkedHashMap<Integer,String>();
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
			technologyList.put(tech.getId(),tech.getTname());
		}
		return technologyList;
	}

	}
	
