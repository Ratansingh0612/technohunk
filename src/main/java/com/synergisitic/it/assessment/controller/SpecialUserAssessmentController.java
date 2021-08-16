package com.synergisitic.it.assessment.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.GuestUserService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.GuestUserForm;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.UserExamProgressDataVO;
import com.synergisitic.it.web.form.UserId;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.control.panel.service.AppSettingsService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

@Controller
public class SpecialUserAssessmentController {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(SpecialUserAssessmentController.class);
	

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
	
	
	
	
	@Autowired
	@Qualifier("AppSettingsServiceImpl")
	private AppSettingsService appSettingsService;
	

	
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
	@RequestMapping("test-tdchart")
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
	
	@PostMapping(value="/result-summary")
	 public String  testResultSummaryPage(@RequestParam("email") String email,Model model){
		return UserNavigationPage.USER_BASE+UserNavigationPage.TEST_RESULT_SUMMARY_PAGE;
	}	
	
	
	
	/**
	 * 
	 * @param tuid
	 * @return
	 */
	@GetMapping(value="/welcome-test")
	 public String startTestUsingLink(HttpSession session,Model model) {
		  //if this is guest user
		String testLink="assessment/test/start?tuid="+session.getId();
		//creating dummy user for application
		GuestUserForm guestUserForm=new GuestUserForm();
		guestUserForm.setName("TODO");
		guestUserForm.setAdminid("nagen@gmail.com");
		guestUserForm.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		guestUserForm.setEmail("todo@gmail.com");
		guestUserForm.setExpiryDate(DateUtils.getCurrentTimeIntoTimestamp());
		guestUserForm.setGender("male");
		guestUserForm.setGeneratedTestLink("TODO");
		guestUserForm.setGid(-100);
		guestUserForm.setLocation("India");
		guestUserForm.setMobile("9899444555");
		guestUserForm.setOccupation("TODO");
		guestUserForm.setTduration("60");
		guestUserForm.setTechName("Core-Java");
		guestUserForm.setTestName("JAVA_BASIC");
		guestUserForm.setTestStatus("Not Started");
		guestUserForm.setUserid("todo@gmail.com");
		String userSessionId="UT"+new Date().getTime();
		guestUserForm.setUserSessionId(userSessionId);
		model.addAttribute("guestUserForm",guestUserForm);
		if(ApplicationContant.NOT_STARTED.equalsIgnoreCase(guestUserForm.getTestStatus())) {
			createSession(session,guestUserForm,"home.jsp");
			//Default test 
			String techName="Core-Java";
			String testName="JAVA_BASIC";
			if(techName!=null && techName.length()>0) {
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
			  session.setAttribute("userSessionId", userSessionId);
			  session.setAttribute("weightage", "yes");
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
			   pushTestProgressDataIntoSession(session,loadedQuestionIds,testName,techName);
			   model.addAttribute("availableTest", availableGuestTest);
			   session.setAttribute("utestName", testName);
			   session.setAttribute("utechName", techName);
			   return UserNavigationPage.PUBLIC_BASE+UserNavigationPage.WELCOME_TEST_PAGE;
		}	
		else {
			    	  model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
								ApplicationMessageConstant.SORRY_THERE_IS_SOME_PROBLEM_WITH_TEST);
				  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
		}
		
	
	}
	
	@RequestMapping(value="start-test",method=RequestMethod.GET)
	public String startTechTest(Model model,HttpSession session){
		   //Create unique session id for a test.....
		   //String userSessionId="UT"+new Date();	
		   //UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		   //ConsultantsVO  consultantsVO=new ConsultantsVO();	     
		   /*if(userId.getRole().equalsIgnoreCase(ApplicationContant.GUEST_ROLE)){
			   guestUserService.updateGuestUserTest(userId.getLoginId(),userId.getId(),ApplicationContant.IN_PROGRESS);
			   String userSessionId=(String)session.getAttribute("userSessionId");
			   guestUserService.updateGuestUserSessionId(userId.getLoginId(),userId.getId(),userSessionId);
		   }*/
	       model.addAttribute("questionAndAnsTestDataVO",fetchNextQuestionAnswer(session));
	       Map <Integer,String> questionsForTest=(Map <Integer,String>)session.getAttribute("questionsMapForTest");
	       model.addAttribute("totalQuestions",questionsForTest!=null?questionsForTest.size():0);
	       return UserNavigationPage.PUBLIC_BASE+NavigationPage.START_TECH_TEST_PAGE;
	}
	
	
	@GetMapping(value="/update-guest-details")
	@ResponseBody public ApplicationMessageResponse UpdateGuestName(@RequestParam(value="name",required=false) String name,@RequestParam(value="email",required=false) String email,@RequestParam("salutation") String salutation,
			HttpSession session) throws IOException{
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		//GuestUserForm guestUserForm=new GuestUserForm();
	     userId.setName(name);
	     userId.setLoginId(email);
		//guestUserForm.setGid(userId.getId());
		//guestUserForm.setName(name);
		
		GuestUserForm guestUserForm=new GuestUserForm();
		guestUserForm.setName(name);
		guestUserForm.setAdminid(email);
		guestUserForm.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		guestUserForm.setEmail(email);
		guestUserForm.setExpiryDate(DateUtils.getCurrentTimeIntoTimestamp());
		guestUserForm.setGeneratedTestLink("Assessment");
		guestUserForm.setLocation("India");
		guestUserForm.setMobile("9899333444");
		guestUserForm.setOccupation("NA");
		guestUserForm.setTduration("60");
		guestUserForm.setTechName("Core-Java");
		guestUserForm.setTestName("JAVA_BASIC");
		guestUserForm.setTestStatus("Not Started");
		guestUserForm.setUserid(email);
		String userSessionId=(String)session.getAttribute("userSessionId");
		guestUserForm.setUserSessionId(userSessionId);
		
		if("1".equals(salutation)){
			guestUserForm.setGender("Male");
			userId.setSalutation("Mr.");
		}else{
			guestUserForm.setGender("Female");
			userId.setSalutation("Ms.");
		}
		String status=guestUserService.addGuestUser(guestUserForm);
		ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setMessage("Name ,Email and salutation are updated successfully into the database.");
	   return applicationMessageResponse;
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
	 *  Method which will persist data into session when test starts
	 *  first time and it will be used when test is restarted in between.
	 * @param session
	 * @param loadedQuestionIds
	 * @param testName
	 */
	private void pushTestProgressDataIntoSession(HttpSession session,StringBuilder loadedQuestionIds,String testName,String techName) {
		   UserExamProgressDataVO userExamProgressDataVO=new UserExamProgressDataVO();
		   userExamProgressDataVO.setAssignedQuestionIds(loadedQuestionIds.toString());
		   userExamProgressDataVO.setDescription("User Test Data");
		   userExamProgressDataVO.setDoe(new Date());
		   userExamProgressDataVO.setNoOfHaltLeftForTest(2);
		   userExamProgressDataVO.setTestName(testName);
		   userExamProgressDataVO.setTechName(techName);
		   userExamProgressDataVO.setUserId(getUserIdFromSession(session).getLoginId());
		   userExamProgressDataVO.setUserSessionId((String)session.getAttribute("userSessionId"));
		   //session.setAttribute("userExamProgressDataVO", userExamProgressDataVO);
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
	
}

