package com.techquiz.trainer.web.controller;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.TopicsService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.programys.common.vo.TopicVO;
import com.techquiz.trainer.service.InterviewQuestionsService;
import com.techquiz.trainer.web.controller.vo.InterviewQuestionsAnswerVO;

@Controller
@Scope("singleton")
public class InterviewQuestionsController {

	
	@Autowired
	@Qualifier("TopicsServiceImpl")
	private TopicsService iTopicService;
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	
	@Autowired
	@Qualifier("InterviewQuestionsServiceImpl")
	private InterviewQuestionsService interviewQuestionsService;
	
	@Autowired
	@Qualifier("TopicsServiceImpl")
	private TopicsService topicsService;
	
	@RequestMapping(value = "tech-questions-answer", method = RequestMethod.GET)
	public String showQuestionsAnswer(Model model) {
		InterviewQuestionsAnswerVO interviewQuestionsAnswerVO = new InterviewQuestionsAnswerVO();
		model.addAttribute("interviewQuestionsAnswerVO", interviewQuestionsAnswerVO);
		model.addAttribute("action","add-question-answer");
		List<String> topicListString=new ArrayList<String>();
		topicListString.add("Select Topic");
		model.addAttribute("topicList", topicListString);
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.TECH_QUESTIONS_ANSWER_PAGE; 
	}
	
	
	
	@RequestMapping(value = "tech-questions-answer", method = RequestMethod.POST)
	public String showQuestionsAnswerPost(@ModelAttribute("interviewQuestionsAnswerVO") InterviewQuestionsAnswerVO interviewQuestionsAnswerVO, Model model) {
		model.addAttribute("interviewQuestionsAnswerVO", interviewQuestionsAnswerVO);
		model.addAttribute("action","add-question-answer");
		List<TopicVO> topicList=topicsService.findTopicsByLanguageId(interviewQuestionsAnswerVO.getTechName());
		List<String> topicListString=new ArrayList<String>();
		topicListString.add("Select Topic");
		for(TopicVO topic:topicList){ 
			topicListString.add(topic.getTopic());
		}
		if(topicList!=null && topicList.size()>0)
		topicListString.add("All");
		
		model.addAttribute("topicList", topicListString);
		model.addAttribute("AppMessage", "Sorry! questions does not exist into the database for selected criteria...............");
		List<InterviewQuestionsAnswerVO> interviewQuestionsAnswerVOs=interviewQuestionsService.findInterviewQuestionsByTechTopic(interviewQuestionsAnswerVO.getTechName(), interviewQuestionsAnswerVO.getTopic(),interviewQuestionsAnswerVO.getComplexity());
		model.addAttribute("interviewQuestionsAnswerVOs", interviewQuestionsAnswerVOs);
		 return UserNavigationPage.TRAINER_BASE + UserNavigationPage.TECH_QUESTIONS_ANSWER_PAGE; 
	}
	

	@RequestMapping(value = "add-question-answer", method = RequestMethod.GET)
	public String addQuestionAnswer(Model model,HttpSession session) {
		InterviewQuestionsAnswerVO interviewQuestionsAnswerVO = new InterviewQuestionsAnswerVO();
			model.addAttribute("interviewQuestionsAnswerVO", interviewQuestionsAnswerVO);
			model.addAttribute("action","add-question-answer");
		
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.ADD_QUESTION_ANSWER_PAGE; 
	}
	
	@RequestMapping(value="add-question-answer",method=RequestMethod.POST)
	public String addQuestionAnswer(@ModelAttribute("interviewQuestionsAnswerVO") InterviewQuestionsAnswerVO  interviewQuestionsAnswerVO,HttpSession session,Model model){
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);	
		interviewQuestionsAnswerVO.setUserid(userId.getLoginId());
		interviewQuestionsAnswerVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		String result=interviewQuestionsService.addInterviewQuestionAnswer(interviewQuestionsAnswerVO);
		/*ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		appMsg.setStatus("yes");
		appMsg.setMessage(ApplicationMessageConstant.QUESTION_AND_ANSWER_IS_UPLOADED_INTO_DATABASE);*/
		//interviewQuestionsAnswerVO = new InterviewQuestionsAnswerVO();
		//interviewQuestionsAnswerVO.setTechName(interviewQuestionsAnswerVO.getTechName());
	//	interviewQuestionsAnswerVO.setTopic(interviewQuestionsAnswerVO.getTopic());
		model.addAttribute("interviewQuestionsAnswerVO", interviewQuestionsAnswerVO);
		List<TopicVO> topicList=topicsService.findTopicsByLanguageId(interviewQuestionsAnswerVO.getTechName());
		List<String> topicListString=new ArrayList<String>();
		topicListString.add("Select Topic");
		for(TopicVO topic:topicList){ 
			topicListString.add(topic.getTopic());
		}
		if(topicList!=null && topicList.size()>0)
		topicListString.add("All");
		model.addAttribute("topicList", topicListString);
		model.addAttribute("action","add-question-answer");
		model.addAttribute("AppMessage",ApplicationMessageConstant.QUESTION_AND_ANSWER_IS_UPLOADED_INTO_DATABASE);
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.ADD_QUESTION_ANSWER_PAGE; 
	}
	

	@ModelAttribute("techList")
	public List<String> loadTechList() {
		//Data referencing for web framework combo
		List<String> techList = new ArrayList<>();
		List<com.synergisitic.it.web.form.Technology> availableTechList =technolgyCategoryService.findAllTechnolgy();
		techList.add("Select Technology");
		for(com.synergisitic.it.web.form.Technology tech: availableTechList){
			techList.add(tech.getTname());
		}
		if(techList!=null && techList.size()>0)
		techList.add("All");
		return techList;
	}
	
	@ModelAttribute("technologyList")
	public Map<Integer,String> populateTechnologyList() {
		//Data referencing for web framework combo
		Map<Integer,String> technologyList = new LinkedHashMap<Integer,String>();
		/*technologyList.add("Spring MVC");
		technologyList.add("Spring");
		technologyList.add("Oracle");
		technologyList.add("JSF");
		technologyList.add("Core Java");
		technologyList.add("JSP");
		technologyList.add("Servlet");
		technologyList.add("Hibernate");
		technologyList.add("Struts2.0");*/
		technologyList.put(0,"Select Technology");
		List<com.synergisitic.it.web.form.Technology> availableTechList =technolgyCategoryService.findAllTechnolgy();
		for(com.synergisitic.it.web.form.Technology tech: availableTechList){
			technologyList.put(tech.getId(),tech.getTname());
		}
		return technologyList;
	}
	

	@ModelAttribute("questionComplexityList")
	public List<String> questionComplexityList() {
		// Data referencing for web framework combo
		List<String> questionComplexityList = new ArrayList<String>();
		questionComplexityList.add("LOWER");
		questionComplexityList.add("MEDIUM");
		questionComplexityList.add("HIGH");
		questionComplexityList.add("ALL");
		return questionComplexityList;
	}
}
