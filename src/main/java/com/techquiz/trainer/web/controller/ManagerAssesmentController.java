package com.techquiz.trainer.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.synergisitic.it.navigation.ManagerNavigationPage;
import com.synergisitic.it.service.TopicsService;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.Technology;
import com.techquiz.programys.common.vo.TopicVO;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.service.IManagerAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantSessionDetailWrapperVO;
import com.techquiz.trainer.web.controller.vo.CourseContentsDetailVO;
import com.techquiz.trainer.web.controller.vo.TrainerLoadVO;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Controller
public class ManagerAssesmentController {

	@Autowired
	@Qualifier("ManagerAssesmentService")
	private IManagerAssesmentService managerAssesmentService;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("TopicsServiceImpl")
	private TopicsService topicsService;
	
/*	@RequestMapping(value="trainer-session-detail",method=RequestMethod.GET)
	public String trainerSessionDetail(Model model){
		Map<String,String> trainerName=managerAssesmentService.findAllTrainer();
		ConsultantsVO consultantVO=new ConsultantsVO();
		model.addAttribute("trainerName", trainerName);
		model.addAttribute("consultantVO", consultantVO);
		return ManagerNavigationPage.MANAGER_BASE+ManagerNavigationPage.SHOW_TRAINER_DETAIL;
	}
	*/
	@RequestMapping(value="trainer-session-detail",method=RequestMethod.GET)
	public String showSessionBatch(Model model) {
		TrainingSessionsDetailVO trainingSessionsDetailVO=new TrainingSessionsDetailVO();
		model.addAttribute("trainingSessionsDetailVO",trainingSessionsDetailVO);
		return ManagerNavigationPage.MANAGER_BASE+ManagerNavigationPage.SHOW_TRAINER_DETAIL;
	}
	
	@RequestMapping(value="find-Trainer-SessionDetail-By-Tid",method=RequestMethod.GET)
	public @ResponseBody List<TrainingSessionsDetailVO> findTrainerSessionDetailByTid(
			@RequestParam("trainerId") String trainerId,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate ) {
		
		List<TrainingSessionsDetailVO> trainingSessionsDetailList=
				managerAssesmentService.findTrainerSessionDetailByTid(trainerId,startDate,endDate);
		
		return trainingSessionsDetailList;
	}
	
	@RequestMapping(value="find-all-Trainer-SessionDetail",method=RequestMethod.GET)
	public @ResponseBody ConsultantSessionDetailWrapperVO findAllTrainerSessionDetail(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate ,Model model) {
		System.out.println("hello============================"+startDate);
		Map<String,List<TrainingSessionsDetailVO>> trainingSessionsDetailList=
				managerAssesmentService.findAllTrainerSessionDetail(startDate,endDate);
		//List<TrainingSessionsDetailVO> tTotalSessionDuration=new ArrayList<TrainingSessionsDetailVO>();
		//List<TrainerLoadVO> trainerLoadVOs=new ArrayList<TrainerLoadVO>();
		Collection<TrainerLoadVO> trainerLoadVOsList=computeTrainerSessionLoad(trainingSessionsDetailList);
		//List<TrainingSessionsDetailVO> tTotalSessionDuration=managerAssesmentService.findTrainerTotalSessionDuration();
		ConsultantSessionDetailWrapperVO consultantSessionDetailWrapperVO=new ConsultantSessionDetailWrapperVO();
		consultantSessionDetailWrapperVO.setTrainerSessionDetailMap(trainingSessionsDetailList);
		consultantSessionDetailWrapperVO.setTrainerLoadVOsList(trainerLoadVOsList);
		return consultantSessionDetailWrapperVO;
	}
	
	@RequestMapping(value="findOneTrainerSessionsDetailPrev",method=RequestMethod.GET)
	public @ResponseBody List<TrainingSessionsDetailVO> findPrevOneTrainerSessionsDetail(@RequestParam("trainerId") String trainerId,HttpSession session) {
		
		String dates[]=DateUtils.previousDate();
		String startDate=dates[0];
		String endDate=null;
		for(String d:dates){
			if(d!=null){
				endDate=d;
			}
			 
		}
		
		dates=startDate.split("-");
		startDate=dates[1]+"/"+dates[2]+"/"+dates[0];
		dates=endDate.split("-");
		endDate=dates[1]+"/"+dates[2]+"/"+dates[0];
		session.setAttribute("startDate", startDate);
		List<TrainingSessionsDetailVO> trainingSessionsDetailList=
				managerAssesmentService.findTrainerSessionDetailByTid(trainerId,startDate,endDate);
		
		return trainingSessionsDetailList;
	}
	
