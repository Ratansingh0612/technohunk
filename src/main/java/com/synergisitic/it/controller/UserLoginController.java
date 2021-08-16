package com.synergisitic.it.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.navigation.AdminNavigationPage;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.ConsultantNavigationPage;
import com.synergisitic.it.navigation.ManagerNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.ConsultantService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.Userervice;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.LoggedInUserSessionUtil;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.PendingTopicFeedbackForm;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.control.panel.controller.model.LoginSliderVO;
import com.techquiz.control.panel.service.LoginPageControlService;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

/**
 * 
 * @author nagendra Yadav
 *
 */
@Controller
public class UserLoginController {
	
	@Autowired
	@Qualifier("ConsultantServiceImpl")
	private ConsultantService consultantService;
	
	
	public  UserLoginController(){
		System.out.println("............UserLoginController is loaded and instantiated........at "+new Date());
	}
	

	@Autowired
	@Qualifier("usererviceImpl")
	private Userervice userService;
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	
	@Autowired
	@Qualifier("LoginPageControlServiceImpl")
	private LoginPageControlService loginPageControlService;

	
	/*@RequestMapping(value="showLoginPage",method=RequestMethod.GET)
	public String showLoginPage() {
		return NavigationPage.LOGIN_PAGE; //WEB-INF/jsps/login.jsp	
	}*/
	
