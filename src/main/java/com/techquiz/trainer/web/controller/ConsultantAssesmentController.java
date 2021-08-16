package com.techquiz.trainer.web.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synergisitic.it.email.service.IAttendanceEmailReminderService;
import com.synergisitic.it.email.service.ProfileCreationEmailSenderThread;
import com.synergisitic.it.email.service.UserEmailService;
import com.synergisitic.it.model.ChangePassword;
import com.synergisitic.it.model.User;
import com.synergisitic.it.navigation.AdminNavigationPage;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.ConsultantNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.TopicsService;
import com.synergisitic.it.service.Userervice;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.Technology;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserId;
import com.synergisitic.it.web.form.UserListInput;
import com.techquiz.programys.common.ApplicationRestStatusVO;
import com.techquiz.programys.common.service.IContentsService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.programys.common.vo.TopicVO;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantQuestionAnswerVO;
import com.techquiz.trainer.web.controller.vo.ConsultantScreeningInterviewVO;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;
import com.techquiz.trainer.web.controller.vo.CourseContentsDetailVO;
import com.techquiz.trainer.web.controller.vo.ScreeningInterviewRatingStatusVO;
import com.techquiz.trainer.web.controller.vo.TimeEditor;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

/**
 * 
 * @author Nagendra
 *
 */
@Controller
public class ConsultantAssesmentController {
	
	
	@Autowired
	@Qualifier("AttendanceEmailReminderService")
	private IAttendanceEmailReminderService attendanceEmailReminderService;
	
	@PostConstruct
	public void kuchhhbhi(){
		
	}
	
	@PreDestroy
	public void oowowowdestroy(){
		
	}
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("ContentsService")
	private IContentsService 	contentsService;


	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;

	@Autowired
	@Qualifier("TopicsServiceImpl")
	private TopicsService iTopicService;

	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;

	@Autowired
	@Qualifier("AdminServiceImpl")
	private AdminService adminService;

	@Autowired
	@Qualifier("UserEmailServiceImpl")
	private UserEmailService userEmailService;
	
	@Autowired
	private Userervice userService;
	
	

