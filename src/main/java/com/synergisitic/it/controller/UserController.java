package com.synergisitic.it.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synergisitic.it.email.service.GuestEmailService;
import com.synergisitic.it.email.service.UserEmailService;
import com.synergisitic.it.email.service.vo.EmailMessageVO;
import com.synergisitic.it.model.AssignedTestCompositeKey;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.ChangePassword;
import com.synergisitic.it.model.QaDb;
import com.synergisitic.it.model.RecordList;
import com.synergisitic.it.model.User;
import com.synergisitic.it.navigation.AdminNavigationPage;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.report.model.OCJPReportCard;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.QuestionAndAnswerService;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.AssignTestUserForm;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.GuestUserForm;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserId;
import com.synergisitic.it.web.form.UserListInput;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.info.jdbc.service.IUserRoleService;
import com.techquiz.info.jdbc.service.StudentJdbcService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

@Controller
public class UserController {

	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	

	@Autowired
	@Qualifier("GuestEmailServiceImpl")
	private GuestEmailService guestEmailService;

	@Autowired
	@Qualifier("AdminServiceImpl")
	private AdminService adminService;

	@Autowired
	@Qualifier("StudentJdbcServiceImpl")
	private StudentJdbcService studentJdbcService;

	@Autowired
	@Qualifier("UserRoleService")
	private IUserRoleService userRoleService;

	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;

	@Autowired
	@Qualifier("QuestionAndAnswerServiceImpl")
	private QuestionAndAnswerService questionAndAnswerService;

	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	

	@RequestMapping(value = "goHome", method = RequestMethod.POST)
	public String redirectHome() {
		return NavigationPage.ADMIN_HOME;
	}

	@RequestMapping(value = "userRegistration", method = RequestMethod.GET)
	public String showUserRegistrationPage(Model model) {
		User user = new User();
		// model is type of hashMap
		model.addAttribute("user", user);
		return UserNavigationPage.USER_BASE + NavigationPage.USER_REGISTRATION_PAGE;
	}

	@RequestMapping(value = "deleteQAform", method = RequestMethod.GET)
	public String redirectdeleteQA(ModelMap model) {
		model.addAttribute("RecordList", new RecordList());
		model.addAttribute("techList", QaDb.getTechnologyList());
		return "deleteQA";
	}

	@RequestMapping(value = "deleteQues", method = RequestMethod.GET)
	public String deleteQuestion(Model model, @RequestParam(value = "questionId", required = false) String qId) {
		// System.out.println("printing value qid:"+qId);
		List<QuestionsForm> queForm = onlineTechTestService.deleteQues(qId);
		model.addAttribute("queForm", queForm);
		return "displayQuesList";
	}

	@RequestMapping(value = "updateQues", method = RequestMethod.POST)
	public String updateQuestion(Model model, @RequestParam(value = "questionId", required = false) String qId) {
		questionAndAnswerService.updateQues(qId);
		return "updateQA";
	}

	/*
	 * List<UserForm> allUsers=userService.deleteUser(userCb);
	 * model.addAttribute("users",allUsers); return NavigationPage.ALL_USERS;
	 */
	@RequestMapping(value = "deleteQAform", method = RequestMethod.POST)
	public String forwarddeleteQA(Model model, HttpServletRequest request) {
		String getSelectParam = request.getParameter("techType");
		System.out.println("printing select" + getSelectParam);
		int page = 1;

		HttpSession session = request.getSession();
		session.setAttribute("techtype", getSelectParam);
		int noOfRecords = onlineTechTestService.getNoofRecords();
		System.out.println("am out and printing number of records:" + noOfRecords);
		// int noOfRecords=2;
		// int noOfRecords = 7 ;
		List<QuestionsForm> queForm = onlineTechTestService.getQuestionsbyTech(getSelectParam, page);
		// System.out.println(quesForm.getDateOfEntry());

		int noOfPages = 2;
		int noOfPagess = (int) Math.ceil((noOfRecords) / 3);
		System.out.println("printing noOfPagess" + noOfPagess);
		session.setAttribute("noOfPages", noOfPages);
		session.setAttribute("currentPage", page);
		// Number noOfPages = 3;
		/*
		 * for(QuestionsForm q:queForm) { System.out.println("ffff"+q.getId());
		 * }
		 */
		model.addAttribute("queForm", queForm);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);

