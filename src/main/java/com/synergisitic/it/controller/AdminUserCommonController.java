package com.synergisitic.it.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.UserId;
import com.synergisitic.it.web.form.UserListInput;



/**
 * 
 * @author nagendra.yadav
 *
 */
@Controller
public class AdminUserCommonController extends AbstractUserSession{
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(AdminUserCommonController.class);
	
	@Autowired
	@Qualifier("UserAdminCommonServiceImpl")
	private UserAdminCommonService userAdminCommonService;
	
	
	/**
	 * This method display the list of all the assigned questions for the selected 
	 * technology
	 * @return
	 */
	@RequestMapping(value="questionsBankList",method=RequestMethod.GET)
	public String questionsBankList(Model model,@RequestParam("selectedTech") String selectedTech,HttpSession session) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method questionsBankList.");
		}
		String userid=getUserIdFromSession(session).getLoginId();
		UserListInput userListInput=new UserListInput();
		userListInput.setQuestionComplexity("None");
		model.addAttribute("userListInput", userListInput);
		List<QuestionsForm> assignedQuestion=userAdminCommonService.findAllQuestionByTechAndUser(selectedTech, userid);
		model.addAttribute("questionsList", assignedQuestion);
		model.addAttribute("techName",selectedTech);
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.AVAILABLE_QUESTIONS_LIST_PAGE;
	}
	
	@RequestMapping(value="aquestionsBankList",method=RequestMethod.POST)
	public String aquestionsBankListPost(Model model,@ModelAttribute("UserListInput") UserListInput userListInput,@RequestParam(value="questionComplexity",required=false) String questionComplexity,@RequestParam("selectedTech") String selectedTech,HttpSession session) {
	 return	aquestionsBankList(model,userListInput,selectedTech,session);
	}
	
	@RequestMapping(value="aquestionsBankList",method=RequestMethod.GET)
	public String aquestionsBankList(Model model,@ModelAttribute("UserListInput") UserListInput userListInput,@RequestParam("selectedTech") String selectedTech,HttpSession session) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method aquestionsBankList.");
		}
	   //	String userid=getUserIdFromSession(session).getLoginId();
		List<QuestionsForm> assignedQuestion=userAdminCommonService.findAllQuestionByTechAndUser(selectedTech);
		List<QuestionsForm> filteredAssignedQuestion=new ArrayList<QuestionsForm>();
		model.addAttribute("questionsList", assignedQuestion);
		//userListInput.setQuestionComplexity("None");
		model.addAttribute("userListInput", userListInput);
		if(userListInput!=null && userListInput.getQuestionComplexity()!=null && !"None".equalsIgnoreCase(userListInput.getQuestionComplexity())) {
			for(QuestionsForm questionsForm:assignedQuestion){
					if(questionsForm.getQuestionComplexity()!=null && questionsForm.getQuestionComplexity().equalsIgnoreCase(userListInput.getQuestionComplexity())){
						filteredAssignedQuestion.add(questionsForm);
					}
			}
			model.addAttribute("questionsList", filteredAssignedQuestion);
		}
		if(assignedQuestion!=null && assignedQuestion.size()>0) {
			model.addAttribute("questionOwner", assignedQuestion.get(0).getQuestionOwner());
		}
		model.addAttribute("techName",selectedTech);
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.AVAILABLE_QUESTIONS_LIST_PAGE;
	}
	
	@RequestMapping(value="aquestionsUserBankList",method=RequestMethod.GET)
	public String aquestionsUserBankList(Model model,@RequestParam("selectedTech") String selectedTech,@RequestParam("qBankName") String qBankName,HttpSession session) {
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method aquestionsBankList.");
		}
	   String userid=getUserIdFromSession(session).getLoginId();
		List<QuestionsForm> assignedQuestion=userAdminCommonService.findAllQuestionInByBankTechAndUserId(qBankName,userid,selectedTech);
		UserListInput userListInput=new UserListInput();
		userListInput.setQuestionComplexity("None");
		model.addAttribute("userListInput", userListInput);
		model.addAttribute("questionsList", assignedQuestion);
		if(assignedQuestion!=null && assignedQuestion.size()>0) {
			model.addAttribute("questionOwner", assignedQuestion.get(0).getQuestionOwner());
		}
		model.addAttribute("techName",selectedTech);
		model.addAttribute("qBankName",qBankName);
		return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.AVAILABLE_USER_QUESTIONS_LIST_PAGE;
	}
	

	@Override
	public UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
	
	@ModelAttribute("questionsComplexity")
		public List<String> questionComplexityList() {
			//Data referencing for web framework combo
			List<String> questionComplexityList = new ArrayList<String>();
			questionComplexityList.add("None");
			questionComplexityList.add("LOWER");
			questionComplexityList.add("MEDIUM");
			questionComplexityList.add("HIGH");
			return questionComplexityList;
		}

}