	@RequestMapping(value = "show-session-batch", method = RequestMethod.GET)
	public String showSessionBatch(Model model) {
		TrainingSessionsDetailVO trainingSessionsDetailVO = new TrainingSessionsDetailVO();
		model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVO);
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		if (batchList != null && batchList.size() > 0) {
			String currentBatch = batchList.get(batchList.size() - 1);
			model.addAttribute("currentBatch", currentBatch);
			List<ConsultantsVO> consultantsVOList = consultantAssesmentService
					.findConsultantsByBatch(currentBatch);
			model.addAttribute("consultantList", consultantsVOList);
		}
		model.addAttribute("batchList", batchList);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_SESSION_BATCH;
	}

	@RequestMapping(value = "add-session-detail", method = RequestMethod.POST)
	public String addSessionDetail(
			@ModelAttribute("trainingSessionsDetailVO") TrainingSessionsDetailVO trainingSessionsDetailVO,
			HttpSession session, Model model) {
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		trainingSessionsDetailVO.setUserid(userSession.getLoginId());
		trainingSessionsDetailVO
				.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		trainingSessionsDetailVO
				.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		consultantAssesmentService
				.saveTrainingSessionDetail(trainingSessionsDetailVO);
		trainingSessionsDetailVO = new TrainingSessionsDetailVO();
		model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVO);
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		model.addAttribute("ApplicationMessage",
				"Training Session detail has been saved successfully.............");
		model.addAttribute(
				ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.TRAINING_SESSION_DETAIL_HAS_BEEN_SAVED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE
				+ CommonNavigationPage.COMMON_SUCCESS_PAGE;
	}

	@RequestMapping(value = "consultant-screening-interview", method = RequestMethod.GET)
	public String showActiveBatch(Model model) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		model.addAttribute("nextAction", "startConsultantInterview");
		model.addAttribute("pageTitle", "Consultant Screening Interview");
		model.addAttribute("nextTitle", "Start");
		return ConsultantNavigationPage.TRAINER_BASE
				+ "consultant-screening-interview";
	}

	@RequestMapping(value = "addConsltant", method = RequestMethod.GET)
	public String addConsltant(Model model) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		// List<String> streamList=consultantAssesmentService.findAllStream();
		ConsultantsVO consultant = new ConsultantsVO();
		model.addAttribute("batchList", batchList);
		// model.addAttribute("streamList",streamList);
		model.addAttribute("consultant", consultant);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.ADD_CONSULTANT;
	}
	
	@RequestMapping(value = "consultant-profile", method = RequestMethod.GET)
	public String ushowEditPage(HttpSession session, Model model) {
		// logic to fetch data to be edited from db
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		ConsultantsVO consultantsVO = consultantAssesmentService.findConsultantByUserid(userSession.getLoginId());
		// model is type of hashMap
		consultantsVO.setPassword(userSession.getPassword());
		model.addAttribute("consultantsVO", consultantsVO);
		return UserNavigationPage.USER_BASE +"consultant-profile";
	}
	//hello
	// @ModelAttribute("changePassword") ChangePassword this line will bind
		// changePassword object with
		// method parameter of the the method updateChangePassword.
		@RequestMapping(value = "change-consultant-password", method = RequestMethod.POST)
		public String uupdateChangePassword(@ModelAttribute("changePassword") ChangePassword changePassword,RedirectAttributes attributes,
				HttpSession session, Model model) throws Exception {
			if (!changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
				// Error message new password and current password are not same
			} else {
				// Call Service here
				UserId userSession = (UserId) session
						.getAttribute(ApplicationContant.USER_SESSION_DATA);
				consultantAssesmentService.updateConsultantPasswordByUserid(userSession.getLoginId(),changePassword.getCurrentPassword());
				// Fetching UserId object from current session and setting new
				// password
				//
				userSession.setPassword(changePassword.getNewPassword());
			}
			attributes.addFlashAttribute("ApplicationMessage", "Your password has been updated successfully into the database.");
			return "redirect:/action/consultantHomePage";
		}
	
	@RequestMapping(value = "update-consultant-profile", method = RequestMethod.POST)
	public String updateConsultantProfilePost(@ModelAttribute ConsultantsVO consultantsVO,final RedirectAttributes attributes,HttpSession session, Model model) {
		// logic to fetch data to be edited from db
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		consultantsVO.setUserid(userSession.getLoginId());
		String result= consultantAssesmentService.updateConsultantByUserid(consultantsVO);
		// model is type of hashMap
		attributes.addFlashAttribute("ApplicationMessage", "Your profile has been updated successfully into the database.");
		return "redirect:/action/consultantHomePage";
	}
	
	
	@RequestMapping(value = "add-consultant-admin", method = RequestMethod.POST)
	public String registerConsultantByAdmin(
			@ModelAttribute("consultant") ConsultantsVO consultantsVO,HttpServletRequest request,
			HttpSession session, Model model) throws Exception {
		
		User user=userService.findUserByEmailId(consultantsVO.getEmail());
		if(user!=null && user.getEmail()!=null) {
			model.addAttribute(
					ApplicationMessageConstant.APPLICATION_MESSAGE,"Sorry , this email id is already registered, please contact to administrator.");
		
			List<String> batchList = consultantAssesmentService.findActiveBatches();
			// List<String> streamList=consultantAssesmentService.findAllStream();
			ConsultantsVO consultant = new ConsultantsVO();
			consultant.setGender("Male");
			model.addAttribute("batchList", batchList);
			// model.addAttribute("streamList",streamList);
			model.addAttribute("consultant", consultantsVO);
			return UserNavigationPage.TRAINER_BASE
					+ UserNavigationPage.ADD_CONSULTANT_PAGE;
		
		}
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		if(userSession!=null) {
			consultantsVO.setAdminid(userSession.getLoginId());	
		}else{
			consultantsVO.setAdminid("technohunk300@gmail.com");
		}
		
		consultantsVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		consultantsVO.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		consultantsVO.setDob(DateUtils.getCurrentTimeIntoTimestamp());
		consultantsVO.setActive(ApplicationContant.USER_ACTIVE_YES);
		consultantsVO.setRole(ApplicationContant.CONSULTANT_ROLE);
		//If it does not start with E then it is not a consultant...
		consultantsVO.setUserid(consultantsVO.getEmail());
		consultantsVO.setLockStatus("unlocked");
		// generating the default password and encrypting it...
	//	DESedeEncryption deSedeEncryption = new DESedeEncryption();
		// here we are setting password into user object after encrypting it
		/*consultantsVO.setPassword(deSedeEncryption
				.encrypt(ApplicationContant.DEFAULT_PASSWORD));*/
		consultantsVO.setPassword(ApplicationContant.DEFAULT_PASSWORD);
		consultantsVO.setEmpid("JH"+consultantsVO.getMobile());
		String result=consultantAssesmentService.addUserByAdmin(consultantsVO);
		
		/*new EmailSenderThread(
				userEmailService,
				consultantsVO.getEmail(),
				"Dear ,"
						+ consultantsVO.getName()
						+ "  <br/>Your have successfully registered  with us , your userid ="
						+ consultantsVO.getEmail() + " and password = "
						+ ApplicationContant.DEFAULT_PASSWORD,
				ApplicationMessageConstant.REGISTRATION_CONFIRMATION_MESSSGE)
				.start();*/
		String imageContextPath=DateUtils.getImageContextPath(request);
		consultantsVO.setPassword(ApplicationContant.DEFAULT_PASSWORD);
		
		//5 minutes
		Thread emailThread=new ProfileCreationEmailSenderThread(attendanceEmailReminderService, consultantsVO, imageContextPath);
		emailThread.start();
		
		model.addAttribute(
				ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.CONSULTANT_REGISTRATION_HAS_BEEN_DONE_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE
				+ CommonNavigationPage.PSUCCESS_STATUS_PAGE;
	}

	@RequestMapping(value = "addConsultant", method = RequestMethod.POST)
	public String registerConsultant(
			@ModelAttribute("consultant") ConsultantsVO consultantsVO,HttpServletRequest request,
			HttpSession session, Model model) throws Exception {
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		consultantsVO.setAdminid(userSession.getLoginId());
		consultantsVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		consultantsVO.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		consultantsVO.setDob(DateUtils.getCurrentTimeIntoTimestamp());
		consultantsVO.setActive(ApplicationContant.USER_ACTIVE_YES);
		consultantsVO.setRole(ApplicationContant.CONSULTANT_ROLE);
		//If it does not start with E then it is not a consultant...
		if(consultantsVO.getEmpid().startsWith("E") || consultantsVO.getEmpid().startsWith("e")) {
			consultantsVO.setUserid(consultantsVO.getEmail());
		}else {
			consultantsVO.setUserid(consultantsVO.getEmail());
		}
		consultantsVO.setLockStatus("unlocked");
		// generating the default password and encrypting it...
		//DESedeEncryption deSedeEncryption = new DESedeEncryption();
		// here we are setting password into user object after encrypting it
		/*consultantsVO.setPassword(deSedeEncryption
				.encrypt(ApplicationContant.DEFAULT_PASSWORD));*/
		consultantsVO.setPassword(ApplicationContant.DEFAULT_PASSWORD);
		String result=consultantAssesmentService.registerConsultant(consultantsVO);
		
		/*new EmailSenderThread(
				userEmailService,
				consultantsVO.getEmail(),
				"Dear ,"
						+ consultantsVO.getName()
						+ "  <br/>Your have successfully registered  with us , your userid ="
						+ consultantsVO.getEmail() + " and password = "
						+ ApplicationContant.DEFAULT_PASSWORD,
				ApplicationMessageConstant.REGISTRATION_CONFIRMATION_MESSSGE)
				.start();*/
		String imageContextPath=DateUtils.getImageContextPath(request);
		consultantsVO.setPassword(ApplicationContant.DEFAULT_PASSWORD);
		
		//5 minutes
		Thread emailThread=new ProfileCreationEmailSenderThread(attendanceEmailReminderService, consultantsVO, imageContextPath);
		emailThread.start();
		
		model.addAttribute(
				ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.CONSULTANT_REGISTRATION_HAS_BEEN_DONE_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE
				+ CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	
	@RequestMapping(value = "findAssignedTestByBatch", method = RequestMethod.GET)
	@ResponseBody
	public List<AssignedTestUserForm> findAssignedTestByBatch(@RequestParam("batchName") String groupName, Model model) {
		List<AssignedTestUserForm> assignedTestUserForms=onlineTechTestService.findAssignedTestByGroup(groupName);
		return assignedTestUserForms;
	}

	@RequestMapping(value = "findConsultantsByBatch", method = RequestMethod.GET)
	@ResponseBody
	public List<ConsultantsVO> showActiveBatch(
			@RequestParam("batchName") String batchName, Model model) {
		List<ConsultantsVO> consultantsVOList = consultantAssesmentService
				.findConsultantsByBatch(batchName);
		return consultantsVOList;
	}

	@RequestMapping(value = "startConsultantInterview", method = RequestMethod.GET)
	public String startConsultantInterview(
			@RequestParam("consultantId") String consultantId, Model model) {
		ConsultantsVO consultantsVO = consultantAssesmentService
				.findConsultantByUserid(consultantId);
		ConsultantQuestionAnswerVO consultantQuestionAnswerVO = new ConsultantQuestionAnswerVO();
		int totalQuestions = consultantAssesmentService
				.findTotalQuestionsByConsultantId(consultantId);
		model.addAttribute("consultantsVO", consultantsVO);
		model.addAttribute("totalQuestions", totalQuestions);
		model.addAttribute("consultantQuestionAnswerVO",
				consultantQuestionAnswerVO);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.START_CONSULTANT_INTERVIEW;
	}

	@RequestMapping(value = "startConsultantInterview", method = RequestMethod.POST)
	@ResponseBody
	public ApplicationMessageResponse startConsultantInterviewSumit(
			@RequestBody ConsultantQuestionAnswerVO consultantQuestionAnswerVO,
			HttpSession session, Model model) {
		System.out.println("_________OM_________");
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		consultantQuestionAnswerVO.setAdminid(userSession.getLoginId());
		consultantQuestionAnswerVO.setDoe(DateUtils
				.getCurrentTimeIntoTimestamp());
		consultantQuestionAnswerVO.setDom(DateUtils
				.getCurrentTimeIntoTimestamp());
		String message = consultantAssesmentService
				.persistConsultantScreeningInterview(consultantQuestionAnswerVO);
		System.out.println(consultantQuestionAnswerVO);
		ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(message);
		applicationMessageResponse
				.setMessage(ApplicationMessageConstant.INTERVIEW_QUESTION_ANSWER_HAS_BEEN_SAVED_SUCCESSFULLY_MESSAGE);
		applicationMessageResponse.setStatus(String.valueOf(200));
		applicationMessageResponse.setErrorDescription("NA");
		return applicationMessageResponse;
	}

	@RequestMapping(value = "submitConsultantInterview", method = RequestMethod.POST)
	public String submitConsultantInterviewSumit(
			@RequestBody ConsultantQuestionAnswerVO consultantQuestionAnswerVO,
			HttpSession session, Model model) {
		System.out.println("_________OM_________");
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		consultantQuestionAnswerVO.setAdminid(userSession.getLoginId());
		consultantQuestionAnswerVO.setDoe(DateUtils
				.getCurrentTimeIntoTimestamp());
		consultantQuestionAnswerVO.setDom(DateUtils
				.getCurrentTimeIntoTimestamp());
		String message = consultantAssesmentService
				.submitConsultantScreeningInterview(consultantQuestionAnswerVO);
		System.out.println(consultantQuestionAnswerVO);
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		model.addAttribute(
				"ApplicationMessage",
				ApplicationMessageConstant.THANKS_FOR_SUBMITTING_SCREENING_INTERVIEW_REPORT);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_CONSULTANT_BATCH;
	}

	@RequestMapping(value = "findTopicsByLanguage", method = RequestMethod.GET)
	@ResponseBody public List<TopicVO> startConsultantInterview(
			@RequestParam("language") String languageId) {
		List<TopicVO> topicVOs = iTopicService
				.findTopicsByLanguageId(languageId);
		return topicVOs;
	}
	

	@ModelAttribute("questionComplexityList")
	public List<String> questionComplexityList() {
		// Data referencing for web framework combo
		List<String> questionComplexityList = new ArrayList<String>();
		questionComplexityList.add("LOWER");
		questionComplexityList.add("MEDIUM");
		questionComplexityList.add("HIGH");
		return questionComplexityList;
	}

	@ModelAttribute("technologyList")
	public Map<String, String> technologyList() {
		// Data referencing for web framework combo
		List<Technology> technologies = technolgyCategoryService
				.findAllTechnolgy();
		Map<String, String> technologiesMap = new LinkedHashMap<String, String>();
		for (Technology technology : technologies) {
			technologiesMap.put(technology.getId() + "", technology.getTname());
		}
		return technologiesMap;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		// it will convert byte stream into array of bytes
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(Time.class, new TimeEditor());
	}

	@RequestMapping(value = "viewScreeningInterviewStatus", method = RequestMethod.GET)
	public String viewScreeningInterviewStatus(
			@RequestParam("consultantId") String consultantId,
			@RequestParam("interviewId") String interviewId, Model model) {
		List<ScreeningInterviewRatingStatusVO> interviewRatingStatusVOs = consultantAssesmentService
				.findScreeningInterviewStatusDetail(consultantId, interviewId);
		ConsultantsVO consultantsVO = consultantAssesmentService
				.findConsultantByUserid(consultantId);
		ConsultantQuestionAnswerVO consultantQuestionAnswerVO = new ConsultantQuestionAnswerVO();
		int totalQuestions = consultantAssesmentService
				.findTotalQuestionsFromHistoryByConsultantId(consultantId,
						interviewId);
		model.addAttribute("consultantsVO", consultantsVO);
		model.addAttribute("interviewRatingStatusVOs", interviewRatingStatusVOs);
		model.addAttribute("totalQuestions", totalQuestions);
		model.addAttribute("consultantQuestionAnswerVO",
				consultantQuestionAnswerVO);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.VIEW_SCREENING_INTERVIEW_STATUS;
	}

	@RequestMapping(value = "select-interviewed-batch", method = RequestMethod.GET)
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
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_CONSULTANT_BATCH;
	}

	@RequestMapping(value = "show-technology-progress", method = RequestMethod.GET)
	public String findTechnologyStatus(Model model, HttpSession session) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		
		
		//edited by chaitrali
		/*
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		System.out.println("*************************************USERID*****************::: "+userId);
		String loginid= userId.getLoginId();
		TechnologyEntity technologyEntity = consultantAssesmentService.findTechNameByLoginId(loginid);
		String tname = technologyEntity.getTname();
		model.addAttribute("tname", tname);
		*/
		
		model.addAttribute("batchList", batchList);
		// List<String>
		// batchList=consultantAssesmentService.findActiveBatches();
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_TECHNOLOGIES_PROGRESS;
	}

	@RequestMapping(value = "find-consultant-detail", method = RequestMethod.GET)
	public String findConsultantDetail(
			@RequestParam("consultantId") String consultantId,
			@RequestParam("empid") String empid, Model model) {

		ConsultantsVO consultantsVO = consultantAssesmentService
				.findConsultantByUserid(consultantId);
		
		List<TrainingSessionsDetailVO> trainingSessionsDetailVOList = consultantAssesmentService
				.findConsultantTechnologyStatusBy(empid);
		
		List<String> techNameList = new ArrayList<>();
		
		for(TrainingSessionsDetailVO trainingSessionsList : trainingSessionsDetailVOList)
		{
			techNameList.add(trainingSessionsList.getTechName());
		}
	
		
		
	// AssignedTestUserForm assignedTestUserForm = consultantAssesmentService.findConsultantTestInfoByUserId(consultantsVO.getEmail());
	    int totalDuration=0;
		for(TrainingSessionsDetailVO trainingSessionsDetailVO : trainingSessionsDetailVOList) {
			totalDuration=totalDuration+Integer.parseInt(trainingSessionsDetailVO.getTimeduration());
		}
		
		int noOfHrs=totalDuration/60;
		int noOfMins=totalDuration%60;
		int noOfDays = noOfMins%(60*24);
		String formatedDuration=noOfHrs+" (Hrs) : "+noOfMins+" (Mins)";
		model.addAttribute("noOfDays",noOfDays);
		model.addAttribute("formatedDuration", formatedDuration);
		model.addAttribute("consultantsVO", consultantsVO);
		model.addAttribute("techNameList", techNameList);
		model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVOList);
		//model.addAttribute("assignedTestUserForm", assignedTestUserForm);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_TECHNOLOGY_PROGRESS_DETAIL;
	}

	@RequestMapping(value = "addSessionDetail", method = RequestMethod.GET)
	public String addSessionDetail() {
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.ADD_SESSION_DETAIL;
	}

	@RequestMapping(value = "select-screening-interview", method = RequestMethod.GET)
	public String showScreeningInterview(
			@RequestParam("consultantId") String consultantId, Model model) {
		ConsultantsVO consultantsVO = consultantAssesmentService
				.findConsultantByUserid(consultantId);
		List<ConsultantScreeningInterviewVO> consultantScreeningInterviewVOs = consultantAssesmentService
				.findScreeningInterviewsByConsultantUserid(consultantId);
		model.addAttribute("consultantScreeningInterviewVOs",
				consultantScreeningInterviewVOs);
		model.addAttribute("nextAction", "viewScreeningInterviewStatus");
		model.addAttribute("consultantsVO", consultantsVO);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SELECT_SCREENING_INTERVIEW;
	}

	@RequestMapping(value = "sendCosultantTestLink", method = RequestMethod.GET)
	public String sendExamLink(Model model) {
		// Fetch data for all users.
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		String sbatchName = "";
		if (batchList != null && batchList.size() > 0) {
			sbatchName = batchList.get(batchList.size() - 1);
		}
		List<UserForm> users = consultantAssesmentService
				.findConsultantByBatch(sbatchName);
		// model is type of hashMap
		model.addAttribute("users", users);
		model.addAttribute("dgname", sbatchName);
		model.addAttribute("selectedGroupName", sbatchName);

		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		List<TestConfiguration> availableTestList = onlineTechTestService
				.findAllAvailableTest();
		List<String> testNames = new ArrayList<String>();
		for (TestConfiguration c : availableTestList)
			testNames.add(c.getTestName());
		model.addAttribute("testNames", testNames);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return AdminNavigationPage.ADMIN_BASE + NavigationPage.SEND_EXAM_LINK;
	}

	@RequestMapping(value = "load-consultant-batch-testName", method = RequestMethod.GET)
	public @ResponseBody
	List<UserForm> loadConsultantByBatchTestName(
			@RequestParam("batch") String batchName) {

		List<UserForm> consultantList = consultantAssesmentService
				.findConsultantByBatch(batchName);
		return consultantList;
	}

	@RequestMapping(value = "reset-consultant-test", method = RequestMethod.GET)
	public String resetConsultantTest(Model model) {

		List<TestConfiguration> testConfigurationsList = adminService
				.findAllAvailableOnlineTests();
		model.addAttribute("testConfigurationsList", testConfigurationsList);

		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.RESET_CONSULTANT_TEST;
	}

	@RequestMapping(value = "show-consultants-to-reset-test", method = RequestMethod.GET)
	public String showconsultantstoresettest(
			@RequestParam(value="testName",required=false) String testName, Model model,
			HttpSession session) {

		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String tid = userSession.getLoginId();
		List<AssignedTestUserForm> consultantList = consultantAssesmentService
				.findConsultantByTrainerIdTestName(tid, testName);
		model.addAttribute("consultantList", consultantList);
		model.addAttribute("testName", testName);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_CONSULTANTS_TO_RESET_TEST;
	}

	@RequestMapping(value = "updateConsultantExamStatus", method = RequestMethod.GET)
	public @ResponseBody
	ApplicationRestStatusVO updateConsultantExamStatus(
			@RequestParam("techName") String techName,
			@RequestParam("userId") String userId) {

		adminService.resetUserTest(techName, userId);
		ApplicationRestStatusVO aprs = new ApplicationRestStatusVO();
		String msg = "Succesfully test updated for " + userId;
		aprs.setStatus(ApplicationContant.SUCCESS);
		aprs.setMassage(msg);
		return aprs;
	}

	// Display All User Page
	@RequestMapping(value = "showAllConsultants", method = RequestMethod.GET)
	public String showAllConsultants(Model model) {
		UserListInput userListInput = new UserListInput();
		userListInput.setSelectedGroupName("Users");
		// Fetch data for all users.
		List<ConsultantsVO> consultantsVOs = consultantAssesmentService
				.findAllConsultants();
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
		return AdminNavigationPage.ADMIN_BASE
				+ AdminNavigationPage.SHOW_ALL_USERS_PAGE;
	}

	@RequestMapping(value = "/find-user-userId-or-Name", method = RequestMethod.GET)
	public @ResponseBody
	List<AssignedTestUserForm> findUsersByNameOrByuserId(
			@RequestParam(value = "userIdOrName") String userIdOrName,
			@RequestParam(value = "testName") String testName) {
		List<AssignedTestUserForm> usersList = adminService.findUsersByName(
				userIdOrName, testName);
		return usersList;
	}

	@RequestMapping(value = "add-contents-course-detail", method = RequestMethod.GET)
	public String addConsultantCourseDetail(Model model) {
		Map<Integer, String> languageList = consultantAssesmentService
				.findAllLanguages();
		List<String> courseList = consultantAssesmentService.findAvailableCourses();
		CourseContentsDetailVO courseContentsDetailVO = new CourseContentsDetailVO();
		model.addAttribute("courseContentsDetailVO", courseContentsDetailVO);
		model.addAttribute("languageList", languageList);
		model.addAttribute("courseList", courseList);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.ADD_CONTENTS_COURSE_DETAIL;

	}
	
	@RequestMapping(value = "add-contents-course-detail", method = RequestMethod.POST)
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
	
	@RequestMapping(value="add-topics-detail", method = RequestMethod.GET)
	public String addTopicsDetail(Model model)
	{
		Map<String, String> topicList=consultantAssesmentService.fetchAllTopics();
		model.addAttribute("topicList", topicList);
		
		return null;
		
	}
	
	@RequestMapping(value = "submitQuery", method = RequestMethod.GET)
	public String submitQuery(Model model) {
		Map<Integer, String> languageList = consultantAssesmentService
				.findAllLanguages();
		List<String> courseList = consultantAssesmentService.findAvailableCourses();
		CourseContentsDetailVO courseContentsDetailVO = new CourseContentsDetailVO();
		model.addAttribute("courseContentsDetailVO", courseContentsDetailVO);
		model.addAttribute("languageList", languageList);
		model.addAttribute("courseList", courseList);
		return ConsultantNavigationPage.CONSULTANT_BASE
				+ ConsultantNavigationPage.CONSULTANT_SUBMIT_QUERY;

	}
	
	@RequestMapping(value="consultant-course-coverd-status", method = RequestMethod.GET)
	public String consultantCourseCoverdStatus(Model model)
	{
		Map<String, String> batchMap = consultantAssesmentService
				.findActiveBatchesAsMap();
		model.addAttribute("batchMap", batchMap);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.CONSULTANT_COURSE_COVERD_STATUS;
		
	}
	
	
	@RequestMapping(value = "add-session-batch", method = RequestMethod.GET)
	public String addSessionBatch(Model model) {
		TrainingSessionsDetailVO trainingSessionsDetailVO = new TrainingSessionsDetailVO();
		model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVO);
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		if (batchList != null && batchList.size() > 0) {
			String currentBatch = batchList.get(batchList.size() - 1);
			model.addAttribute("currentBatch", currentBatch);
			List<ConsultantsVO> consultantsVOList = consultantAssesmentService
					.findConsultantsByBatch(currentBatch);
			model.addAttribute("consultantList", consultantsVOList);
		}
		String currentDate=DateUtils.getCurrentDateDefaultFormat();
		model.addAttribute("currentDate", currentDate);
		model.addAttribute("batchList", batchList);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.ADD_SESSION_BATCH_PAGE;
	}
	
	
	
//	@RequestMapping(value = "findConsultantCourseCoverd", method = RequestMethod.GET)
//	public String findConsultantCourseCoverd(@RequestParam("course") String courseId, Model model, HttpSession session)
//	{
//		UserId userSession = (UserId) session
//				.getAttribute(ApplicationContant.USER_SESSION_DATA);
//		String topicid = userSession.getLoginId();
//	List<CourseContentsDetailVO> courseContentsDetailVO=consultantAssesmentService.findAllCoverdTopics(topicid,courseId);
//		return ConsultantNavigationPage.TRAINER_BASE
//				+ ConsultantNavigationPage.CONSULTANT_COURSE_COVERD_STATUS;
//		
//		
//	}

}
