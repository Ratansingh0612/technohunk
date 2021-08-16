package com.techquiz.programys.common.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.SpringTransactionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronizationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.controller.TechnologyController;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.TopicsService;
import com.techquiz.programys.common.vo.TopicVO;

@Controller
public class CourseContentsController {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(TechnologyController.class);
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	

	@Autowired
	@Qualifier("TopicsServiceImpl")
	private TopicsService topicsService;

	@RequestMapping(value = "course-contents", method = RequestMethod.GET)
	public String showSessionSchedule(Model model) {
	
		
		List<com.synergisitic.it.web.form.Technology>  technologies=technolgyCategoryService.findAllTechnolgy();
		model.addAttribute("technologies", technologies);
		return UserNavigationPage.USER_BASE + UserNavigationPage.COURSE_CONTENTS_PAGE;

	}
	
	@RequestMapping(value = "course-details", method = RequestMethod.GET)
	public String courseDetails(@RequestParam("tid") String tid,Model model) {
		List<TopicVO> topicList=topicsService.findTopicsByLanguageId(tid);
		model.addAttribute("topicList", topicList);
		return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.COURSE_DETAILS_PAGE;

	}
	
	
	
	
}
