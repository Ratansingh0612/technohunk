package com.techquiz.trainer.web.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.synergisitic.it.model.User;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.ConsultantNavigationPage;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.Technology;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantAssignmentVO;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;
import com.techquiz.trainer.web.controller.vo.TimeEditor;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Controller
@Scope("singleton")
public class TrainingSessionController {
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;

	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;

	
	@RequestMapping(value = "addSessionSchedule", method = RequestMethod.GET)
	public String showSessionBatch(Model model) {
		TrainingSessionsDetailVO trainingSessionsDetailVO = new TrainingSessionsDetailVO();
		model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVO);
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		if (batchList != null && batchList.size() > 0) {
			String currentBatch = batchList.get(batchList.size() - 1);
			model.addAttribute("currentBatch", currentBatch);
			List<ConsultantsVO> consultantsVOList = consultantAssesmentService
					.findConsultantsByBatch(currentBatch);
			model.addAttribute("consultantList", consultantsVOList);
		}
		model.addAttribute("batchList", batchList);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.ADD_SESSION_SCHEDULE;
	}
	
	
	@RequestMapping(value = "addSessionSchedule", method = RequestMethod.POST)
	public String addSessionDetail(
			@ModelAttribute("trainingSessionsDetailVO") TrainingSessionsDetailVO trainingSessionsDetailVO,
			HttpSession session, Model model) {
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		trainingSessionsDetailVO.setUserid(userSession.getLoginId());
		trainingSessionsDetailVO
				.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		trainingSessionsDetailVO
				.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		//consultantAssesmentService
			//	.saveTrainingSessionSchedule(trainingSessionsDetailVO);
		trainingSessionsDetailVO = new TrainingSessionsDetailVO();
		model.addAttribute("trainingSessionsDetailVO", trainingSessionsDetailVO);
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		model.addAttribute("ApplicationMessage",
				"Training Session detail has been saved successfully.............");
		// return
		// ConsultantNavigationPage.TRAINER_BASE+ConsultantNavigationPage.SHOW_SESSION_BATCH;
		model.addAttribute(
				ApplicationMessageConstant.APPLICATION_MESSAGE,
				ApplicationMessageConstant.TRAINING_SESSION_SCHEDULE_HAS_BEEN_SAVED_SUCCESSFULLY);
		return CommonNavigationPage.COMMON_BASE
				+ CommonNavigationPage.SUCCESS_STATUS_PAGE;
	}
	
	
	@RequestMapping(value = "showSessionsSchedules", method = RequestMethod.GET)
	public String showSessionsSchedules(Model model) {
		List<TrainingSessionsDetailVO> sessionsDetailVOsList=consultantAssesmentService.findAllSessionsSchedule();
		List<String> batchList=new ArrayList<String>();
		String color="yellow";
		for(TrainingSessionsDetailVO trainingSessionsDetailVO:sessionsDetailVOsList) {
			 	  	if(!batchList.contains(trainingSessionsDetailVO.getBatch())){
			 	  		batchList.add(trainingSessionsDetailVO.getBatch());
			 	  		color="pink";
			 	  	}
			 	  	trainingSessionsDetailVO.setColor(color);
		}
		model.addAttribute("sessionsDetailVOsList", sessionsDetailVOsList);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_SESSIONS_SCHEDULES_PAGE;
	}
	

	@ModelAttribute("questionComplexityList")
	public List<String> questionComplexityList() {
		// Data referencing for web framework combo
		List<String> questionComplexityList = new ArrayList<String>();
		questionComplexityList.add("LOWER");
		questionComplexityList.add("MEDIUM");
		questionComplexityList.add("HIGH");
		return questionComplexityList;
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		// it will convert byte stream into array of bytes
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(Time.class, new TimeEditor());
	}
	
	@ModelAttribute("trainerNameList")
	public Map<String,String> loadTrainerList() {
		List<User> trainerList=consultantAssesmentService.findAllTrainers();
		Map<String,String> trainersMap=new LinkedHashMap<String, String>();
		for(User user:trainerList){
			String name=user.getFirstName();
			if(user.getLastName()!=null) {
				name=name+" "+user.getLastName();
			}
			trainersMap.put(user.getLoginid(), name);
		}
		return trainersMap;
	}
	
	@RequestMapping(value = "get-batch-for-assignment-trainer", method = RequestMethod.GET)
	public String getBatchForAssignmentTrainer(Model model) {
		
		ConsultantAssignmentVO assignmentVO=new ConsultantAssignmentVO();
		model.addAttribute("assignmentVO", assignmentVO);
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		if (batchList != null && batchList.size() > 0) {
			String currentBatch = batchList.get(batchList.size() - 1);
			model.addAttribute("currentBatch", currentBatch);
			List<ConsultantsVO> consultantsVOList = consultantAssesmentService
					.findConsultantsByBatch(currentBatch);
			model.addAttribute("consultantList", consultantsVOList);
		}
		model.addAttribute("batchList", batchList);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_BATCH_FOR_ASSIGNMENT_PAGE;
	}
	
	@RequestMapping(value = "addAssignmentToConsultant", method = RequestMethod.POST)
	public String addAssignmentToConsultant(@ModelAttribute("assignmentVO") ConsultantAssignmentVO assignmentVO,Model model,HttpSession session) {
		
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		assignmentVO.setUserid(userSession.getLoginId());
		assignmentVO
				.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		assignmentVO
				.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		
		//consultantAssesmentService.addAssignmentToConsultant(assignmentVO);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.SHOW_BATCH_FOR_ASSIGNMENT_PAGE;
	}

}
