package com.synergisitic.it.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.email.service.GuestEmailService;
import com.synergisitic.it.email.service.IAttendanceEmailReminderService;
import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.report.model.OCJPReportCard;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.GuestUserService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.util.UniqueLinkGenaratorUtil;
import com.synergisitic.it.util.VerifyRecaptcha;
import com.synergisitic.it.web.form.GuestUserForm;
import com.synergisitic.it.web.form.GuestUserFromComparator;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.UserExamProgressDataVO;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserId;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.control.panel.controller.model.AppSettingsVO;
import com.techquiz.control.panel.service.AppSettingsService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.trainer.service.IConsultantAssesmentService;

@Controller
public class GuestUserController {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(GuestUserController.class);
	

	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	
	@Autowired
	@Qualifier("AdminServiceImpl")
	private AdminService adminService;
	
	@Autowired
	@Qualifier("GuestUserServiceImpl")
	private GuestUserService guestUserService;
	
	@Autowired
	@Qualifier("GuestEmailServiceImpl")
	private GuestEmailService guestEmailService;
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("AttendanceEmailReminderService")
	private IAttendanceEmailReminderService attendanceEmailReminderService;
	
	
	@GetMapping(value="/update-guest-name")
	@ResponseBody public ApplicationMessageResponse UpdateGuestName(@RequestParam(value="name",required=false) String name,@RequestParam("salutation") String salutation,
			HttpSession session) throws IOException{
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String emailid=userId.getLoginId();
		GuestUserForm guestUserForm=new GuestUserForm();
		userId.setName(name);
		guestUserForm.setEmail(emailid);
		guestUserForm.setGid(userId.getId());
		guestUserForm.setName(name);
		if("1".equals(salutation)){
			guestUserForm.setGender("Male");
			userId.setSalutation("Mr.");
		}else{
			guestUserForm.setGender("Female");
			userId.setSalutation("Ms.");
		}
		String status=guestUserService.updateGuestNameSalutation(guestUserForm);
		ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setMessage("Name ,Email and salutation are updated successfully into the database.");
	   return applicationMessageResponse;
	}
	
	
	@Autowired
	@Qualifier("AppSettingsServiceImpl")
	private AppSettingsService appSettingsService;
	
	
	@PostMapping(value="/send-test-link")
	@ResponseBody public ApplicationMessageResponse sendTestLinkToUser(@RequestParam(value="tduration",required=false) String tduration,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("techName") String techName,@RequestParam("testName") String testName,HttpServletRequest request,HttpSession session) throws IOException{
		    ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
		    GuestUserForm userForm = guestUserService.findGuestByEmailId(email);
			userForm.setTestName(testName);
			userForm.setTechName(techName);
		    if (userForm.getEmail()==null || !userForm.getEmail().equals(email)) {
				userForm.setGender("NA");
				userForm.setLocation("NA");
				userForm.setMobile("510-500-4505");
				userForm.setName(name);
				userForm.setOccupation("NA");
				userForm.setEmail(email);
				userForm.setUserid(email);
				UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
				//Bug fix @ 29-06-2018 which was not setting the login id of the sender 
				userForm.setAdminid(userId.getLoginId());
		   	}
				// Creating the test link..........
				final String TEST_LINK_URL = "action/tech-test/start?tuid=";
				String baseURL = DateUtils.getServerBaseURL(request) + "/"	+ TEST_LINK_URL;
				String cuid = UniqueLinkGenaratorUtil.findUniqueCuid();
				String generatedTestLink = baseURL + cuid;
				userForm.setGeneratedTestLink(TEST_LINK_URL + cuid);
				userForm.setTestStatus(ApplicationContant.NOT_STARTED);
				Timestamp currentTime = new Timestamp(new Date().getTime());
				Calendar c = Calendar.getInstance();
				c.setTime(currentTime);
				AppSettingsVO appSettingsVO=appSettingsService.findAppDefaultSettings(1);
				if(appSettingsVO.getIid()==0) {
					c.add(Calendar.HOUR, 48);
				}else{
					c.add(Calendar.HOUR, appSettingsVO.getGuestTextExpireTimeInHrs());
				}
				Date ExpirationDate = c.getTime();
				Timestamp linkexpdate = new Timestamp(ExpirationDate.getTime());
				userForm.setExpiryDate(linkexpdate);
				//Resetting the entity javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist: com.synergisitic.it.model.GuestUserEntity
				//Updating the doe...........
				//@Bug fixed where doe for all the test for one user was showing the same!
				userForm.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
				userForm.setGid(0);
				if(tduration!=null)
				userForm.setTduration(tduration);
				String response = guestUserService.addGuestUser(userForm);
				userForm.setGeneratedTestLink(generatedTestLink);
				guestEmailService.sendTechTestEmailAsLink(userForm,DateUtils.getServerBaseURL(request));
				System.out.println("generatedTestLink  = "+generatedTestLink);	
				// Write code to send email here
				applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
				applicationMessageResponse.setMessage("Hello  "+ userForm.getEmail()
								+ " one test link has been sent to your email id , please use the same to start your test.");
			return applicationMessageResponse;
		}
	
	
	@RequestMapping(value = "guest-test-performance-report", method = RequestMethod.GET)
	public String guestTestPerformanceReport() {
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.GUEST_TEST_PERFORMANCE_REPORT;
	}
	
