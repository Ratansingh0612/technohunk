package com.techquiz.codings.web.controller;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.synergisitic.it.email.service.vo.EmailMessageVO;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.GradeUtils;
import com.synergisitic.it.util.UniqueLinkGenaratorUtil;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.codings.service.CodingProblemsService;
import com.techquiz.codings.service.GuestCodingProblemLinksService;
import com.techquiz.codings.service.GuestCodingProblemSubmitedSolutionService;
import com.techquiz.codings.service.impl.GuestCodingProblemSubmitedSolutionServiceImpl;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;
import com.techquiz.codings.web.controller.vo.CodingProblmesLinkVO;
import com.techquiz.codings.web.controller.vo.ConsultantsSubmittedCodeVO;
import com.techquiz.control.panel.controller.model.AppSettingsVO;
import com.techquiz.control.panel.service.AppSettingsService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;

/**
 * 
 * @author nagendra
 * @since 06-Aug-2018
 *
 */
@Controller
@RequestMapping("/codings")
public class GuestCodingProblemSolutionController {
	
	@Autowired
	@Qualifier("GuestCodingProblemSubmitedSolutionServiceImpl")
	private GuestCodingProblemSubmitedSolutionService codingProblemSubmitedSolutionService;
	
	@Autowired
	@Qualifier("AppSettingsServiceImpl")
	private AppSettingsService appSettingsService;
	
	@Autowired
	@Qualifier("GuestEmailServiceImpl")
	private GuestEmailService guestEmailService;
	
	
	@Autowired
	@Qualifier("GuestCodingProblemLinksServiceImpl")
	private GuestCodingProblemLinksService guestCodingProblemLinksService;
	
	@Autowired
	@Qualifier("GuestCodingProblemSubmitedSolutionServiceImpl")
	private GuestCodingProblemSubmitedSolutionServiceImpl guestCodingProblemSubmitedSolutionService;
	
	
	@Autowired
	@Qualifier("CodingProblemsServiceImpl")
	private CodingProblemsService codingProblemsService;
	
	@Autowired
	@Qualifier("AttendanceEmailReminderService")
	private IAttendanceEmailReminderService iAttendanceEmailReminderService;
	
	
	

