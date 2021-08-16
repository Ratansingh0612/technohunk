package com.techquiz.programys.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisitic.it.navigation.CommonNavigationPage;
import com.techquiz.programys.common.service.ISessionSchedule;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Controller
public class SessionScheduleController {
	
	@Autowired
	@Qualifier("SessionSchedule")
	private ISessionSchedule sessionScheduleService;
	
	@RequestMapping(value="show-session-schedule",  method=RequestMethod.GET)
	public String showSessionSchedule(Model model)
	{
		List<TrainingSessionsDetailVO> trainingSessionsDetailVOList=sessionScheduleService.findActiveSessionSchedule();
		model.addAttribute("trainingSessionsDetailVOList", trainingSessionsDetailVOList);
		return CommonNavigationPage.COMMON_BASE
				+ CommonNavigationPage.SHOW_SESSION_SCHEDULE;
		
	}
	

}
