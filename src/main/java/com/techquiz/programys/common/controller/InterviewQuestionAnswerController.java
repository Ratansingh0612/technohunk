package com.techquiz.programys.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.navigation.UserNavigationPage;
import com.techquiz.trainer.service.InterviewQuestionsService;
import com.techquiz.trainer.web.controller.vo.InterviewQuestionsAnswerVO;

/**
 * @author nagendra
 * @since 14-06-2018
 */
@Controller
public class InterviewQuestionAnswerController {

	@Autowired
	@Qualifier("InterviewQuestionsServiceImpl")
	private InterviewQuestionsService interviewQuestionsService;
	
	@GetMapping("important-interview-question-answer")
	public String fetchCoreJavaInterviewQuestions(@RequestParam("techName") String techName,Model model) {
		List<InterviewQuestionsAnswerVO> interviewQuestionsAnswerVOs=interviewQuestionsService.findInterviewQuestionsByTechTopic(techName,"All","All");
		String stechName="NA";
		if(interviewQuestionsAnswerVOs!=null && interviewQuestionsAnswerVOs.size()>0){
			stechName=interviewQuestionsAnswerVOs.get(0).getTechName();
		}
		model.addAttribute("stechName", stechName);
		model.addAttribute("interviewQuestionsAnswerVOs", interviewQuestionsAnswerVOs);
		return UserNavigationPage.PUBLIC_BASE + UserNavigationPage.IMPORTANT_INTERVIEW_QUESTION_ANSWER_PAGE;
	}
	
	/*@GetMapping("spring-interview-question-answer")
	public String fetchSpringInterviewQuestions(@RequestParam("techName") String techName,Model model) {
		List<InterviewQuestionsAnswerVO> interviewQuestionsAnswerVOs=interviewQuestionsService.findInterviewQuestionsByTechTopic(techName,"All","All");
		model.addAttribute("interviewQuestionsAnswerVOs", interviewQuestionsAnswerVOs);
		return UserNavigationPage.PUBLIC_BASE + UserNavigationPage.SPRING_INTERVIEW_QUESTION_ANSWER_PAGE;
	}*/

}