	/**
	 * 
	 * @param email
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "delete-guest-user-coding-problem-link", method = RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse deleteGuestUserCodingProblemLink(@RequestParam("gid") long gid,@RequestParam("userid") String userid) {
		String status=guestCodingProblemLinksService.deleteCodingProblemLinkWithGid(gid);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(status);
		applicationMessageResponse.setMessage("Guest user coding problem link has been deleted successfully from the database.");
		return applicationMessageResponse;
	}
	
	@RequestMapping(value = "pending-coding-problem-guest", method = RequestMethod.GET)
	public String pendingCodingProblemGuestResult(Model model,HttpSession session) {
		List<String> batchList=new ArrayList<String>();
		batchList.add("guest");
		model.addAttribute("dgname",batchList );
		model.addAttribute("selectedGroupName", "guest");
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.PENDING_CODING_PROBLEM_GUEST_PAGE;
	}
	
	/**
	 * 
	 * @param email
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "find-guest-pending-cproblems", method = RequestMethod.GET)
	@ResponseBody public List<CodingProblmesLinkVO> findGuestPendingCproblems() {
		List<CodingProblmesLinkVO> codingProblmesLinkVOs=guestCodingProblemLinksService.findCodingProblemWithSessionIDNull();
		return codingProblmesLinkVOs;
	}		
	
	/**
	 * 
	 * @param email
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "find-guest-cproblems-results", method = RequestMethod.GET)
	@ResponseBody public List<ConsultantsSubmittedCodeVO> findGuestCproblemsResults(@RequestParam("email") String email,Model model,HttpSession session) {
		List<ConsultantsSubmittedCodeVO> consultantsSubmittedCodeVOs=guestCodingProblemSubmitedSolutionService.findCodingProblemSubmittedSolutionByEmail(email);
		return consultantsSubmittedCodeVOs;
	}
	
	@RequestMapping(value = "coding-problem-guest-result", method = RequestMethod.GET)
	public String pendingTestGuestUser(Model model,HttpSession session) {
		List<String> batchList=new ArrayList<String>();
		batchList.add("guest");
		model.addAttribute("dgname",batchList );
		model.addAttribute("selectedGroupName", "guest");
		// model is type of hashMap
		model.addAttribute("userGroupList", batchList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.CODING_PROBLEM_GUEST_RESULT_PAGE;
	}
	
/*	@RequestMapping(value = "find-guest-pending-tests", method = RequestMethod.GET)
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
	*/

	
	 /**
	 * 
	 * @return
	 */
	@PostMapping(value={"submit-coding-problem","problem-time-out"})
	public String submitPorblemSolution(@ModelAttribute ConsultantsSubmittedCodeVO consultantsSubmittedCodeVO,HttpSession session,HttpServletRequest request,Model model) {
		System.out.println("----------------%%%%%%%%%%%----------------------");
		//comment=null, grade=null, compilationError=, testPassed=0, testFailed=4, doe=null, dom=null]
		if(consultantsSubmittedCodeVO.getCompilationError().length()>0){
			consultantsSubmittedCodeVO.setCompilationError("YES");
		}else{
			consultantsSubmittedCodeVO.setCompilationError("NO");
		}
		if("No".equalsIgnoreCase(consultantsSubmittedCodeVO.getProblemTimeout())){
			consultantsSubmittedCodeVO.setComment("code is uploaded by end user.");
		}else{
			consultantsSubmittedCodeVO.setComment(consultantsSubmittedCodeVO.getProblemTimeout());
		}
		consultantsSubmittedCodeVO.setDoe(new Timestamp(new Date().getTime()));
		consultantsSubmittedCodeVO.setDom(new Timestamp(new Date().getTime()));
		int totalTestCases=consultantsSubmittedCodeVO.getTestFailed()+consultantsSubmittedCodeVO.getTestPassed();
		int passTests=consultantsSubmittedCodeVO.getTestPassed();
		String grade=GradeUtils.computeGrade(totalTestCases, passTests);
		consultantsSubmittedCodeVO.setGrade(grade);
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String emailid=userId.getLoginId();
		consultantsSubmittedCodeVO.setConsultantid(emailid);
		System.out.println(consultantsSubmittedCodeVO);
		
		String generatedCodeLink=(String)session.getAttribute("generatedCodeLink");
		CodingProblmesLinkVO codingProblmesLinkVO=guestCodingProblemLinksService.findCodingLinkDetailsByCodingLink(generatedCodeLink);
		guestCodingProblemLinksService.updateCodingProblemLinkStatus(codingProblmesLinkVO.getGid());
		
		String userSessionId=(String)session.getAttribute("userSessionId");
		consultantsSubmittedCodeVO.setUserSessionId(userSessionId);
		
		//Setting coding problem vo
		CodingProblemsVO codingProblemsVO=codingProblemsService.findCodingProblemsByProbId(Long.parseLong(consultantsSubmittedCodeVO.getCpid()));
		consultantsSubmittedCodeVO.setCodingProblemsVO(codingProblemsVO);
		
		//Setting coding setCodingProblmesLinkVO
		consultantsSubmittedCodeVO.setCodingProblmesLinkVO(codingProblmesLinkVO);
		codingProblemSubmitedSolutionService.saveCodingProblemSolution(consultantsSubmittedCodeVO);
		//session.setAttribute("userSessionId", "UT"+new Date().getTime());
		System.out.println("----------------%%%%%%%%%%%----------------------");
		//since coding problem is done ,so please clear the the temporary session
		session.invalidate();
		//Coding to send an email....................
		String imageContextPath=DateUtils.getImageContextPath(request);
    	EmailMessageVO emailMessageVO=new EmailMessageVO();
    	emailMessageVO.setEmailMessage("NA");
    	emailMessageVO.setFrom((String)session.getServletContext().getAttribute("companyEmail"));
    	emailMessageVO.setImageContextPath(imageContextPath);
    	emailMessageVO.setName(codingProblmesLinkVO.getName());
    	emailMessageVO.setSalutation(userId.getSalutation());
    	emailMessageVO.setToEmail(codingProblmesLinkVO.getEmail());
    	if("No".equalsIgnoreCase(consultantsSubmittedCodeVO.getProblemTimeout())){
    		emailMessageVO.setType(ApplicationContant.SUCCESS);
    	}else{
    		emailMessageVO.setType(consultantsSubmittedCodeVO.getProblemTimeout());
    	}
		emailMessageVO.setImageContextPath(imageContextPath);
		consultantsSubmittedCodeVO.setCduration(codingProblmesLinkVO.getPduration());
		consultantsSubmittedCodeVO.setProblemTitle(codingProblmesLinkVO.getProblemTitle());
		consultantsSubmittedCodeVO.setUserId(codingProblmesLinkVO.getEmail());
		consultantsSubmittedCodeVO.setTechName(codingProblmesLinkVO.getTechName());
		iAttendanceEmailReminderService.sendCodingProblemSummaryEmail(consultantsSubmittedCodeVO, emailMessageVO);
		model.addAttribute("emailMessageVO", emailMessageVO);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
					ApplicationMessageConstant.CONGRATULATION_YOUR_CODING_PROBLEM_HAS_BEEN_SAVE_INTO_DB);
	  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
		//return UserNavigationPage.CODINGS_BASE + CodingsNavigationPage.CODING_PROBLEM_CONFIRMATION_PAGE;
	}
	
	
	/**
	* 
	* @return
	*/
	@PostMapping("send-coding-link")
	@ResponseBody public ApplicationMessageResponse sendCodingLink(@ModelAttribute CodingProblmesLinkVO codingProblmesLinkVO,HttpSession session,HttpServletRequest request) {
			System.out.println("----------------%%%%%%%%%%%----------------------");
			UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
			String userid=userId.getLoginId();
			codingProblmesLinkVO.setAdminid(userid);
			codingProblmesLinkVO.setUserid(codingProblmesLinkVO.getEmail());
			codingProblmesLinkVO.setDoe(new Timestamp(new Date().getTime()));
			codingProblmesLinkVO.setCodingStatus(ApplicationContant.NOT_STARTED);
			//Generating coding problem test link........
			// Creating the test link..........
			final String TEST_LINK_URL = "action/codings/problem/start?cpuid=";
			String baseURL = DateUtils.getServerBaseURL(request) + "/"	+ TEST_LINK_URL;
			String cuid = UniqueLinkGenaratorUtil.findUniqueCuid();
			String generatedTestLink = baseURL + "cp"+cuid;
			codingProblmesLinkVO.setGeneratedCodeLink(TEST_LINK_URL + "cp"+cuid);
			
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
			codingProblmesLinkVO.setExpiryDate(linkexpdate);
			System.out.println(codingProblmesLinkVO);
			System.out.println("----------------%%%%%%%%%%%----------------------");
			String response = guestCodingProblemLinksService.saveCodingProblemLink(codingProblmesLinkVO);
			codingProblmesLinkVO.setGeneratedCodeLink(generatedTestLink);
			guestEmailService.sendCodingProblemEmailAsLink(codingProblmesLinkVO,DateUtils.getServerBaseURL(request));
			System.out.println("generatedTestLink  = "+generatedTestLink);	
			
			ApplicationMessageResponse applicationMessageResponse=new  ApplicationMessageResponse();
			// Write code to send email here
			applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
			applicationMessageResponse.setMessage("Hello  "+ codingProblmesLinkVO.getEmail()
							+ " one coding problem link has been sent to your email id , please use the same to start your coding problem.");
			return applicationMessageResponse;
		}
	
	/**
	* This method is used to send more than one coding links at a time!!!!!!!
	* @return
	*/
	@PostMapping("send-coding-links")
	@ResponseBody public ApplicationMessageResponse sendCodingLinks(@RequestParam("pprobsId") String[] pprobsId,@RequestParam("name") String name,@RequestParam("email") String email,HttpSession session,HttpServletRequest request) {
			if(pprobsId!=null && pprobsId.length>0){
				for(String probId:pprobsId) {
				probId=probId.trim();	
				CodingProblemsVO codingProblemsVO=codingProblemsService.findCodingProblemsByProbId(Long.parseLong(probId));
				CodingProblmesLinkVO codingProblmesLinkVO=new CodingProblmesLinkVO();
				codingProblmesLinkVO.setProblemId(probId);
				codingProblmesLinkVO.setProblemTitle(codingProblemsVO.getTitle());
				codingProblmesLinkVO.setPduration(codingProblemsVO.getDuration()+"");
				codingProblmesLinkVO.setTechName(codingProblemsVO.getTechName());
				codingProblmesLinkVO.setEmail(email);
				codingProblmesLinkVO.setName(name);
				System.out.println("----------------%%%%%%%%%%%----------------------");
				UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
				String userid=userId.getLoginId();
				codingProblmesLinkVO.setAdminid(userid);
				codingProblmesLinkVO.setUserid(codingProblmesLinkVO.getEmail());
				codingProblmesLinkVO.setDoe(new Timestamp(new Date().getTime()));
				codingProblmesLinkVO.setCodingStatus(ApplicationContant.NOT_STARTED);
				//Generating coding problem test link........
				// Creating the test link..........
				final String TEST_LINK_URL = "action/codings/problem/start?cpuid=";
				String baseURL = DateUtils.getServerBaseURL(request) + "/"	+ TEST_LINK_URL;
				String cuid = UniqueLinkGenaratorUtil.findUniqueCuid();
				String generatedTestLink = baseURL + "cp"+cuid;
				codingProblmesLinkVO.setGeneratedCodeLink(TEST_LINK_URL + "cp"+cuid);
				
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
				codingProblmesLinkVO.setExpiryDate(linkexpdate);
				System.out.println(codingProblmesLinkVO);
				System.out.println("----------------%%%%%%%%%%%----------------------");
				String response = guestCodingProblemLinksService.saveCodingProblemLink(codingProblmesLinkVO);
				codingProblmesLinkVO.setGeneratedCodeLink(generatedTestLink);
				guestEmailService.sendCodingProblemEmailAsLink(codingProblmesLinkVO,DateUtils.getServerBaseURL(request));
				System.out.println("generatedTestLink  = "+generatedTestLink);	
			}
		}	
			ApplicationMessageResponse applicationMessageResponse=new  ApplicationMessageResponse();
			// Write code to send email here
			applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
			applicationMessageResponse.setMessage("Hello  "+ email
							+ " coding problems link has been sent to your email id , please use the same to start your coding problem.");
			return applicationMessageResponse;
		}
		
		/**
		 * 
		 * @param tuid
		 * http://localhost:8080/techquiz/action/coding-problem/start?cpuid=cp1533664916894-269c70d6-976c-48c2-acea-6698f3a46483
		 * @return
		 */
		@GetMapping(value="/problem/start")
		 public String startTestUsingLink(@RequestParam("cpuid") String cpuid,HttpSession session,Model model) {
			  //if this is guest user
			String generatedCodeLink="action/codings/problem/start?cpuid="+cpuid;
			CodingProblmesLinkVO codingProblmesLinkVO=guestCodingProblemLinksService.findCodingLinkDetailsByCodingLink(generatedCodeLink);
			model.addAttribute("codingProblmesLinkVO",codingProblmesLinkVO);
			if(codingProblmesLinkVO.getGid()==0){
				//forward to the error page
				 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
							ApplicationMessageConstant.SORRY_THIS_LINK_IS_NOT_VALID_FOR_CODING_PROBLEM);
			  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
			}else if("COMPLETED".equalsIgnoreCase(codingProblmesLinkVO.getCodingStatus())){
				 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
							ApplicationMessageConstant.SORRY_YOU_HAVE_ALREADY_GIVEN_TEST);
			  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
			}else if(ApplicationContant.NOT_STARTED.equalsIgnoreCase(codingProblmesLinkVO.getCodingStatus())) {
				//Testing either link is expired or not
				//Write logic to check ////
				Timestamp expdate=codingProblmesLinkVO.getExpiryDate();
				long expdateLong=expdate.getTime();
			    Date cuDate=new Date();
			    long computeDateTime=cuDate.getTime();
			    if(computeDateTime>expdateLong) {
			   	 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
							ApplicationMessageConstant.SORRY_YOUR_CODING_PROBLEM_LINK_HAS_BEEN_EXPIRED);
			  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
			    }
				createSession(session,codingProblmesLinkVO,"home.jsp");
				//session.setAttribute("SpecialRole",ApplicationContant);
				//Here we have to write logic to fetch test details 
				String userSessionId="UT"+new Date().getTime();
				//updating the userSessionId into the database
				guestCodingProblemLinksService.updateCodingProblemLinkUserSessionId(codingProblmesLinkVO.getGid(),userSessionId);
				session.setAttribute("userSessionId",userSessionId);
				session.setAttribute("generatedCodeLink", generatedCodeLink);
				session.setAttribute("problemTitle", codingProblmesLinkVO.getProblemTitle());
				session.setAttribute("pduration", codingProblmesLinkVO.getPduration());
				
				CodingProblemsVO codingProblemsVO=codingProblemsService.findCodingProblemsByProbId(Long.parseLong(codingProblmesLinkVO.getProblemId()));
				session.setAttribute("level", codingProblemsVO.getLevel());
				session.setAttribute("techName", codingProblemsVO.getTechName());
				//	String redirectLink="action/codings/java/factorial-num";
				String redirectLink=codingProblemsVO.getReadMore()+"?userSessionId="+userSessionId;
				return "redirect:/"+redirectLink;
			}	
			else {
				    Timestamp expdate=codingProblmesLinkVO.getExpiryDate();
					long expdateLong=expdate.getTime();
				    Date cuDate=new Date();
				    long computeDateTime=cuDate.getTime();
				    if(computeDateTime>expdateLong){
				   	      model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
								ApplicationMessageConstant.SORRY_YOUR_CODING_PROBLEM_LINK_HAS_BEEN_EXPIRED);
				  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
				    }else{
				    	  model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
									ApplicationMessageConstant.SORRY_THERE_IS_SOME_PROBLEM_WITH_CODING_PROBLEM);
					  		  return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.GUEST_TEST_MESSAGE_PAGE;
				    }
			}
		}
	
		/**
		 * This method creates session once user
		 * logged in into the application and store id of user object and userid
		 * into the session.
		 * @param request
		 * @param duser actual object mapped into the database
		 */
		private void createSession(HttpSession session,CodingProblmesLinkVO duser,String homePage){
			UserId userId=new UserId();
			userId.setId((int)duser.getGid());
			userId.setAddress("NA");
			if("male".equalsIgnoreCase(duser.getGender())){
				userId.setSalutation("Mr.");
			}else{
				userId.setSalutation("Ms.");
			}
			userId.setName(duser.getName());
			userId.setLoggedInTime(new Date());
			userId.setLoginId(duser.getEmail());
			userId.setProblemId(duser.getProblemId());
			//userId.setPassword(duser.getPassword());
			userId.setHomePage(homePage);
			//userId.setPassword("test");
			userId.setRole(ApplicationContant.GUEST_ROLE);
			userId.setBatch(ApplicationContant.GUEST_ROLE);
			userId.setDeleteAllow(false);
			session.setAttribute(ApplicationContant.USER_SESSION_DATA, userId);
		}
		
		private UserId getUserIdFromSession(HttpSession session) {
			UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
			return userId;
		}
	

}
