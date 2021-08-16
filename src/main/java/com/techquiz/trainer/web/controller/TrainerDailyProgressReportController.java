package com.techquiz.trainer.web.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.navigation.ConsultantNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.TrainingSessionService;
import com.synergisitic.it.service.Userervice;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.Technology;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.TrainerDailySessionReport;
import com.techquiz.trainer.web.controller.vo.TrainerSessionVO;

/**
 * 
 * @author nagendra
 *
 */
@Controller
public class TrainerDailyProgressReportController {
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("TrainingSessionServiceImpl")
	private TrainingSessionService trainingSessionService;
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	
	@Autowired
	private Userervice userervice;
	
	
	@RequestMapping(value = "delete-trainer-session", method = RequestMethod.POST)
	 public String  deleteTrainerSession(@RequestParam("tsid") int  tsid){
				TrainerSessionVO trainerSessionVO=new TrainerSessionVO();
				trainerSessionVO.setTsid(tsid);
				trainingSessionService.deleteTrainerSession(trainerSessionVO);
			/*	ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
				applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
				applicationMessageResponse.setMessage(ApplicationMessageConstant.TRAINER_SESSION_IS_DELETE_SUCCESSFULLY_INTO_DATABASE);*/
				return "redirect:/action/trainer-session-schedule?ApplicationMessage="+ApplicationMessageConstant.TRAINER_SESSION_IS_DELETE_SUCCESSFULLY_INTO_DATABASE;
		}		 
	