	@RequestMapping(value="findOneTrainerSessionDetailPrevDays",method=RequestMethod.GET)
	public @ResponseBody List<TrainingSessionsDetailVO> findOneTrainerSessionDetailPrevDays(@RequestParam("trainerId") String trainerId,HttpSession session) {
		String endDate=(String)session.getAttribute("startDate");
		String startDate=endDate;
		String dates[]=startDate.split("/");
		startDate=dates[2]+"-"+dates[0]+"-"+dates[1];
		List<String> prevDates=new ArrayList<String>();
		prevDates=DateUtils.prevOfPreviousDate(startDate);
		startDate=prevDates.get(0);
		dates=startDate.split("-");
		startDate=dates[1]+"/"+dates[2]+"/"+dates[0];
		session.setAttribute("startDate", startDate);
		List<TrainingSessionsDetailVO> trainingSessionsDetailList=
				managerAssesmentService.findTrainerSessionDetailByTid(trainerId,startDate,endDate);
		return trainingSessionsDetailList;
	}
	
	@RequestMapping(value="findCurrentWeekAllTrainerSessionDetail",method=RequestMethod.GET)
	public @ResponseBody ConsultantSessionDetailWrapperVO findCurrentWeekAllTrainerSessionDetail(HttpSession session,Model model) {
		
		String dates[]=DateUtils.previousDate();
		String startDate=dates[0];
		String endDate=null;
		for(String d:dates){
			if(d!=null){
				endDate=d;
			}
			 
		}
		dates=startDate.split("-");
		startDate=dates[1]+"/"+dates[2]+"/"+dates[0];
		dates=endDate.split("-");
		endDate=dates[1]+"/"+dates[2]+"/"+dates[0];
		session.setAttribute("startDateForAllEmp", startDate);
		Map<String,List<TrainingSessionsDetailVO>> trainingSessionsDetailList=
				managerAssesmentService.findAllTrainerSessionDetail(startDate,endDate);
		List<TrainingSessionsDetailVO> tTotalSessionDuration=managerAssesmentService.findTrainerTotalSessionDuration();
		Collection<TrainerLoadVO> trainerLoadVOsList=computeTrainerSessionLoad(trainingSessionsDetailList);
		//List<TrainingSessionsDetailVO> tTotalSessionDuration=managerAssesmentService.findTrainerTotalSessionDuration();
		ConsultantSessionDetailWrapperVO consultantSessionDetailWrapperVO=new ConsultantSessionDetailWrapperVO();
		consultantSessionDetailWrapperVO.setTrainerSessionDetailMap(trainingSessionsDetailList);
		consultantSessionDetailWrapperVO.setTrainerLoadVOsList(trainerLoadVOsList);
		return consultantSessionDetailWrapperVO;
	}
	
	@RequestMapping(value="findAllTrainerSessionDetailPrevDays",method=RequestMethod.GET)
	public @ResponseBody ConsultantSessionDetailWrapperVO findAllTrainerSessionDetailPrevDays(HttpSession session,Model model) {
		String endDate=(String)session.getAttribute("startDateForAllEmp");
		String startDate=endDate;
		String dates[]=startDate.split("/");
		startDate=dates[2]+"-"+dates[0]+"-"+dates[1];
		List<String> prevDates=new ArrayList<String>();
		prevDates=DateUtils.prevOfPreviousDate(startDate);
		startDate=prevDates.get(0);
		dates=startDate.split("-");
		startDate=dates[1]+"/"+dates[2]+"/"+dates[0];
		session.setAttribute("startDate", startDate);
		Map<String,List<TrainingSessionsDetailVO>> trainingSessionsDetailList=
				managerAssesmentService.findAllTrainerSessionDetail(startDate,endDate);
		Collection<TrainerLoadVO> trainerLoadVOsList=computeTrainerSessionLoad(trainingSessionsDetailList);
		//List<TrainingSessionsDetailVO> tTotalSessionDuration=managerAssesmentService.findTrainerTotalSessionDuration();
		ConsultantSessionDetailWrapperVO consultantSessionDetailWrapperVO=new ConsultantSessionDetailWrapperVO();
		consultantSessionDetailWrapperVO.setTrainerSessionDetailMap(trainingSessionsDetailList);
		consultantSessionDetailWrapperVO.setTrainerLoadVOsList(trainerLoadVOsList);
		return consultantSessionDetailWrapperVO;
	}
	
	
	@ModelAttribute("trainerNameList")
	public Map<String,String> fetchTrainersList(){
		Map<String,String> trainerNameList=managerAssesmentService.findAllTrainer();
		return trainerNameList;
	}
	
