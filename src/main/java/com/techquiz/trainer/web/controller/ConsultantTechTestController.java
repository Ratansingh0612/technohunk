package com.techquiz.trainer.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.navigation.ConsultantNavigationPage;
import com.synergisitic.it.report.model.OCJPReportCard;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;

/**
 * 
 * @author Nagendra
 *
 */
@Controller
public class ConsultantTechTestController {
	

	@Autowired
	@Qualifier("AdminServiceImpl")
	private AdminService adminService;


	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;

	@RequestMapping(value = "consultant-exam-detail", method = RequestMethod.GET)
	public String showExamDetail(Model model, HttpServletRequest request) {
		String testName = request.getParameter("testName");
		String techName = request.getParameter("techName");
		String consultantId = request.getParameter("consultantId");
		String userSessionId = request.getParameter("userSessionId");
		List<OCJPReportCard> testConfiguration=null;
		if(userSessionId==null)
			testConfiguration = adminService.findReportCardByUseridAndTest(consultantId, techName,testName);
		else
			testConfiguration = adminService.findReportCardByUseridAndTechTestSessionId(consultantId, techName,testName,userSessionId);
				
		// System.out.println("User: "+userId);
		System.out.println("testName: " + testName);
		AvailableTest testData = onlineTechTestService.fetchAllQuestionsByTestName(testName,techName, consultantId,userSessionId, false);
		// System.out.println(testData.toString());
		String questionIdsInArray[] = testData.getQuestionIds().split(",");
		List<QuestionAndAnsTestDataVO> questionList = new ArrayList<QuestionAndAnsTestDataVO>();
		for (String q : questionIdsInArray) {
			QuestionAndAnsTestDataVO question = onlineTechTestService.fetchNextQuestionAnswer(q, consultantId, testName,techName,
					userSessionId);
			String selectedAnswerId = onlineTechTestService
					.findExamDetail(consultantId, testName,techName, userSessionId, q).getSelectedAnswerId();
			question.setSelectedOption(selectedAnswerId);
			questionList.add(question);
		}
		model.addAttribute("questionList", questionList);
		model.addAttribute("testName", testName);
		model.addAttribute("testConfiguration", testConfiguration.get(0));
		// List<UserOnlineExamStatusForm>
		// userOnlineExamStatusList=userService.findAllUserOnlineExamStatus(userId);
		// model.addAttribute("userOnlineExamStatusList",userOnlineExamStatusList);
		return ConsultantNavigationPage.TRAINER_BASE + NavigationPage.CONSULTANT_EXAM_DETAIL;
	}
}
