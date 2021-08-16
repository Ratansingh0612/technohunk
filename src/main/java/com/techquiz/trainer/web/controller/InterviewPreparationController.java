package com.techquiz.trainer.web.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.web.form.Technology;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Controller
@Scope("singleton")
public class InterviewPreparationController {
	
		@Autowired
		@Qualifier("TechnolgyCategoryServiceImpl")
		private TechnolgyCategoryService technolgyCategoryService;
	
		@RequestMapping(value="interview-preparations",method=RequestMethod.GET)
		public String selectInterviewedTechnology(Model model) {
			TrainingSessionsDetailVO trainingSessionsDetailVO = new TrainingSessionsDetailVO();
			model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVO);
			return "interviewqa/select-interviewed-technology";
		}
	
		
		@ModelAttribute("technologyList")
		public Map<String, String> technologyList() {
			// Data referencing for web framework combo
			List<Technology> technologies = technolgyCategoryService
					.findAllTechnolgy();
			Map<String, String> technologiesMap = new LinkedHashMap<String, String>();
			for (Technology technology : technologies) {
				technologiesMap.put(technology.getId() + "", technology.getTname());
			}
			return technologiesMap;
		}
			
}
