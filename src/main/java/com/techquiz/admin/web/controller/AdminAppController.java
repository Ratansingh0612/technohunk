package com.techquiz.admin.web.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.StreamService;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.AppUtility;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.StreamForm;
import com.synergisitic.it.web.form.UserForm;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.trainer.web.controller.BatchVO;
import com.techquiz.trainer.web.rest.api.vo.ApprovePendingUserVO;


@Controller
public class AdminAppController {
	
	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	
	
	@Autowired
	@Qualifier("StreamServiceImpl")
	private StreamService streamService;
	
	@Autowired
	@Qualifier("UserAdminCommonServiceImpl")
	private UserAdminCommonService userAdminCommonService;
	
	
	@RequestMapping(value = "reset-user-passsword", method = RequestMethod.GET)
	@ResponseBody
	public ApplicationMessageResponse resetUserPasssword(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("newpassword") String newpassword) {
		userService.resetConsultantPassword(username, email, newpassword);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus("success");
		applicationMessageResponse.setMessage("Password has been updated successfully for username =  "+username);
		return applicationMessageResponse;
	}
	
	@RequestMapping(value = "reset-group-passsword", method = RequestMethod.GET)
	public String resetGroupPassswords(@RequestParam("groupName") String batchName) {
		userService.resetGroupPasswords(batchName,"ot@123");
		return "redirect:/action/show-all-consultants?batchName="+batchName;
	}
	
	
	@RequestMapping(value = "delete-consultant-form-batch", method = RequestMethod.GET)
	public String resetGroupPassswords(@RequestParam("email") String email,@RequestParam("groupName") String batchName) {
		userService.deleteConsultant(batchName,email);
		return "redirect:/action/show-all-consultants?batchName="+batchName+"&message="+"Consultant is deleted successfully with email "+email;
	}
	
	
	
	
	@RequestMapping(value = "pending-users-accounts", method = RequestMethod.GET)
	public String pendingUsersAccounts(Model model,HttpSession session) {
		ApprovePendingUserVO approvePendingUserVO=new ApprovePendingUserVO();
		model.addAttribute("approvePendingUserVO", approvePendingUserVO);
		List<UserForm> userFormList = userService.findAllUserByRole(ApplicationContant.USER_ROLE);
		//Generate unique id for all the consultants
		for (UserForm userForm : userFormList) {
			userForm.setEmpid(AppUtility.empCodeGen9Digit());
		}
		model.addAttribute("userFormList", userFormList);
		model.addAttribute("imageURL", "action/findConsultantImage");
		return UserNavigationPage.ADMIN_BASE + UserNavigationPage.PENDING_USERS_ACCOUNTS__PAGE;
	}
	
	

	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@ModelAttribute(value="findstreams")
	public Map<Integer,String> findStream(){
		List<StreamForm> streamList=streamService.findStreams();
		Map<Integer,String> maps=new  LinkedHashMap<Integer,String>();
		for(StreamForm streamForm : streamList){
			maps.put(streamForm.getSid(), streamForm.getStream());
		}
		return maps;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@ModelAttribute(value="findbatches")
	public Map<Integer,String>  findBatches(){
		 List<BatchVO> batchList=userAdminCommonService.findBatches();
		 Map<Integer,String> maps=new  LinkedHashMap<Integer,String>();
			for(BatchVO batchVO : batchList){
				maps.put(batchVO.getBid(), batchVO.getBatch());
			}
			return maps;
	}
	

}