	@RequestMapping(value="loginPage",method=RequestMethod.GET)
	public String showLoginPage() {
		return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGIN_PAGE; //WEB-INF/jsps/login.jsp	
	}
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="signOut",method=RequestMethod.GET)
	public String signOutPage(HttpSession session, Model model) {
		model.addAttribute("emessage", "You have successfully logout from the application ,Thanks.");
		session.invalidate();
		//.addAttribute("emessage","Login or password are invalid!");
		return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGIN_PAGE; //WEB-INF/jsps/login.jsp	
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String loginAgain(HttpSession session, Model model) {
		session.invalidate();
		//.addAttribute("emessage","Login or password are invalid!");
		return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGIN_PAGE; //WEB-INF/jsps/login.jsp	
	}
	
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="invalidate-session",method=RequestMethod.GET)
	@ResponseBody public String signOutPage(HttpSession session) {
		session.invalidate();
		return  "success";	
	}
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logoutPage(HttpSession session, Model model) {
		model.addAttribute("emessage", "You have successfully logout from the application ,Thanks.");
		session.invalidate();
		//.addAttribute("emessage","Login or password are invalid!");
		return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGOUT_PAGE; //WEB-INF/jsps/login.jsp	
	}
	*/
	
	
	@RequestMapping(value="userHome",method=RequestMethod.GET)
	public String showUserHome(){
		return NavigationPage.USER_HOME; //WEB-INF/jsps/userHome.jsp	
	}
	
	@RequestMapping(value="adminHomePage",method=RequestMethod.GET)
	public String forwardToAdminHomePage(){
		return AdminNavigationPage.ADMIN_BASE+NavigationPage.ADMIN_HOME;
	}
	
	@RequestMapping(value="trainerHomePage",method=RequestMethod.GET)
	public String trainerHomePage(){
		return UserNavigationPage.TRAINER_BASE+NavigationPage.TRAINER_HOME;
	}
	
	@RequestMapping(value="consultantHomePage",method=RequestMethod.GET)
	public String consultantHomePage(HttpSession session,Model model){
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		 List<AssignedTestUserForm> assignedTestUserList =onlineTechTestService.findAssignedTestByUserId(userId.getLoginId());
		 Iterator<AssignedTestUserForm> iterator=assignedTestUserList.iterator();
		 while(iterator.hasNext()){
			 AssignedTestUserForm assignedTestUserForm=iterator.next();
			 if(assignedTestUserForm!=null) {
				  if(ApplicationContant.COMPLETE_EXAM_STATUS.equalsIgnoreCase(assignedTestUserForm.getTestStatus())) {
					  	iterator.remove();
				  }
			 }
		 }
		 model.addAttribute("assignedTestUserList", assignedTestUserList);
			List<PendingTopicFeedbackForm> pendingFeedbackFormsList=consultantService.findPendingTopicFeedbacks(userId.getConsultantid());
			model.addAttribute("count", pendingFeedbackFormsList!=null?pendingFeedbackFormsList.size():0);
		return ConsultantNavigationPage.CONSULTANT_BASE+ConsultantNavigationPage.CONSULTANT_HOME_PAGE;
	}
	
	@RequestMapping(value="userHomePage",method=RequestMethod.GET)
	public String forwardToUserHomePage(){
		return UserNavigationPage.USER_BASE+NavigationPage.USER_HOME;
	}

	@RequestMapping(value="managerHomePage",method=RequestMethod.GET)
	public String forwardToManagerHomePage(){
		return ManagerNavigationPage.MANAGER_BASE+ManagerNavigationPage.MANAGER_HOME_PAGE;
	}
	
	@RequestMapping(value="oauth",method=RequestMethod.GET)
	public String authUser(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			//invalidate the session
			session.invalidate();
		}
		List<LoginSliderVO> loginSliderVOs=loginPageControlService.findLoginPageContents();
		if(loginSliderVOs!=null && loginSliderVOs.size()>0)
		model.addAttribute("loginContentVO",loginSliderVOs.get(0));
		
		return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGIN_PAGE;
	}
	
	//http://localhost:8090/OnlineTechTest/action/validateUser  ==Method=POST
	@RequestMapping(value="validateUser",method=RequestMethod.POST)
	public String validateUser(@RequestParam("login") String pplogin,
			@RequestParam("password") String password,HttpServletRequest request,Model model){
		if(pplogin!=null) {
			pplogin=pplogin.trim();
		}
		if(password!=null) {
			password=password.trim();
		}
		System.out.println("_#)#)#)#*(*#&#");
	    //Logic for validating user with database
		/*com.synergisitic.it.model.User user=new com.synergisitic.it.model.User();
		user.setLoginid(pplogin);
		user.setPassword(mypassword);*/
		try {
			//DESedeEncryption deSedeEncryption=new DESedeEncryption();
			//before validating the user password we are encrypting once again here
			//user.setPassword(deSedeEncryption.encrypt(mypassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
		com.synergisitic.it.model.User duser=userService.validateUser(pplogin,password);
		if(duser==null) {
			List<LoginSliderVO> loginSliderVOs=loginPageControlService.findLoginPageContents();
			if(loginSliderVOs!=null && loginSliderVOs.size()>0)
			model.addAttribute("loginContentVO",loginSliderVOs.get(0));
			String contextName=request.getContextPath();
			model.addAttribute("emessage","<img src=\""+contextName+"/images/icon/white-color.png\">Login or password are invalid, please contact to system administrator.");
			return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGIN_PAGE; //WEB-INF/jsps/login.jsp	
           //return "redirect:/login.jsp";
	    }else if(duser.getActive()!=null && duser.getActive().equalsIgnoreCase(ApplicationContant.NO_STATUS)) {
	    	List<LoginSliderVO> loginSliderVOs=loginPageControlService.findLoginPageContents();
			if(loginSliderVOs!=null && loginSliderVOs.size()>0)
			model.addAttribute("loginContentVO",loginSliderVOs.get(0));
			String contextName=request.getContextPath();
			model.addAttribute("emessage","<img src=\""+contextName+"/images/icon/white-color.png\">Sorry "+pplogin+", Your account has been locked , please contact to system administrator.");
			return CommonNavigationPage.COMMON_BASE+ NavigationPage.LOGIN_PAGE; //WEB-INF/jsps/login.jsp	
	    }
		else {
			//if user is validate ,create the session for it.
	    	String currentRole=duser.getRole();
	    	String forwardedURL="";
	    	if(currentRole.equals("admin")) {
				 forwardedURL="/action/adminHomePage";
			 }	 
	    	else if(currentRole.equals("consultant")) {
	    	 	 forwardedURL="/action/consultantHomePage";
	    	} else if(currentRole.equals("trainer")) {
	    	 	 forwardedURL="/action/trainerHomePage";			
	    	}  else if(currentRole.equals("manager")) {
	    	 	 forwardedURL="/action/managerHomePage";
	    	}		
			else {
				 forwardedURL="/action/userHomePage";
			}	
	    	LoggedInUserSessionUtil.createSession(request,duser,forwardedURL.substring(1));
	    	return "redirect:"+forwardedURL;
		}
	}
	
	
	@RequestMapping(value = "consultant/registration", method = RequestMethod.GET)
	public String addConsltant(Model model) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		// List<String> streamList=consultantAssesmentService.findAllStream();
		ConsultantsVO consultant = new ConsultantsVO();
		consultant.setGender("Male");
		model.addAttribute("batchList", batchList);
		// model.addAttribute("streamList",streamList);
		model.addAttribute("consultant", consultant);
		return CommonNavigationPage.COMMON_BASE
				+ UserNavigationPage.ADD_CONSULTANT_PAGE;
	}
	
}
