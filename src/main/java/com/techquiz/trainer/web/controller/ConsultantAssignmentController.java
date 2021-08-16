package com.techquiz.trainer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisitic.it.email.service.UserEmailService;
import com.synergisitic.it.navigation.ManagerNavigationPage;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.TopicsService;
import com.techquiz.programys.common.service.IContentsService;
import com.techquiz.trainer.service.IConsultantAssesmentService;

@Controller
public class ConsultantAssignmentController {

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

	
	
	@RequestMapping(value = "findConsultantByBatchForManager", method = RequestMethod.GET)
	public String showActiveBatch(Model model) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		model.addAttribute("nextAction", "startConsultantInterview");
		model.addAttribute("pageTitle", "Consultant Screening Interview");
		model.addAttribute("nextTitle", "Start");
		return ManagerNavigationPage.MANAGER_BASE
				+ ManagerNavigationPage.SHOW_CONSULTANT_BATCH;
	}
	

}