	@RequestMapping(value = "guest-test-search-reset-history", method = RequestMethod.GET)
	public String guestSerachResetTestHistory() {
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.GUEST_TEST_SEARCH_RESET_HISTORY;
	}
	

	@RequestMapping(value = "delete-guest-user-test-link", method = RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse deleteGuestUserTestLink(@RequestParam("gid") long gid,@RequestParam("userid") String userid,HttpSession session) {
		String status=guestUserService.deleteGuestUserTestLink(userid, gid);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(status);
		applicationMessageResponse.setMessage("Test link has been delete successfully for the guest user "+userid);
		return applicationMessageResponse;
	}
	
	@RequestMapping(value = "reset-guest-user-test", method = RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse resetGuestUserTest(@RequestParam("withHistoryStatus") String withHistoryStatus,@RequestParam("userid") String userid,@RequestParam(value="userSessionId",required=false) String userSessionId,HttpSession session) {
		boolean withHistory=false;
		if("yes".equalsIgnoreCase(withHistoryStatus)){
			withHistory=true;
		}
		
		String status=guestUserService.resetGuestUserTest(userid,userSessionId,withHistory);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(status);
		applicationMessageResponse.setMessage("Test has been reset successfully for the guest user "+userid);
		return applicationMessageResponse;
	}
	
	@RequestMapping(value = "manage-guest-user", method = RequestMethod.GET)
	public String manageRegisteredUser(Model model,HttpSession session) {
		List<String> batchList=new ArrayList<String>();
		batchList.add("guest");
		model.addAttribute("dgname",batchList );
		model.addAttribute("selectedGroupName", "guest");
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.MANAGE_GUEST_USER__PAGE;
	}
	
	@RequestMapping(value = "pending-test-guest-user", method = RequestMethod.GET)
	public String pendingTestGuestUser(Model model,HttpSession session) {
		List<String> batchList=new ArrayList<String>();
		batchList.add("guest");
		model.addAttribute("dgname",batchList );
		model.addAttribute("selectedGroupName", "guest");
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.PENDING_TEST_GUEST_USER_PAGE;
	}
	
	@RequestMapping(value = "find-guest-users", method = RequestMethod.GET)
	public @ResponseBody  List<GuestUserForm> findGuestUsers(Model model,HttpSession session) {
		List<GuestUserForm> guestUserFormsList=guestUserService.findGuestUser();
		//model.addAttribute("guestUserFormsList", guestUserFormsList);
		//return UserNavigationPage.TRAINER_BASE + UserNavigationPage.MANAGE_GUEST_USER__PAGE;
		return guestUserFormsList;
	}
	
	@RequestMapping(value = "find-guest-pending-tests", method = RequestMethod.GET)
	public @ResponseBody  List<GuestUserForm> findGuestPendingTestUsers(@RequestParam(value="email",required=false) String email,Model model,HttpSession session) {
		List<GuestUserForm> guestUserFormsList=new ArrayList<GuestUserForm>(); 
		 if(email==null || email.trim().length()==0){
			guestUserFormsList=guestUserService.findPendingGuestUserTests();
		 }else{
			 guestUserFormsList=guestUserService.findPendingGuestUserTests(email);
		 }
		 if(guestUserFormsList!=null){
			 Collections.sort(guestUserFormsList,new GuestUserFromComparator());
		 }
		 //model.addAttribute("guestUserFormsList", guestUserFormsList);
		 //return UserNavigationPage.TRAINER_BASE + UserNavigationPage.MANAGE_GUEST_USER__PAGE;
		 return guestUserFormsList;
	}
	
	/*
	 * A simple renderer for setting custom colors for a pie chart.
	 */

	public static class PieRenderer {
		private Color[] color;

		public PieRenderer(Color[] color) {
			this.color = color;
		}

		public void setColor(PiePlot plot, DefaultPieDataset dataset) {
			List<Comparable> keys = dataset.getKeys();
			int aInt;

			for (int i = 0; i < keys.size(); i++) {
				aInt = i % this.color.length;
				plot.setSectionPaint(keys.get(i), this.color[aInt]);
			}
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@RequestMapping("tdchart")
	public void showPieChart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/png");
		ServletOutputStream os = response.getOutputStream();
		String userid=request.getParameter("userid");
		String userSessionId=request.getParameter("userSessionId");
		UserOnlineExamStatusForm userOnlineExamStatusForm = userService.findUserOnlineExamStatusBySessionid(userid, userSessionId);
		 //this is bug...... where it was picking always last 
		//List<UserOnlineExamStatusForm> userOnlineExamStatusList = userService.findAllUserOnlineExamStatus(userid);
		/*UserOnlineExamStatusForm userOnlineExamStatusForm;
		if(userOnlineExamStatusList!=null && userOnlineExamStatusList.size()>0){
			userOnlineExamStatusForm =userOnlineExamStatusList.get(0);
		}else{
			userOnlineExamStatusForm=new UserOnlineExamStatusForm();
		}*/
	  final DefaultPieDataset dataset = new DefaultPieDataset();
	    if(userOnlineExamStatusForm.getTotalCorrectAnswer()>0)
	    dataset.setValue("Correct Questions", new Double(userOnlineExamStatusForm.getTotalCorrectAnswer()));
	    else
	    	dataset.setValue("Correct Questions",0);
	    if(userOnlineExamStatusForm.getTotalWrongAnswer()>0)
	    dataset.setValue("Wrong Questions", new Double(userOnlineExamStatusForm.getTotalWrongAnswer()));
	    else
	    	dataset.setValue("Wrong Questions", 0);
	    
		int naq=userOnlineExamStatusForm.getTotalNoQuestion()-(userOnlineExamStatusForm.getTotalCorrectAnswer()+userOnlineExamStatusForm.getTotalWrongAnswer());
	    if(naq >0)
	    dataset.setValue("Not Attempted Questions", new Double(naq));
	    
        final JFreeChart chart = ChartFactory.createPieChart3D(
                "",  // chart title
                dataset,                // data
                true,                   // include legend
                true,
                false
            );
        
        	chart.getTitle().setPaint(Color.darkGray);
        	LegendTitle legend = chart.getLegend();
        	Font labelFont = new Font("Arial", Font.PLAIN, 16);
        	legend.setItemFont(labelFont);
        	legend.setBorder(0, 0, 0, 0); 
        	legend.setPadding(0,0, 0,50);
        	legend.setWidth(400);
            final PiePlot3D plot = (PiePlot3D) chart.getPlot();
            Font font = new Font("vardana", Font.BOLD, 18);
    		TextTitle title = chart.getTitle();
    		title.setFont(font);
    		plot.setOutlineVisible(false);
    		plot.setBackgroundPaint(new Color(249, 249, 249));
    		Font font1 = new Font("", Font.PLAIN, 16);
    		plot.setLabelFont(font1);
            // Specify the colors here 
            Color[] colors = {Color.green, Color.red, Color.pink}; 
            PieRenderer renderer = new PieRenderer(colors); 
            renderer.setColor(plot, dataset); 
            plot.setStartAngle(90);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            plot.setNoDataMessage("No data to display");
            
		RenderedImage chartImage = chart.createBufferedImage(640, 330);
		new Date().getTime();
		ImageIO.write(chartImage, "png", os);
		os.flush();
		os.close();
	}
	
	@PostMapping(value="/test-result-summary")
	 public String  testResultSummaryPage(@RequestParam("email") String email,Model model){
		   
		return UserNavigationPage.USER_BASE+UserNavigationPage.TEST_RESULT_SUMMARY_PAGE;
	}	
	
	
	@PostMapping(value="/add-guest-user")
	@ResponseBody public ApplicationMessageResponse addGuestUser(@ModelAttribute GuestUserForm guestUserForm,HttpServletRequest request) throws IOException{
		   ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
			//Verify the captcha
			String gRecaptchaResponse = request
				.getParameter("g-recaptcha-response");
			System.out.println(gRecaptchaResponse);
			if(gRecaptchaResponse==null || gRecaptchaResponse.trim().length()==0){
				// forward to error page as guest email id is already used for java test
				applicationMessageResponse.setStatus(ApplicationContant.FAIL);
				applicationMessageResponse.setMessage("Captcha validation is required.");
				return applicationMessageResponse;
			}else {
				boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
				if (verify==false) {
						// forward to error page as guest email id is already used for java test
						applicationMessageResponse.setStatus(ApplicationContant.FAIL);
						applicationMessageResponse.setMessage("Invalid Captcha , please contact to site administrator.");
						return applicationMessageResponse;
				} 
			}
			GuestUserForm userForm = guestUserService.findGuestByEmailId(guestUserForm.getEmail());
			AppSettingsVO appSettingsVO=appSettingsService.findAppDefaultSettings(1);
			if (userForm.getEmail()==null || !userForm.getEmail().equals(guestUserForm.getEmail()) || (appSettingsVO.getAllowGuestMultipleTest()!=null && appSettingsVO.getAllowGuestMultipleTest().equalsIgnoreCase(ApplicationContant.YES_STATUS))) {
				 AvailableGuestTest davailableGuestTest=guestUserService.findCurrentActiveGuestTechTest();
			    String	techName=davailableGuestTest.getTechName();
				String testName=davailableGuestTest.getTestName();
				guestUserForm.setTestName(testName);
				guestUserForm.setTechName(techName);
				guestUserForm.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
				guestUserForm.setAdminid("admin");
				// Creating the test link..........
				final String TEST_LINK_URL = "action/tech-test/start?tuid=";
				String baseURL = DateUtils.getServerBaseURL(request) + "/"	+ TEST_LINK_URL;
				String cuid = UniqueLinkGenaratorUtil.findUniqueCuid();
				String generatedTestLink = baseURL + cuid;
				guestUserForm.setGeneratedTestLink(TEST_LINK_URL + cuid);
				guestUserForm.setTestStatus(ApplicationContant.NOT_STARTED);
				Timestamp currentTime = new Timestamp(new Date().getTime());
				Calendar c = Calendar.getInstance();
				c.setTime(currentTime);
				c.add(Calendar.HOUR, 48);
				Date ExpirationDate = c.getTime();
				Timestamp linkexpdate = new Timestamp(ExpirationDate.getTime());
				guestUserForm.setExpiryDate(linkexpdate);
				String response = guestUserService.addGuestUser(guestUserForm);
				guestUserForm.setGeneratedTestLink(generatedTestLink);
				guestEmailService.sendTechTestEmailAsLink(guestUserForm,DateUtils.getServerBaseURL(request));
				System.out.println("generatedTestLink  = "+generatedTestLink);	
				// Write code to send email here
				applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
				applicationMessageResponse.setMessage("Hello Mr. "+ guestUserForm.getName()
								+ " one test link has been sent to your email id , please use the same to start your test.");
			} else {
				// forward to error page as guest email id is already used for java test
				applicationMessageResponse.setStatus(ApplicationContant.FAIL);
				applicationMessageResponse.setMessage("Hello Mr. "+ guestUserForm.getName()
								+ ", This email id is already registered for the test  ,please try with another email id.");
			}
			return applicationMessageResponse;
		}
	
	/**
	 * 
	 * @param tuid
	 * @return
	 */
	@GetMapping(value="/tech-test/start")
	 public String startTestUsingLink(@RequestParam("tuid") String tuid,HttpSession session,Model model) {
		  //if this is guest user
		String testLink="action/tech-test/start?tuid="+tuid;
		GuestUserForm guestUserForm=guestUserService.findGuestByGeneratedTestLink(testLink);
		model.addAttribute("guestUserForm",guestUserForm);
		if(guestUserForm.getGid()==0){
			//forward to the error page
			 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
						ApplicationMessageConstant.SORRY_THIS_LINK_IS_NOT_VALID_FOR_TEST);
		  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
		}else if("COMPLETED".equalsIgnoreCase(guestUserForm.getTestStatus())){
			 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
						ApplicationMessageConstant.SORRY_YOU_HAVE_ALREADY_GIVEN_TEST);
		  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
		}else if(ApplicationContant.NOT_STARTED.equalsIgnoreCase(guestUserForm.getTestStatus())) {
		
			//Testing either link is expired or not
			//Write logic to check ////
			 Timestamp expdate=guestUserForm.getExpiryDate();
			 long expdateLong=expdate.getTime();
		     Date cuDate=new Date();
		    long computeDateTime=cuDate.getTime();
		    if(computeDateTime>expdateLong) {
		   	 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
						ApplicationMessageConstant.SORRY_YOUR_TEST_LINK_HAS_BEEN_EXPIRED);
		  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
		    }
			
			createSession(session,guestUserForm,"home.jsp");
			//Default test 
			String techName="Core-Java";
			String testName="JAVA_BASIC";
			if(guestUserForm.getTechName()!=null && guestUserForm.getTechName().length()>0) {
				techName=guestUserForm.getTechName();
				testName=guestUserForm.getTestName();
			}
			else {
				    //this code will not execute just written for backward compatibility
				    AvailableGuestTest davailableGuestTest=guestUserService.findCurrentActiveGuestTechTest();
			    	techName=davailableGuestTest.getTechName();
				    testName=davailableGuestTest.getTestName();
			}
			//session.setAttribute("SpecialRole",ApplicationContant);
			//Here we have to write logic to fetch test details 
			  session.setAttribute("userSessionId", "UT"+new Date().getTime());
			  session.setAttribute("testLink", testLink);
			  AvailableTest availableTest=guestUserService.loadTestDetailsByTechTest(techName,testName);
			  AvailableGuestTest availableGuestTest=new AvailableGuestTest();
			  BeanUtils.copyProperties(availableTest, availableGuestTest);
			  
			  //overriding the testDuration for guest user as per configured time at the time of sending the link to the guest user
			  try {
						  if(guestUserForm.getTduration()!=null && guestUserForm.getTduration().length()>0){
							  availableGuestTest.setTestDuration(Integer.parseInt(guestUserForm.getTduration()));
						  }
			  }catch(Exception ex){
				   System.err.println(ex.getMessage());
			  }
			  
			  StringBuilder loadedQuestionIds=new StringBuilder();
			   try {
				   loadedQuestionIds= prepareTestData(session,availableGuestTest,testName);
		  	  }catch(Exception ex){
		  		  ex.printStackTrace();
		  		  model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
						ApplicationMessageConstant.SORRY_THERE_IS_SOME_PROBLEM_WITH_TEST);
		  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
		  	  }
			   pushTestProgressData(session,loadedQuestionIds,testName,techName);
			   model.addAttribute("availableTest", availableGuestTest);
			   session.setAttribute("utestName", testName);
			   session.setAttribute("utechName", techName);
			   return UserNavigationPage.USER_BASE+UserNavigationPage.WELCOME_TEST_PAGE;
			
		}	
		else {
				 Timestamp expdate=guestUserForm.getExpiryDate();
				 long expdateLong=expdate.getTime();
			     Date cuDate=new Date();
			    long computeDateTime=cuDate.getTime();
			    if(computeDateTime>expdateLong){
			   	 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
							ApplicationMessageConstant.SORRY_YOUR_TEST_LINK_HAS_BEEN_EXPIRED);
			  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
			    }else{
			    	  model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
								ApplicationMessageConstant.SORRY_THERE_IS_SOME_PROBLEM_WITH_TEST);
				  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
			    }
		}
		
	
	}
	//http://ddddddddddd.com/action/load-tech-test?testName=cs-3rd-type-cons-test&techName=.Net
	
	/**
	 * 
	 * @return
	 */
	private StringBuilder prepareTestData(HttpSession session,AvailableGuestTest availableTest,String testName) {
		   String questionIds=availableTest.getQuestionIds();
		   
		   //pushing all questionIds into the set
		   String questionIdsInArray[]=questionIds.split(",");
		   List<String> totalQuestionsId=new ArrayList<String>(Arrays.asList(questionIdsInArray));
		   //randomize the question @@@@@@@@@@@Please remember we have to rollback
		   Collections.shuffle(totalQuestionsId);
		   //Selecting questionId for this user.
		   int finalNumberOfQuestions=Integer.parseInt((String)session.getServletContext().getAttribute("guestQuestionsNo"));
		  
		   List<String> questionIdsSubList=new ArrayList<String>();
		   if(totalQuestionsId.size()>finalNumberOfQuestions && finalNumberOfQuestions!=0) {
			    questionIdsSubList=totalQuestionsId.subList(0, finalNumberOfQuestions);
		   }else{
			   finalNumberOfQuestions=totalQuestionsId.size();
			   questionIdsSubList=totalQuestionsId;
		   }
		   
		   Map <Integer,String> questionsMapForTest=new HashMap<Integer,String>(finalNumberOfQuestions);
		   StringBuilder loadedQuestionIds=new StringBuilder();
		   int index=0;
		   for(String randomQId : questionIdsSubList) {
			   index=index+1;
			   questionsMapForTest.put(index,randomQId);
			   loadedQuestionIds.append(randomQId+",");
		   }
		   int numberOfAttForUser=1;
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
		   userExamProgressDataVO.setDoe(new Date());
		   userExamProgressDataVO.setNoOfHaltLeftForTest(2);
		   userExamProgressDataVO.setTestName(testName);
		   userExamProgressDataVO.setTechName(techName);
		   userExamProgressDataVO.setUserId(getUserIdFromSession(session).getLoginId());
		   userExamProgressDataVO.setUserSessionId((String)session.getAttribute("userSessionId"));
		   //persisting data into the datebase
		   onlineTechTestService.pushProgressDataForUser(userExamProgressDataVO);
	}
	
	/**
	 * This method creates session once user
	 * logged in into the application and store id of user object and userid
	 * into the session.
	 * @param request
	 * @param duser actual object mapped into the database
	 */
	private void createSession(HttpSession session,GuestUserForm duser,String homePage){
		UserId userId=new UserId();
		userId.setId((int)duser.getGid());
		userId.setAddress(duser.getLocation());
		if("male".equalsIgnoreCase(duser.getGender())){
			userId.setSalutation("Mr.");
		}else{
			userId.setSalutation("Ms.");
		}
		userId.setName(duser.getName());
		userId.setLoggedInTime(new Date());
		userId.setLoginId(duser.getEmail());
		//userId.setPassword(duser.getPassword());
		userId.setHomePage(homePage);
		userId.setPassword("test");
		userId.setRole(ApplicationContant.GUEST_ROLE);
		userId.setBatch(ApplicationContant.GUEST_ROLE);
		userId.setDeleteAllow(false);
		session.setAttribute(ApplicationContant.USER_SESSION_DATA, userId);
	}
	
	private UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
	
	///////////NEW code for designing the report..........
	
	// Action for delete button on All User page
	   @RequestMapping(value = "guest-tech-test-history", method = RequestMethod.POST)
		public String showUserHistoryPost(Model model, @RequestParam(value="email",required=true) String email,@RequestParam(value="userSessionId",required=true)  String userSessionId) {
		    UserOnlineExamStatusForm userOnlineExamStatusForm = userService.findUserOnlineExamStatusBySessionid(email,userSessionId);
			//GuestUserForm guestUserDetail = guestUserService.findGuestByEmailId(email,userSessionId);
		    GuestUserForm guestUserDetail = guestUserService.findGuestByEmailId(email);
			guestUserDetail.setUserid(email);
			model.addAttribute("guestUserDetail", guestUserDetail);
			if(userOnlineExamStatusForm!=null && userOnlineExamStatusForm.getTechName()!=null){
				userOnlineExamStatusForm.setExamStatus(guestUserDetail.getTestStatus());
			}else{
				GuestUserForm temp=new GuestUserForm();
				temp.setName("Guest");
				temp.setEmail(email);
				temp.setOccupation("NA");
				temp.setMobile("------");
				model.addAttribute("guestUserForm", temp);
				  model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
							ApplicationMessageConstant.SORRY_YOUR_TEST_HISTORY_DOES_NOT_EXIST+email);
			  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
			}
			model.addAttribute("userOnlineExamStatusForm", userOnlineExamStatusForm);
			return UserNavigationPage.USER_BASE + "oguest-tech-test-history";
		}
	   
	   
	   /**
	    * @Since 10-06-2018 
	    * @param model
	    * @param email
	    * @return
	    */
	   @RequestMapping(value = "guest-all-tech-test-history", method = RequestMethod.POST)
	 	public String guestAllTechTestHistory(Model model, @RequestParam(value="email",required=true) String email) {
		   	List<UserForm> guestAllTechHistoryList=consultantAssesmentService.findGuestTestHistoryWithNameEmail(email,true);
		   		if(guestAllTechHistoryList!=null){
		   			Collections.sort(guestAllTechHistoryList);
		   		}
		   		
		   		if(guestAllTechHistoryList!=null && guestAllTechHistoryList.size()>0){
		   			model.addAttribute("name", guestAllTechHistoryList.get(0).getFirstName()+" "+ guestAllTechHistoryList.get(0).getLastName());
		   			model.addAttribute("address", guestAllTechHistoryList.get(0).getAddress());
		   			model.addAttribute("occupation", "NA");
		   		}else{
		   			//write code to forward this request to error page
		   		}
	 			model.addAttribute("guestAllTechHistoryList", guestAllTechHistoryList);
	 			return UserNavigationPage.USER_BASE + "home-guest-test-search-history";
	 	}
	   
	   /**
	    *  This method is used to generate the test report
	    *  for technical online exam for guest user
	    *   
	    *  @param model
	    * @param request
	    * @return
	    */
		@RequestMapping(value = "guest-tech-test-details", method = RequestMethod.GET)
		public String guestTechTestDetails(Model model, HttpServletRequest request,HttpSession session) {
			String userId = request.getParameter("email");
			String testName = request.getParameter("testName");
			String techName = request.getParameter("techName");
			String userSessionId = request.getParameter("userSessionId");
			List<OCJPReportCard> testConfiguration =null;
			if(userSessionId==null)
				testConfiguration = adminService.findReportCardByUseridAndTest(userId, techName,testName);
			else
				testConfiguration = adminService.findReportCardByUseridAndTechTestSessionId(userId, techName,testName,userSessionId);
			if(testConfiguration!=null && testConfiguration.size()==0){
				GuestUserForm temp=new GuestUserForm();
				temp.setName("Guest");
				temp.setEmail(userId);
				temp.setOccupation("NA");
				temp.setMobile("------");
				model.addAttribute("guestUserForm", temp);
				  model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
							ApplicationMessageConstant.SORRY_YOUR_TEST_HISTORY_DOES_NOT_EXIST+userId);
			  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
			}
			// System.out.println("User: "+userId);
			System.out.println("testName: " + testName);
			AvailableGuestTest testData=guestUserService.loadAvailableTestByTechTestName(techName,testName);
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
			
			//This is new code to show only wrong answer to the end user!
			String guestRightAnswersShow=(String)session.getServletContext().getAttribute("guestRightAnswersShow");
		    String showNextPage=NavigationPage.GUEST_EXAM_DETAIL_SUMMARY;
		    int totalAttemptedQuestions=0;
		    int totalUnAttemptedQuestions=0;
		    String ctest = request.getParameter("ctest");
		    if(!"complete".equalsIgnoreCase(ctest)){
		    	ctest=null;
		    }
			if(ctest==null && guestRightAnswersShow!=null && "no".equalsIgnoreCase(guestRightAnswersShow)) {
				showNextPage=NavigationPage.GUEST_EXAM_DETAIL_WRONG_ANSWER_SUMMARY;	
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
				    questionList=filterquestionList;
			}
			
			GuestUserForm guestUserDetail = guestUserService.findGuestByEmailId(userId);
			model.addAttribute("guestUserDetail", guestUserDetail);
			model.addAttribute("questionList", questionList);
			model.addAttribute("testName", testName);
			model.addAttribute("testConfiguration", testConfiguration.get(0));
			model.addAttribute("totalAttemptedQuestions", totalAttemptedQuestions);
			model.addAttribute("totalUnAttemptedQuestions", totalUnAttemptedQuestions);
			model.addAttribute("questionSet", questionsForm.getQbankName());
			// List<UserOnlineExamStatusForm>
			// userOnlineExamStatusList=userService.findAllUserOnlineExamStatus(userId);
			// model.addAttribute("userOnlineExamStatusList",userOnlineExamStatusList);
			/*String imageContextPath=DateUtils.getImageContextPath(request);
			EmailMessageVO emailMessageVO=new EmailMessageVO();
			emailMessageVO.setName(guestUserDetail.getName());
			emailMessageVO.setToEmail(guestUserDetail.getEmail());
			emailMessageVO.setFrom((String)session.getServletContext().getAttribute("companyEmail"));
			emailMessageVO.setImageContextPath(imageContextPath);
			emailMessageVO.setType(ApplicationContant.SUCCESS);*/
			//attendanceEmailReminderService.sendCompletedTestSummaryWithQuizAnsEmail(questionList, emailMessageVO);
			return UserNavigationPage.USER_BASE +showNextPage;
		}
	
	
}

