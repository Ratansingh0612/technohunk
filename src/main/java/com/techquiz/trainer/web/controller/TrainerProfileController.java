package com.techquiz.trainer.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.model.User;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.trainer.service.IConsultantAssesmentService;

@Controller
@Scope("singleton")
public class TrainerProfileController {

	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	
	@Autowired
	@Qualifier("UserAdminCommonServiceImpl")
	private UserAdminCommonService userAdminCommonService;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@RequestMapping(value="trainerProfile",method=RequestMethod.GET)
	public String ushowEditPage(HttpServletRequest request,Model model) {
		//logic to fetch data to be edited from db
		 int objId=getUserObjectId(request);
		 User user=userService.findUserById(objId);
	  	//model is type of hashMap
		 user.setPassword(getUserData(request).getPassword());
		 model.addAttribute("user",user);
		 return UserNavigationPage.TRAINER_BASE+NavigationPage.USER_PROFILE_PAGE;			
	}
	
	@RequestMapping(value="showConfiguredTestDetails",method=RequestMethod.GET)
	public String showConfiguredTestDetails(@RequestParam("testName") String testName,Model model){
		TestConfiguration testConfiguration=userAdminCommonService.findAvailableTestByTestName(testName);
		String[] selectedQuestionIds=testConfiguration.getQuestionIds().split(",");
		List<QuestionsForm> assignedQuestion=userAdminCommonService.findAllQuestionByQuestionIds(selectedQuestionIds);
		model.addAttribute("questionsList", assignedQuestion);
		model.addAttribute("testConfiguration", testConfiguration);
		if(assignedQuestion!=null && assignedQuestion.size()>0) {
			model.addAttribute("questionOwner", assignedQuestion.get(0).getQuestionOwner());
		}
		model.addAttribute("testName",testName);
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.CONFIGURED_TEST_DETAILS;
	}
	
	@RequestMapping(value="findConsultantImage",method=RequestMethod.GET)
	public void showImageByUserId(@RequestParam("userid") String userid,HttpServletResponse response,HttpSession session) {
		byte[] photo=consultantAssesmentService.findPhotoByUserId(userid);
		//now write this photo means byte array into the response so that image can be rendered on the UI
		response.setContentType("image/png");
		if(photo==null || photo.length<=10) {
			InputStream stream =(InputStream)session.getServletContext().getResourceAsStream("/images/icon/user-icon.png");
			try {
				photo = IOUtils.toByteArray( stream);
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//writting photo into the response
		try {
			ServletOutputStream out = response.getOutputStream();
			if (photo != null && photo.length>0)
				out.write(photo);
			   out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This is returning id of object from 
	 * session for logged user into the application
	 * @param request
	 * @return
	 */
	private int getUserObjectId(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId.getId();
	}
	
	private UserId getUserData(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
	
}