	private Collection<TrainerLoadVO> computeTrainerSessionLoad(Map<String,List<TrainingSessionsDetailVO>> trainingSessionsDetailList){
		Set<Map.Entry<String, List<TrainingSessionsDetailVO>>> trainingSessionsDetailVOSet=trainingSessionsDetailList.entrySet();
		Map<String,TrainerLoadVO> trainerLoadVOsMap=new LinkedHashMap<String, TrainerLoadVO>();
		for(Map.Entry<String, List<TrainingSessionsDetailVO>> tentry:trainingSessionsDetailVOSet){
			List<TrainingSessionsDetailVO> trainingSessionsDetailVOsList=tentry.getValue();
			for(TrainingSessionsDetailVO trainingSessionsDetailVO:trainingSessionsDetailVOsList){
					if(trainerLoadVOsMap.containsKey(trainingSessionsDetailVO.getUserid())){
						TrainerLoadVO trainerLoadVO=trainerLoadVOsMap.get(trainingSessionsDetailVO.getUserid());
						trainerLoadVO.setLoad(trainerLoadVO.getLoad()+Float.parseFloat(trainingSessionsDetailVO.getTimeduration()));
					}else{
						TrainerLoadVO trainerLoadVO=new TrainerLoadVO();
						trainerLoadVO.setUserid(trainingSessionsDetailVO.getUserid());
						trainerLoadVO.setLoad(Float.parseFloat(trainingSessionsDetailVO.getTimeduration()));
						trainerLoadVO.setName(trainingSessionsDetailVO.getName());
						trainerLoadVO.setColor(trainingSessionsDetailVO.getColor());
						trainerLoadVOsMap.put(trainingSessionsDetailVO.getUserid(),trainerLoadVO);
					}
			}
		}
		Collection<TrainerLoadVO> trainerLoadVOsList=trainerLoadVOsMap.values();
		return trainerLoadVOsList;
	}
	
	@RequestMapping(value="findAllTopicsforManager",method=RequestMethod.GET)
	public String findAllTopicsforManager(Model model){
		
		Technology tech=new Technology();
		Map<Integer, String> languageList = consultantAssesmentService.findAllLanguages();
		model.addAttribute("techList",languageList);
		model.addAttribute("tech",tech);
		return ManagerNavigationPage.MANAGER_BASE+ManagerNavigationPage.SHOW_ALL_TECHNOLOGY_TOPICS;
	}
	
	@RequestMapping(value="findAllTopicsForManagerByTidAjax",method=RequestMethod.GET)
	public @ResponseBody TopicVO findAllTopicsforManager(@RequestParam("tid") String tid){
		
		List<TopicVO> topicList=topicsService.findTopicsByLanguageId(tid);
		String topic="";
		for(TopicVO t:topicList){
			topic=topic+t.getTopic()+" , ";
		}
		TopicVO topicVO=new TopicVO();
		topicVO.setTopic(topic);
		return topicVO;
	}
	
	@RequestMapping(value="courseStructureForManager",method=RequestMethod.GET)
	public String courseStructureForManager(Model model){
		
		CourseContentsDetailVO courseContentsDetailVO = new CourseContentsDetailVO();
		List<String> courseList = consultantAssesmentService.findAvailableCourses();
		model.addAttribute("courseList", courseList);
		model.addAttribute("courseContentsDetailVO", courseContentsDetailVO);
		return ManagerNavigationPage.MANAGER_BASE+ManagerNavigationPage.COURSE_STRUCTURE;
	}
	
	@RequestMapping(value="findAllCourseContentsTopics",method=RequestMethod.GET)
	public Map<String,List<CourseContentsDetailVO>> findAllCourseContentsTopics(@RequestParam("course") String course,Model model){
		
		Map<String,List<CourseContentsDetailVO>> courseTopicsMap=managerAssesmentService.findAllCourseContentsTopics(course);
		Map<String,List<CourseContentsDetailVO>> cContentesTopicsMap=new LinkedHashMap<String, List<CourseContentsDetailVO>>();
		Set<Map.Entry<String, List<CourseContentsDetailVO>>> entries=courseTopicsMap.entrySet();
		for(Map.Entry<String, List<CourseContentsDetailVO>> entry:entries){
			List<CourseContentsDetailVO> cList=new ArrayList<CourseContentsDetailVO>();
			List<CourseContentsDetailVO> contentsDetailVOs=entry.getValue();
			String topics="";
			String techLogo=null;
			for(CourseContentsDetailVO contentsDetailVO:contentsDetailVOs){
				topics=topics+contentsDetailVO.getTopicname()+" <b>,</b>  ";
				techLogo=contentsDetailVO.getTechnologyname();
			}
			CourseContentsDetailVO cContents=new CourseContentsDetailVO();
			cContents.setTopicname(topics);
			cContents.setTechnologyname(techLogo);
			cList.add(cContents);
			cContentesTopicsMap.put(entry.getKey(),cList);
		}
		return cContentesTopicsMap;
	}
	
}



