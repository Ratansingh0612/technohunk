package com.synergisitic.it.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.model.FeedbackInputData;
import com.synergisitic.it.model.User;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.ConsultantService;
import com.synergisitic.it.service.impl.ConsultantServiceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.PendingTopicFeedbackForm;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;

/**
 * 
 * @author Nagendra
 *
 */

@Controller
public class ConsultantController {
	
	@Autowired
	@Qualifier("ConsultantServiceImpl")
	private ConsultantService consultantService;
	
	@RequestMapping(value = "reset-consultant-password", method = RequestMethod.POST)
	public ApplicationMessageResponse resetPassword(@RequestParam("email") String email,@RequestParam("newpassword") String newpassword) {
		consultantService.resetConsultantPassword(email,newpassword);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus("done");
		applicationMessageResponse.setMessage("Hey! password has been updated successfully for user "+email);
		return applicationMessageResponse;
	}
	

	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "consultant-topic-feedback", method = RequestMethod.GET)
	public String consultantTopicFeedback(HttpSession session,Model model) {
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<PendingTopicFeedbackForm> pendingFeedbackFormsList=consultantService.findPendingTopicFeedbacks(userId.getConsultantid());
		model.addAttribute("pendingFeedbackFormsList", pendingFeedbackFormsList);
		return UserNavigationPage.USER_BASE + NavigationPage.CONSULTANT_TOPIC_FEEDBACK_PAGE;
	}
	
	/**
	 * 
	 * @param feedbackInputData
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "consultant-topic-feedback-post", method = RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse  consultantTopicFeedbackPost(@ModelAttribute FeedbackInputData feedbackInputData,HttpSession session,Model model) {
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		feedbackInputData.setConsultantid(userId.getLoginId());
		feedbackInputData.setEmpid(userId.getConsultantid());
		consultantService.addTopicFeedback(feedbackInputData);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setMessage(ApplicationMessageConstant.FEEDBACK_IS_UPLOADED_SUCCESSFULLY_INTO_DATABASE);
		return applicationMessageResponse;
	}
}