		return "displayQuesList";
	}

	@RequestMapping(value = "/pageList", method = RequestMethod.GET)
	public String iteratePageList(Model model, HttpServletRequest request,
			@RequestParam(value = "page", required = false) int page) {
		System.out.println("atleast am in");
		System.out.println("printing page:" + page);
		HttpSession session = request.getSession();
		System.out.println("printing techType:" + session.getAttribute("techtype"));
		model.addAttribute("queForm", this.onlineTechTestService.getQuestionsbyTech("Core Java", page));
		session.setAttribute("currentPage", page);
		return "displayQuesList";
		// return null;
	}

	/*
	 * @RequestMapping(value = "/exchangejson", method = RequestMethod.POST)
	 * public @ResponseBody Map<String, List<String>>
	 * onSelectChange(@RequestBody String newInput) { Map<String, List<String>>
	 * map = new HashMap<String, List<String>>(); List<String> optionList =
	 * QaDb.optionList(newInput); map.put("optionList", optionList); return map;
	 * }
	 */
	@Autowired
	@Qualifier("UserEmailServiceImpl")
	private UserEmailService userEmailService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		// it will convert byte stream into array of bytes
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

	/**
	 * 
	 * @param user
	 *   addUserForm
	 * @return
	 */
	@RequestMapping(value = "userRegistration", method = RequestMethod.POST)
	public String addUserRegistration(@ModelAttribute("user") User user,@RequestParam(value="member",required=false) String member, Model model,
			final RedirectAttributes redirectAttributes) {
		// user.setLoginid(user.getFirstName()); //
		// here we can write logic to encyrpt it
		try {
			//DESedeEncryption deSedeEncryption = new DESedeEncryption();
			if (user.getPassword() != null) {
				// here we are setting password into user object after
				// encrypting it
				user.setPassword(user.getPassword());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// setting the default role for the user
		user.setRole(ApplicationContant.USER_ROLE);
		user.setLoginid(user.getEmail());
		user.setDoe(new Date());
		user.setActive(ApplicationContant.USER_ACTIVE_NO);
		user.setDescription(ApplicationContant.APP_DATA_AUTO);
		if("yes".equals(member)){
			user.setAddress("NA");
			user.setMobile("+919837002");
			user.setLockStatus("unlocked");
			user.setGender(user.getGender());
		}
		try {
			User duUser=userService.findUserByEmailId(user.getEmail());
			if(duUser!=null && duUser.getEmail()!=null){
				redirectAttributes.addFlashAttribute("emessage","Sorry , this email is already in use , Thank you.");
				return "redirect:/success.jsp?ApplicationMessage=Sorry, this email "+duUser.getEmail()+" is already used by someone , kindly use another email id, thanks!";
			}
		}catch(Exception ex){
		}
		String result = userService.addUser(user);
		if (ApplicationContant.USER_ALREADY_EXISTS.equals(result)) {
			model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.QUESTION_BANK_NAME_IS_ADDED_MESSAGE);
			return UserNavigationPage.USER_BASE + CommonNavigationPage.SUCCESS_OPERATION_PAGE;
		}
		redirectAttributes.addFlashAttribute("emessage","You have successfully registered into our application , Thank you.");
		return "redirect:/success.jsp?ApplicationMessage=You have  successfully registered with and you will get an email once your account is approved, thanks!";
		
	}

	/**
	 * This is dummy method which is not used so for.
	 * 
	 * @param uname
	 * @param ppassword
	 * @return
	 */
	@RequestMapping(value = "login/{username}/{password}", method = RequestMethod.GET)
	// http://localhost:8090/OnlineTechTest/action/login/nagendra/test
	public String login(@PathVariable("username") String uname, @PathVariable("password") String ppassword) {
		if (uname.equalsIgnoreCase("admin") && ppassword.equalsIgnoreCase("test")) {
			return "success";
		}
		return "fail";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String showEditPage(HttpServletRequest request, Model model) {
		// logic to fetch data to be edited from db
		int objId = getUserObjectId(request);
		User user = userService.findUserById(objId);
		// model is type of hashMap
		model.addAttribute("user", user);
		return UserNavigationPage.USER_BASE + NavigationPage.USER_REGISTRATION_PAGE;
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editUserData(@ModelAttribute("user") User user, HttpServletRequest request) {
		// logic to fetch data to be edited from db
		user.setId(getUserObjectId(request));
		user.setLoginid(getUserData(request).getLoginId());
		user.setPassword(getUserData(request).getPassword());
		user.setRole("user");
		String result = userService.updateUser(user);
		System.out.println("String = " + result);
		// model is type of hashMap
		return NavigationPage.USER_HOME;
	}

	@RequestMapping(value = "user-profile", method = RequestMethod.GET)
	public String ushowEditPage(HttpServletRequest request, Model model) {
		// logic to fetch data to be edited from db
		int objId = getUserObjectId(request);
		User user = userService.findUserById(objId);
		// model is type of hashMap
		user.setPassword(getUserData(request).getPassword());
		model.addAttribute("user", user);
		return UserNavigationPage.USER_BASE +"user-profile";
	}

	@RequestMapping(value = "profilePost", method = RequestMethod.POST)
	public String ueditUserData(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {
		// logic to fetch data to be edited from db
		user.setId(getUserObjectId(request));
		user.setLoginid(getUserData(request).getLoginId());
		user.setPassword(getUserData(request).getPassword());
		// user.setRole("user");
		String result = userService.updateUser(user);
		System.out.println("String = " + result);
		// umodel is type of hashMap
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.USER_PROFILE_IS_UPDATED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;

	}

	@RequestMapping(value = "adminProfile", method = RequestMethod.GET)
	public String adminProfile(HttpServletRequest request, Model model) {
		// logic to fetch data to be edited from db
		int objId = getUserObjectId(request);
		User user = userService.findUserById(objId);
		// model is type of hashMap
		user.setPassword(getUserData(request).getPassword());
		model.addAttribute("user", user);
		return AdminNavigationPage.ADMIN_BASE + NavigationPage.USER_PROFILE_PAGE;
	}

	@RequestMapping(value = "adminProfile", method = RequestMethod.POST)
	public String adminProfilePost(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {
		// logic to fetch data to be edited from db
		user.setId(getUserObjectId(request));
		user.setLoginid(getUserData(request).getLoginId());
		user.setPassword(getUserData(request).getPassword());
		user.setRole("user");
		String result = userService.updateUser(user);
		System.out.println("String = " + result);
		// umodel is type of hashMap
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.USER_PROFILE_IS_UPDATED_SUCCESSFULLY);
		return AdminNavigationPage.ADMIN_BASE + NavigationPage.ADMIN_HOME;
	}

	/**
	 * This will display the change password screen where used can change his
	 * password.
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "changePassword", method = RequestMethod.GET)
	public String ShowChangePasswordPage(HttpServletRequest request, Model model) {
		ChangePassword changePassword = new ChangePassword();
		String currentPassword = getUserData(request).getPassword();
		changePassword.setCurrentPassword(currentPassword);
		// adding changePassword object into the request scope
		// and this will be used as command object at JSP page, means jsp form
		// will bind with
		// this object. so that once you submit the form data will be populated
		// into this pojo
		model.addAttribute("changePassword", changePassword);
		return AdminNavigationPage.ADMIN_BASE + "changePassword";
	}

	// @ModelAttribute("changePassword") ChangePassword this line will bind
	// changePassword object with
	// method parameter of the the method updateChangePassword.
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public String updateChangePassword(@ModelAttribute("changePassword") ChangePassword changePassword,
			HttpServletRequest request, Model model) throws Exception {
		if (!changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
			// Error message new password and current password are not same
		} else {
			// Call Service here
			User user = new User();
			user.setId(getUserObjectId(request));
			//DESedeEncryption deSedeEncryption = new DESedeEncryption();
			//String encryptedPassword = deSedeEncryption.encrypt(changePassword.getNewPassword());
			user.setPassword(changePassword.getNewPassword());
			userService.changePassword(user);
			// Fetching UserId object from current session and setting new
			// password
			//
			getUserData(request).setPassword(changePassword.getNewPassword());
		}
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.USER_PASSWORD_IS_UPDATED_SUCCESSFULLY);
		return AdminNavigationPage.ADMIN_BASE + NavigationPage.ADMIN_HOME;
	}

	/**
	 * This will display the change password screen where used can change his
	 * password.
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "uchange-password", method = RequestMethod.GET)
	public String uShowChangePasswordPage(HttpServletRequest request, Model model) {
		ChangePassword changePassword = new ChangePassword();
		String currentPassword = getUserData(request).getPassword();
		changePassword.setCurrentPassword(currentPassword);
		// adding changePassword object into the request scope
		// and this will be used as command object at JSP page, means jsp form
		// will bind with
		// this object. so that once you submit the form data will be populated
		// into this pojo
		model.addAttribute("changePassword", changePassword);
		return UserNavigationPage.USER_BASE + "uchange-password";
	}

	// @ModelAttribute("changePassword") ChangePassword this line will bind
	// changePassword object with
	// method parameter of the the method updateChangePassword.
	@RequestMapping(value = "uchange-password", method = RequestMethod.POST)
	public String uupdateChangePassword(@ModelAttribute("changePassword") ChangePassword changePassword,
			HttpServletRequest request, Model model) throws Exception {
		if (!changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
			// Error message new password and current password are not same
		} else {
			// Call Service here
			User user = new User();
			// user.setPassword(changePassword.getNewPassword());
			user.setLoginid(getUserData(request).getLoginId());
			//DESedeEncryption deSedeEncryption = new DESedeEncryption();
			//String encryptedPassword = deSedeEncryption.encrypt(changePassword.getNewPassword());
			user.setPassword(changePassword.getNewPassword());
			userService.changePassword(user);
			// Fetching UserId object from current session and setting new
			// password
			//
			getUserData(request).setPassword(changePassword.getNewPassword());
		}
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.USER_PASSWORD_IS_UPDATED_SUCCESSFULLY);
		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}

	// Display All User Page
	@RequestMapping(value = "all-users", method = RequestMethod.GET)
	public String allUsers(Model model) {
		UserListInput userListInput = new UserListInput();
		userListInput.setSelectedGroupName("Users");
		// Fetch data for all users.
		List<UserForm> users = userService.findAllUsers();
		// Fetch data for all users.
		List<String> userGroupList = studentJdbcService.findAllDifferentGroups();
		model.addAttribute("userGroupList", userGroupList);
		// model is type of hashMap
		model.addAttribute("imageURL","action/imageByUserId");
		model.addAttribute("users", users);
		model.addAttribute("users", users);
		model.addAttribute("userListInput", userListInput);
		return AdminNavigationPage.ADMIN_BASE + AdminNavigationPage.SHOW_ALL_USERS_PAGE;
	}

	// Display All User Page
	@RequestMapping(value = "userTestsStatus", method = RequestMethod.GET)
	public String userTestsStatus(Model model) {
		UserListInput userListInput = new UserListInput();
		userListInput.setSelectedGroupName("Users");
		// Fetch data for all users.
		List<UserForm> users = userService.findAllUsers();
		// Fetch data for all users.
		List<String> userGroupList = studentJdbcService.findAllDifferentGroups();
		model.addAttribute("userGroupList", userGroupList);
		// model is type of hashMap
		model.addAttribute("users", users);
		model.addAttribute("userListInput", userListInput);
		return AdminNavigationPage.ADMIN_BASE + AdminNavigationPage.SHOW_ALL_USERS_PAGE;
	}

	// Display All User Page
	@RequestMapping(value = "consultantTestStatus", method = RequestMethod.GET)
	public String consultantTestStatus(Model model) {
		List<String> userGroupList = userRoleService.findActiveBatchForConsultant();
		model.addAttribute("userGroupList", userGroupList);
		// Fetch data for all users.
		List<UserForm> users = consultantAssesmentService.findConsultantByBatch(userGroupList.get(0));
		// Fetch data for all users.
		UserListInput userListInput = new UserListInput();
		if (userGroupList != null && userGroupList.size() > 0)
			userListInput.setSelectedGroupName(userGroupList.get(0));
		else
			userListInput.setSelectedGroupName("None");

		// model is type of hashMap
		model.addAttribute("users", users);
		model.addAttribute("userListInput", userListInput);
		return AdminNavigationPage.ADMIN_BASE + AdminNavigationPage.SHOW_ALL_USERS_PAGE;
	}

	@RequestMapping(value = "findUserBYGroupName", method = RequestMethod.GET)
	public @ResponseBody List<UserForm> loadUsersByGroupName(@RequestParam("groupName") String groupName) {
		List<UserForm> users = null;
		if (!"Users".equalsIgnoreCase(groupName)) {
			users = studentJdbcService.loadUserByGroupName(groupName);
		} else {
			users = userService.findAllUsers();
		}

		return users;
	}

	@RequestMapping(value = "lockUnlockUser", method = RequestMethod.GET)
	public @ResponseBody ApplicationMessageResponse updateLockStatus(@RequestParam("userid") String userid,@RequestParam("lockstatus") String lockstatus) {
		String result=userService.lockUnlockUser(userid,lockstatus);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		if(result.equalsIgnoreCase(ApplicationContant.SUCCESS)){
			applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
			applicationMessageResponse.setMessage(ApplicationMessageConstant.USER_LOCK_STATUS_IS_UPDATED_SUCCESSFULLY);
		}else{
			applicationMessageResponse.setStatus(ApplicationContant.FAIL);
			applicationMessageResponse.setMessage(ApplicationMessageConstant.USER_LOCK_STATUS_IS_NOT_UPDATED_SUCCESSFULLY);
		}
		return applicationMessageResponse;
	}

	@RequestMapping(value = "userPreference", method = RequestMethod.GET)
	public String userPreference(Model model) {

		List<TestConfiguration> availableTestList = onlineTechTestService.findAllAvailableTest();
		List<String> testNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList)
			testNames.add(c.getTestName());
		model.addAttribute("testNames", testNames);

		return "userPreference";
	}

	// Display All User Page
	@RequestMapping(value = "assignTestToUser", method = RequestMethod.GET)
	public String assignExam(HttpSession session, Model model) {
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
		for (TestConfiguration c : availableTestList)
			testNames.add(c.getTestName());
		model.addAttribute("testNames", testNames);
		return AdminNavigationPage.ADMIN_BASE + CommonNavigationPage.ASSIGN_TEST_TO_USER_PAGE;
	}
	
	@RequestMapping(value = "unassignTestToUser", method = RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse unassignTestToUser(@RequestParam("userid") String userid,@RequestParam("testName") String testName,@RequestParam("techName") String techName){
		String response=onlineTechTestService.unassignedTestToUser(userid, techName, testName);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(response);
		applicationMessageResponse.setMessage(ApplicationMessageConstant.TEST_HAS_BEEN_UNASSIGNED_SUCCESSFULLY_FROM_USER+" "+userid);
		return applicationMessageResponse;
	}
	

	@RequestMapping(value = "assignTestToUser", method = RequestMethod.POST)
	public String assignExam(Model model, HttpServletRequest request) {
		System.out.println("Hey you are in the User Controller .................");
		String testName = request.getParameter("testName");
		String techName = request.getParameter("techName");
		String[] userids = request.getParameterValues("userCb");
		String validityStr = request.getParameter("validity");
		int testExpireTimeInHrs=Integer.parseInt(validityStr);
		String groupName = request.getParameter("selectedGroupName");
		List<AssignedTestUserForm> assignedTestUserFormList = new ArrayList<AssignedTestUserForm>();
		for (String userid : userids) {
			AssignedTestUserForm assigned = new AssignedTestUserForm();
			assigned.setTechName(techName);
			assigned.setGroupName(groupName);
			assigned.setTestName(testName);
			assigned.setLocked(ApplicationContant.USER_UNLOCKED);
			assigned.setResetDate(new Date());
			assigned.setUserId(userid);
			assigned.setModifyBy(getUserData(request).getLoginId());
			Date currentDate=new Date();
			String testExpireOnDate=DateUtils.nextDatePostByHrs(currentDate,testExpireTimeInHrs);
			assigned.setAssignDate(currentDate);
			assigned.setTestExpireTimeInHrs(testExpireTimeInHrs);
			assigned.setTestExpireOn(testExpireOnDate);
			assigned.setTestStatus(ApplicationContant.NOT_STARTED);
			assigned.setAttamptLimit(ApplicationContant.DEFAULT_ATTEMPT_LIMIT);
			assignedTestUserFormList.add(assigned);
		}
		onlineTechTestService.assignedTestToUsers(assignedTestUserFormList);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.TEST_IS_ASSIGNED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}

	@RequestMapping(value = "loadGroupUsers", method = RequestMethod.POST)
	public String loadUserByGroupName(Model model, @RequestParam("selectedGroupName") String selectedGroupName,
			@RequestParam("testName") String testname) {

		List<AssignTestUserForm> userList = new ArrayList<AssignTestUserForm>();

		List<UserForm> users = null;
		if (!"Users".equalsIgnoreCase(selectedGroupName)) {
			users = studentJdbcService.loadUserByGroupName(selectedGroupName);
		} else {
			users = userService.findAllUsers();
		}
		List<AssignedTestUserForm> assignedTestUsers = userService.findAllAssignedTestUsers(selectedGroupName,
				testname);
		for (UserForm userForm : users) {
			AssignTestUserForm assignTestUserForm = new AssignTestUserForm();
			assignTestUserForm.setLoginid(userForm.getLoginid());
			assignTestUserForm.setEmail(userForm.getEmail());
			assignTestUserForm.setName(userForm.getFirstName() + " " + userForm.getLastName());
			assignTestUserForm.setBatch(selectedGroupName);

			AssignedTestUserForm assignedTestUserForm = new AssignedTestUserForm();
			AssignedTestCompositeKey assignedTestCompositeKey = new AssignedTestCompositeKey("Core-Java",userForm.getLoginid(),testname);
			assignedTestUserForm.setAssignedTestCompositeKey(assignedTestCompositeKey);
			if (assignedTestUsers.contains(assignedTestUserForm)) {
				assignTestUserForm.setAssigned("yes");
			} else {
				assignTestUserForm.setAssigned("no");
			}
			userList.add(assignTestUserForm);
		}

		// Fetch data for all users.
		List<String> userGroupList = studentJdbcService.findAllDifferentGroups();
		// List<UserForm> users=userService.findAllUsers();
		// model is type of hashMap
		model.addAttribute("userList", userList);
		model.addAttribute("userGroupList", userGroupList);
		/* model.addAttribute("assignedTestUsers",assignedTestUsers); */
		model.addAttribute("selectedGroupName", selectedGroupName);
		List<TestConfiguration> availableTestList = onlineTechTestService.findAllAvailableTest();
		List<String> testNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList)
			testNames.add(c.getTestName());
		model.addAttribute("testNames", testNames);
		return AdminNavigationPage.ADMIN_BASE + CommonNavigationPage.ASSIGN_TEST_TO_USER_PAGE;
	}

	@RequestMapping(value = "sendExamLink", method = RequestMethod.GET)
	public String sendExamLink(Model model) {
		// Fetch data for all users.
		List<UserForm> users = userService.findAllUsers();
		// model is type of hashMap
		model.addAttribute("users", users);
		List<String> userGroupList = studentJdbcService.findAllDifferentGroups();
		// Putting Users as a first option inside the List
		userGroupList.remove(ApplicationContant.USERS_GROUP);
		userGroupList.add(0, ApplicationContant.USERS_GROUP);
		model.addAttribute("dgname", ApplicationContant.USERS_GROUP);
		// model is type of hashMap
		model.addAttribute("userGroupList", userGroupList);
		List<TestConfiguration> availableTestList = onlineTechTestService.findAllAvailableTest();
		List<String> testNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList)
			testNames.add(c.getTestName());
		model.addAttribute("testNames", testNames);
		model.addAttribute("imageURL", "action/imageByUserId");
		return AdminNavigationPage.ADMIN_BASE + NavigationPage.SEND_EXAM_LINK;
	}

	@RequestMapping(value = "loadSendExamLink", method = RequestMethod.POST)
	public String loadsendExamLinkPageBtGroup(Model model,
			@RequestParam(value = "selectedGroupName", required = false) String selectedGroupName,
			HttpServletRequest request) {
		String currentRole = getUserData(request).getRole();
		// Fetch data for all users.
		List<UserForm> users = null;
		if (!"Users".equalsIgnoreCase(selectedGroupName)) {
			users = studentJdbcService.loadUserByGroupName(selectedGroupName);
		} else {
			users = userService.findAllUsers();
		}
		List<String> userGroupList = new ArrayList<String>();

		if (ApplicationContant.TRAINER_ROLE.equalsIgnoreCase(currentRole)) {
			userGroupList = consultantAssesmentService.findActiveBatches();
		} else {
			userGroupList = studentJdbcService.findAllDifferentGroups();
		}
		// model is type of hashMap
		model.addAttribute("userGroupList", userGroupList);
		model.addAttribute("selectedGroupName", selectedGroupName);

		// model is type of hashMap
		model.addAttribute("users", users);
		List<TestConfiguration> availableTestList = onlineTechTestService.findAllAvailableTest();
		List<String> testNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList)
			testNames.add(c.getTestName());
		model.addAttribute("testNames", testNames);
		if (ApplicationContant.TRAINER_ROLE.equalsIgnoreCase(currentRole))
			model.addAttribute("imageURL", "action/findConsultantImage");
		else
			model.addAttribute("imageURL", "action/imageByUserId");
		return AdminNavigationPage.ADMIN_BASE + NavigationPage.SEND_EXAM_LINK;
	}

	@RequestMapping(value = "sendExamLink", method = RequestMethod.POST)
	public String sendExamLink(Model model, HttpServletRequest request) {
		String testName = request.getParameter("testName");
		String techName = request.getParameter("techName");
		String selectedGroupName = request.getParameter("selectedGroupName");
		
		String[] userids = request.getParameterValues("userCb");
		String currentUserId = getUserData(request).getLoginId();
		for (String userid : userids) {
			AssignedTestUserForm assigned = new AssignedTestUserForm();
			assigned.setTechName(techName);
			assigned.setTestName(testName);
			assigned.setGroupName(selectedGroupName);
			assigned.setUserId(userid);
			
			assigned.setModifyBy(currentUserId);
			assigned.setAssignDate(new Date());
			assigned.setTestStatus(ApplicationContant.NOT_STARTED);
			assigned.setAttamptLimit(ApplicationContant.DEFAULT_ATTEMPT_LIMIT);
			// Random rnd = new Random();
			// assigned.setLink(String.valueOf(((userid+testName).hashCode()+rnd.nextLong(10000))));
			assigned.setLink("OT"+String.valueOf(System.currentTimeMillis()));
			System.out.println(assigned.getLink());

			onlineTechTestService.addAssignedTest(assigned);

			// generate test url for email
			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String fullURL = request.getRequestURL().toString();
			String url = fullURL.substring(0, fullURL.length() - requestURI.length());
			String TestLinkUrl = url + contextPath + "/MTID?utid=" + assigned.getLink();
			System.out.println("++++++test link: " + TestLinkUrl);
			// adminemail
			String toEmail = (String) request.getSession().getServletContext()
					.getInitParameter(ApplicationContant.ADMIN_EMAIL_ID);
			System.out.println("email comming from web.xml   =  " + toEmail);
			String loggedUserRole = getUserRoleFromSession(request.getSession());
			System.out.println("loggedUserRole  =  " + loggedUserRole);
			// send link to the user
			try {
				if (ApplicationContant.TRAINER_ROLE.equalsIgnoreCase(loggedUserRole)) {
					toEmail = onlineTechTestService.findEmailIdByConsultantId(userid);
				} else {
					toEmail = onlineTechTestService.findEmailIdByUserId(userid);
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			System.out.println("sending an email to   =  " + toEmail);
			// javaEmailSender.sendMail("abc@gmail.com", toEmail,
			// "your test link is generated", TestLinkUrl);
			ConsultantsVO consultantsVO=consultantAssesmentService.findConsultantByUserid(userid);
			System.out.println(consultantsVO);
			GuestUserForm guestUserForm=new GuestUserForm();
			guestUserForm.setGender(consultantsVO.getGender());
			guestUserForm.setLocation(consultantsVO.getOrg());
			guestUserForm.setMobile(consultantsVO.getMobile());
			guestUserForm.setName(consultantsVO.getName());
			guestUserForm.setOccupation(consultantsVO.getRole());
			guestUserForm.setEmail(consultantsVO.getEmail());
			guestUserForm.setUserid(userid);
			guestUserForm.setGeneratedTestLink(TestLinkUrl);
			guestUserForm.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
			guestUserForm.setAdminid("admin");
			guestEmailService.sendTechTestEmailAsLink(guestUserForm,DateUtils.getServerBaseURL(request));
		}

		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.TEST_LINK_IS_SENT_TO_USERS);
		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}

	// Action for delete button on All User page
	@RequestMapping(value = "deleteUser", method = RequestMethod.POST)
	public String deleteTechnology(Model model, HttpServletRequest request) {
		String userCb[] = request.getParameterValues("userCb");
		List<UserForm> allUsers = userService.deleteUser(userCb);
		model.addAttribute("users", allUsers);
		return NavigationPage.ALL_USERS;
	}
	
	@RequestMapping(value="reset-consultant-test",method=RequestMethod.POST)
	public String resetConsultantTest(Model model,@RequestParam(value="testName",required=false) String testName,@RequestParam(value="techName",required=false) String techName,@RequestParam(value="consultantid",required=false) String consultantid,@RequestParam(value="withHistory",required=false) String withHistory,@RequestParam(value="userSessionId",required=false) String userSessionId) {
		String result=adminService.resetConsultantTestByTech(techName,testName, consultantid,true,userSessionId);
		List<UserOnlineExamStatusForm> userOnlineExamStatusList = userService.findAllUserOnlineExamStatus(consultantid);
		ConsultantsVO consultantsVO=consultantAssesmentService.findConsultantByUserid(consultantid);
		model.addAttribute("consultantsVO", consultantsVO);
		model.addAttribute("reset", "yes");
		model.addAttribute("ApplicationMessage",ApplicationMessageConstant.TEST_RESET_SUCCESSFULLY_FOR_USER+" "+consultantid);
		model.addAttribute("userOnlineExamStatusList", userOnlineExamStatusList);
		return UserNavigationPage.USER_BASE + "user-test-history";
	}

	// Action for delete button on All User page
	@RequestMapping(value = "user-test-history", method = RequestMethod.GET)
	public String showUserHistory(Model model,HttpSession session) {
		String puserid=((UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA)).getLoginId();
		List<UserOnlineExamStatusForm> userOnlineExamStatusList = userService.findAllUserOnlineExamStatus(puserid);
		model.addAttribute("userOnlineExamStatusList", userOnlineExamStatusList);
		return UserNavigationPage.USER_BASE + "user-test-history";
	}
	
	// Action for delete button on All User page
	   @RequestMapping(value = "user-test-history", method = RequestMethod.POST)
		public String showUserHistoryPost(Model model, @RequestParam(value="userid",required=true) String puserid) {
			List<UserOnlineExamStatusForm> userOnlineExamStatusList = userService.findAllUserOnlineExamStatus(puserid);
			ConsultantsVO consultantsVO=consultantAssesmentService.findConsultantByUserid(puserid);
			model.addAttribute("consultantsVO", consultantsVO);
			model.addAttribute("reset", "yes");
			model.addAttribute("userOnlineExamStatusList", userOnlineExamStatusList);
			return UserNavigationPage.USER_BASE + "user-test-history";
		}



	/*
	 * @RequestMapping(value="deleteQAform",method=RequestMethod.GET) public
	 * String deleteQAform(Model model,HttpServletRequest request){
	 * 
	 * 
	 * }
	 */

	/**
	 * This is returning id of object from session for logged user into the
	 * application
	 * 
	 * @param request
	 * @return
	 */
	private int getUserObjectId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId.getId();
	}

	private UserId getUserData(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}

	@RequestMapping(value = "aboutUs", method = RequestMethod.GET)
	public String aboutUs() {
		return "aboutUs";
	}

	@RequestMapping(value = "aaboutUs", method = RequestMethod.GET)
	public String aaboutUs() {
		return "aaboutUs";
	}

	@RequestMapping(value = "imageByUserId", method = RequestMethod.GET)
	public void showImageByUserId(@RequestParam("userid") String userid, HttpServletResponse response,HttpSession session) throws IOException {
		byte[] photo = userService.findPhotoByUserId(userid);
		System.out.println("++++++++++++++++++showImageByUserId+++++++++++++++++++++++++++ for userid = "+userid);
		//System.out.println("--------------photo-----------------------"+photo.length);
		if(photo==null || photo.length<=10){
			//Loading the image from the server folder
			InputStream is = session.getServletContext().getResourceAsStream("/images/icon/user-icon.png");
			photo = IOUtils.toByteArray(is);
		}
		// now write this photo means byte array into the response so that image
		// can be rendered on the UI
		response.setContentType("image/jpeg");
		try {
			ServletOutputStream out = response.getOutputStream();
			if (photo != null)
				out.write(photo);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @InitBinder
	// public void binder(WebDataBinder binder) {
	// binder.registerCustomEditor(Date.class,
	// new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
	// }

	
	@RequestMapping(value = "findUserBygroupNameTestTechNameAjax", method = RequestMethod.GET)
	public @ResponseBody List<UserForm> findUserBygroupNameTestNameAjax(Model model,
			@RequestParam("groupName") String selectedGroupName, @RequestParam("testName") String testname,@RequestParam("techName") String techName) {
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatchWithTechTestStatus(techName, testname, selectedGroupName, true);
		for(UserForm  form: users){
			if(form.getTechTestStatus()!=null && "complete".equalsIgnoreCase(form.getTechTestStatus())){
				form.setTechTestStatus("Completed");
			}
		}
		if(users!=null) {
			Collections.sort(users,new UserTestResultComparator());
		}
		return users;
	}	
	
	
	@RequestMapping(value = "serach-guest-test-history", method = RequestMethod.GET)
	public @ResponseBody List<UserForm> searchGuestTestHsitory(Model model, @RequestParam("searchString") String searchString) {
	   String  testname="All";
	    String techName="All";
		List<UserForm> users = consultantAssesmentService.findConsultantWithTechTestStatus(techName, techName, true);
		for(UserForm  form: users){
			if(form.getTechTestStatus()!=null && "complete".equalsIgnoreCase(form.getTechTestStatus())){
				form.setTechTestStatus("Completed");
			}
		}
		if(users!=null) {
			Collections.sort(users);
		}
		return users;
	}	
	
	
	@RequestMapping(value = "findGuestUserByTestTechNameAjax", method = RequestMethod.GET)
	public @ResponseBody List<UserForm> findGuestUserByTestTechNameAjax(Model model, @RequestParam("testName") String testname,@RequestParam("techName") String techName) {
	    testname="All";
	    techName="All";
		List<UserForm> users = consultantAssesmentService.findConsultantWithTechTestStatus(techName, techName, true);
		for(UserForm  form: users){
			if(form.getTechTestStatus()!=null && "complete".equalsIgnoreCase(form.getTechTestStatus())){
				form.setTechTestStatus("Completed");
			}
		}
		if(users!=null) {
			Collections.sort(users);
		}
		return users;
	}	
	
	@RequestMapping(value = "examDetail", method = RequestMethod.GET)
	public String showExamDetail(Model model, HttpServletRequest request) {
		String userId = getUserData(request).getLoginId();
		String testName = request.getParameter("testName");
		String techName = request.getParameter("techName");
		String userSessionId = request.getParameter("userSessionId");
		
		List<OCJPReportCard> testConfiguration =null;
		if(userSessionId==null)
			testConfiguration = adminService.findReportCardByUseridAndTest(userId, techName,testName);
		else
			testConfiguration = adminService.findReportCardByUseridAndTechTestSessionId(userId, techName,testName,userSessionId);
			
		// System.out.println("User: "+userId);
		System.out.println("testName: " + testName);
		AvailableTest testData = onlineTechTestService.fetchAllQuestionsByTestName(testName,techName, userId,userSessionId, false);
		// System.out.println(testData.toString());
		String questionIdsInArray[] = testData.getQuestionIds().split(",");
		String questionId="";
		List<QuestionAndAnsTestDataVO> questionList = new ArrayList<QuestionAndAnsTestDataVO>();
		for (String q : questionIdsInArray) {
			questionId=q;
			QuestionAndAnsTestDataVO question = onlineTechTestService.fetchNextQuestionAnswer(q, userId, testName,techName,
					userSessionId);
			String selectedAnswerId = onlineTechTestService
					.findExamDetail(userId, testName,techName, userSessionId, q).getSelectedAnswerId();
			question.setSelectedOption(selectedAnswerId);
			questionList.add(question);
		}
		//loading name of question set
		QuestionsForm questionsForm=new QuestionsForm();
		if(questionId.length()>0)
			 questionsForm=onlineTechTestService.findQuestionSetByQuestionId(questionId);
		
		 int totalAttemptedQuestions=0;
		 int totalUnAttemptedQuestions=0;
		 List<QuestionAndAnsTestDataVO> filterquestionList = new ArrayList<QuestionAndAnsTestDataVO>();
		 for(QuestionAndAnsTestDataVO questionAndAnsTestDataVO:questionList){
				    	   if(questionAndAnsTestDataVO.getSelectedOption()==null || (!questionAndAnsTestDataVO.getSelectedOption().equals(questionAndAnsTestDataVO.getCorrectOption()))){
				    		   if(questionAndAnsTestDataVO.getSelectedOption()==null ){
				    			   totalUnAttemptedQuestions++;
				    		   }else{
				    			   filterquestionList.add(questionAndAnsTestDataVO);
				    			   totalAttemptedQuestions++;
				    		   }
				    	   }
		 }
		
		model.addAttribute("questionList", questionList);
		model.addAttribute("totalUnAttemptedQuestions", totalUnAttemptedQuestions);
		model.addAttribute("totalAttemptedQuestions", totalAttemptedQuestions);
		model.addAttribute("testName", testName);
		model.addAttribute("qsetName", questionsForm.getQbankName());
		model.addAttribute("testConfiguration", testConfiguration.get(0));
		// List<UserOnlineExamStatusForm>
		// userOnlineExamStatusList=userService.findAllUserOnlineExamStatus(userId);
		// model.addAttribute("userOnlineExamStatusList",userOnlineExamStatusList);
		return CommonNavigationPage.COMMON_BASE + NavigationPage.EXAM_DETAIL;
	}

	@RequestMapping(value="user-test-summary",method=RequestMethod.GET)
	public String userTestSummary(Model model, HttpServletRequest request,HttpSession session){
		String userSessionId = request.getParameter("userSessionId");
	     UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
	     ConsultantsVO  consultantsVO=new ConsultantsVO();	     
	     GuestUserForm guestUserDetail=new GuestUserForm();
    	 consultantsVO=consultantAssesmentService.findConsultantByUserid(userId.getLoginId());
    	 guestUserDetail.setEmail(consultantsVO.getEmail());
    	 guestUserDetail.setMobile(consultantsVO.getMobile());
    	 guestUserDetail.setName(consultantsVO.getName());
    	  guestUserDetail.setUserid(userId.getLoginId());
	     model.addAttribute("guestUserDetail", guestUserDetail);
		UserOnlineExamStatusForm userOnlineExamStatus=userService.findUserOnlineExamStatusBySessionid(userId.getLoginId(), userSessionId);
        model.addAttribute("userOnlineExamStatusForm",userOnlineExamStatus);
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
        }
       	model.addAttribute("test_history_name", "examDetail");
       	return UserNavigationPage.USER_BASE + "guest-tech-test-history";
    }
	

	public String getUserRoleFromSession(HttpSession session) {
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId.getRole();
	}

}