	@RequestMapping(value = "add-trainer-session", method = RequestMethod.POST)
 public String addTrainerSession(@RequestParam("techName") String techid,
			@RequestParam("batchName") String batchName,@RequestParam("trainerName") String trainerName,@RequestParam("meeting") String meeting,
			HttpSession session,Model model) {
		String tokesn[]=trainerName.split("-");
		String ptrainerName=tokesn[0];
		//Validation check to add new session.....
		//Meeting check for the same batch
		Map<String, List<TrainerSessionVO>> map=trainingSessionService.findAllTrainerScheduleByBatch(batchName);
		 List<TrainerSessionVO> trainerSessionVOs=map.get(batchName);
		 for(TrainerSessionVO trainerSessionVO:trainerSessionVOs) {
			 	if(trainerSessionVO.getFirsthalf().equalsIgnoreCase("yes") && meeting.equals("100")) {
			 		return "redirect:/action/trainer-session-schedule?ApplicationMessage="+"First Half is already engaged for the batch "+batchName+" by "+trainerSessionVO.getTrainer();
			 	}else 	if(trainerSessionVO.getMiddlehalf().equalsIgnoreCase("yes") && meeting.equals("200")) {
			 		return "redirect:/action/trainer-session-schedule?ApplicationMessage="+"Middle Half is already engaged for the batch "+batchName+" by "+trainerSessionVO.getTrainer();
			 	} else 	if(trainerSessionVO.getSecondhalf().equalsIgnoreCase("yes") && meeting.equals("300")) {
			 		return "redirect:/action/trainer-session-schedule?ApplicationMessage="+"Second Half is already engaged for the batch "+batchName+" by "+trainerSessionVO.getTrainer();
			 	}
		 }
		 //check the trainer availability for across all the batch
		 Map<String, List<TrainerSessionVO>> allTrainerScheduled=trainingSessionService.findAllTrainerSchedule();
		  Set<Map.Entry<String, List<TrainerSessionVO>>> entries=allTrainerScheduled.entrySet();
		  for(Map.Entry<String, List<TrainerSessionVO>> entry:entries){
			  List<TrainerSessionVO> alltrainerSessionVOs= entry.getValue();
			  for(TrainerSessionVO trainerSessionVO:alltrainerSessionVOs){
				  if(trainerSessionVO.getFirsthalf().equalsIgnoreCase("yes") && meeting.equals("100") && trainerSessionVO.getTrainer().equalsIgnoreCase(ptrainerName)) {
				 		return "redirect:/action/trainer-session-schedule?ApplicationMessage="+"Trainer "+ptrainerName+" is already engaged for the batch "+trainerSessionVO.getBatch()+" in first half";
				 	}else 	if(trainerSessionVO.getMiddlehalf().equalsIgnoreCase("yes") && meeting.equals("200") && trainerSessionVO.getTrainer().equalsIgnoreCase(ptrainerName)) {
				 		return "redirect:/action/trainer-session-schedule?ApplicationMessage="+"Trainer "+ptrainerName+" is already engaged for the batch "+trainerSessionVO.getBatch()+" in middle half";
				 	} else 	if(trainerSessionVO.getSecondhalf().equalsIgnoreCase("yes") && meeting.equals("300") && trainerSessionVO.getTrainer().equalsIgnoreCase(ptrainerName)) {
				 		return "redirect:/action/trainer-session-schedule?ApplicationMessage="+"Trainer "+ptrainerName+" is already engaged for the batch "+trainerSessionVO.getBatch()+" in second half";
				 	}
			  }
		  }
		
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		TrainerSessionVO trainerSessionVO=new TrainerSessionVO();
		trainerSessionVO.setBatch(batchName);
		trainerSessionVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		trainerSessionVO.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		trainerSessionVO.setFirsthalf("No");
		trainerSessionVO.setMiddlehalf("No");
		trainerSessionVO.setSecondhalf("No");
		if(meeting.equalsIgnoreCase("100")){
			trainerSessionVO.setFirsthalf("Yes");
		}	else if(meeting.equalsIgnoreCase("200")){
			trainerSessionVO.setMiddlehalf("Yes");
		}else if(meeting.equalsIgnoreCase("300")){
			trainerSessionVO.setSecondhalf("Yes");
		}
		trainerSessionVO.setTechid(Integer.parseInt(techid));
		trainerSessionVO.setTrainer(tokesn[1]);
		trainerSessionVO.setUserid(userId.getLoginId());
		//saving the data into the database
		trainingSessionService.addTrainerSession(trainerSessionVO);
		//ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		//applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		//applicationMessageResponse.setMessage(ApplicationMessageConstant.TRAINER_SESSION_IS_UPLOADED_SUCCESSFULLY_INTO_DATABASE);
		return "redirect:/action/trainer-session-schedule?ApplicationMessage="+ApplicationMessageConstant.TRAINER_SESSION_IS_UPLOADED_SUCCESSFULLY_INTO_DATABASE;
	}
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "trainer-session-schedule", method = RequestMethod.GET)
	public String trainerSessionSchedule(HttpSession session,Model model) {
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<String >batchList =  consultantAssesmentService.findActiveBatches();
		batchList.add(0,"Select Batch");
		List<Technology> technologies=technolgyCategoryService.findAllTechnolgy();
		Map<String,String> techidnameMap=new LinkedHashMap<String,String>();
		for(Technology technology:technologies ){
			techidnameMap.put(technology.getId()+"", technology.getTname());
		}
		model.addAttribute("techidnameMap", techidnameMap);
		model.addAttribute("batchList", batchList);
		List<UserForm> trainerList=userervice.findAllTrainer();
		List<String> trainerNameList=new ArrayList<String>();
		for(UserForm userForm : trainerList){
			trainerNameList.add(userForm.getFirstName()+" "+userForm.getLastName()+"-"+userForm.getLoginid());
		}
		model.addAttribute("trainerNameList", trainerNameList);
		Map<String, List<TrainerSessionVO>>  batchTrainerSessionList=trainingSessionService.findAllTrainerSchedule();
		model.addAttribute("batchTrainerSessionList", batchTrainerSessionList);
		return UserNavigationPage.TRAINER_BASE + NavigationPage.TRAINER_SESSION_SCHEDULE_PAGE;
	}
	
	/**
	 * 
	 * @param dateOfSession
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "trainer-daily-report", method = RequestMethod.POST)
	public String trainerDailyReportPost(@RequestParam(value="dos",required=false) String dateOfSession, Model model) {
		if(dateOfSession==null || dateOfSession.trim().length()==0){
			dateOfSession=DateUtils.getCurrentDateNormalFormat();
		}
		List<TrainerDailySessionReport>  dailySessionReportLists=trainingSessionService.findTrainingSessionsDetailByDate(dateOfSession);
		model.addAttribute("dailySessionReportLists", dailySessionReportLists);
		model.addAttribute("dateOfSession", dateOfSession);
		if(dailySessionReportLists!=null && dailySessionReportLists.size()==0){
			model.addAttribute("dailySessionReportLists", dailySessionReportLists);
			 model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
						ApplicationMessageConstant.SORRY_NO_SESSION_WAS_HELD_FOR_SELECTED_DATE);
		}
		
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.TRAINER_DAILY_REPORT_PAGE;
	}
	
	/**
	 * 
	 * @param dateOfSession
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "trainer-daily-report", method = RequestMethod.GET)
	public String trainerDailyReport(@RequestParam(value="dos",required=false) String dateOfSession, Model model) {
		if(dateOfSession==null){
			dateOfSession=DateUtils.getCurrentDateNormalFormat();
		}
		List<TrainerDailySessionReport>  dailySessionReportLists=trainingSessionService.findTrainingSessionsDetailByDate(dateOfSession);
		model.addAttribute("dailySessionReportLists", dailySessionReportLists);
		model.addAttribute("dateOfSession", dateOfSession);
		return ConsultantNavigationPage.TRAINER_BASE
				+ ConsultantNavigationPage.TRAINER_DAILY_REPORT_PAGE;
	}
	
}
