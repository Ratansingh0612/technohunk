package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.TechnolgyCategoryDao;
import com.synergisitic.it.dao.TrainingSessionDao;
import com.synergisitic.it.dao.UserDao;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.service.TrainingSessionService;
import com.synergisitic.it.web.form.UserForm;
import com.techquiz.trainer.dao.entity.TrainerSessionEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;
import com.techquiz.trainer.web.controller.vo.TrainerDailySessionReport;
import com.techquiz.trainer.web.controller.vo.TrainerSessionVO;

/**
 * 
 * @author nagendra
 * @since 06-04-2018
 *
 */
@Service("TrainingSessionServiceImpl")
public class TrainingSessionServiceImpl  implements TrainingSessionService{

	@Autowired
	@Qualifier("TrainingSessionDaoImpl")
	private TrainingSessionDao trainingSessionDao;
	
	@Autowired
	@Qualifier("TechnolgyCategoryDaoImpl")
	private TechnolgyCategoryDao technolgyCategoryDao;
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	private UserDao userDao;
	
private String colors[]=new String[10];
	 
	public TrainingSessionServiceImpl() {
		colors[0]="#3fceea";
		colors[1]="#8ee2af";
		colors[2]="#fcf8ba";
		colors[3]="#3fceea";
		colors[4]="#6274d1";
		colors[5]="#43efb3";
		colors[6]="#eaaa60";
		colors[7]="#ff951c";
		colors[8]="#3d74ff";
		colors[9]="#0f48d8";
	}
	
	
	@Override
	public String addTrainerSession(TrainerSessionVO trainerSessionVO){
		TrainerSessionEntity entity=new TrainerSessionEntity();
	    BeanUtils.copyProperties(trainerSessionVO, entity);
	    return trainingSessionDao.addTrainerSession(entity);
	}
	
	@Override
	public Map<String,List<TrainerSessionVO>> findAllTrainerSchedule(){
		
		 Map<String,String> trainerColorMap=new HashMap<String,String>();
		List<TrainerSessionEntity> trainerSessionEntityList=trainingSessionDao.findAllTrainerSchedule();
		Map<String,List<TrainerSessionVO>> batchSessionListMap=new LinkedHashMap<String,List<TrainerSessionVO>>();
		int c=0;
		for(TrainerSessionEntity trainerSessionEntity:trainerSessionEntityList) {
				TechnologyEntity technologyEntity=technolgyCategoryDao.findTechnologyByTid(trainerSessionEntity.getTechid()+"");	
				TrainerSessionVO sessionVO=new TrainerSessionVO();
				sessionVO.setTechnology(technologyEntity.getTname());
				if(trainerSessionEntity.getFirsthalf().equalsIgnoreCase("yes"))
				sessionVO.setFcolor("#ffa500");
				else if(trainerSessionEntity.getMiddlehalf().equalsIgnoreCase("yes"))
					sessionVO.setMcolor("#3dabfa");
				else if(trainerSessionEntity.getSecondhalf().equalsIgnoreCase("yes"))
				sessionVO.setScolor("#800000");
			    BeanUtils.copyProperties(trainerSessionEntity, sessionVO);
				User user=userDao.findUserByLoginId(trainerSessionEntity.getTrainer());
				sessionVO.setTrainer(user.getFirstName()+" "+user.getLastName());
				String trainerName=sessionVO.getTrainer();
				if(!trainerColorMap.containsKey(trainerName)){
					 String tcolor=colors[c++];
					trainerColorMap.put(trainerName, tcolor);
					sessionVO.setTcolor(tcolor);
				}else{
					sessionVO.setTcolor(trainerColorMap.get(trainerName));
				}
				if(batchSessionListMap.containsKey(trainerSessionEntity.getBatch())){
			    	  batchSessionListMap.get(trainerSessionEntity.getBatch()).add(sessionVO);
			      }else{
			    	  List<TrainerSessionVO> trainerSessionList=new ArrayList<TrainerSessionVO>();
			    	  trainerSessionList.add(sessionVO);
			    	  batchSessionListMap.put(trainerSessionEntity.getBatch(), trainerSessionList);
			      }
		}
		return batchSessionListMap;
	}
	
	@Override
	public Map<String,List<TrainerSessionVO>> findAllTrainerScheduleByBatch(String batch){
		List<TrainerSessionEntity> trainerSessionEntityList=trainingSessionDao.findAllTrainerScheduleByBatch(batch);
		List<TrainerSessionVO> sessionVOsList=new ArrayList<TrainerSessionVO>();
		for(TrainerSessionEntity entity:trainerSessionEntityList){
			TrainerSessionVO sessionVO=new TrainerSessionVO();
		    BeanUtils.copyProperties(entity, sessionVO);
		    sessionVOsList.add(sessionVO);
		}
		Map<String,List<TrainerSessionVO>> batchSessionListMap=new LinkedHashMap<String,List<TrainerSessionVO>>();
		batchSessionListMap.put(batch, sessionVOsList);
		return batchSessionListMap;
	}
	
	@Override
	public String deleteTrainerSession(TrainerSessionVO session){
		TrainerSessionEntity entity=new TrainerSessionEntity();
		BeanUtils.copyProperties(session, entity);
		String status=trainingSessionDao.deleteTrainerSession(entity);
		return status;
	}
	
	
	
	@Override
	public List<TrainerDailySessionReport> findTrainingSessionsDetailByDate(String dot) {
		List<TrainingSessionsDetailEntity> trainingSessionsDetailEntity=trainingSessionDao.findTrainingSessionsDetailByDate(dot);
		List<TrainerDailySessionReport> dailySessionReportLists=new ArrayList<TrainerDailySessionReport>();
		for(TrainingSessionsDetailEntity trainingSessionsDetail:trainingSessionsDetailEntity) {
			TrainerDailySessionReport trainerDailySessionReport=new TrainerDailySessionReport();
			List<UserForm> userList=consultantAssesmentService.findConsultantByBatch(trainingSessionsDetail.getBatch());
			List<ConsultantsVO> consultantList = new ArrayList<ConsultantsVO>();
					for(UserForm uf:userList) {
							ConsultantsVO consultantsVO=new ConsultantsVO();
							consultantsVO.setCid(uf.getId());
							consultantsVO.setName(uf.getFirstName()+" "+uf.getLastName());
							consultantsVO.setEmail(uf.getEmail());
							consultantsVO.setEmpid(uf.getEmpid());
							consultantsVO.setUserid(uf.getLoginid());
							consultantsVO.setDoj(uf.getDoj());
							consultantList.add(consultantsVO);
					}
					User trainer=userDao.findUserByLoginId(trainingSessionsDetail.getUserid());
					trainerDailySessionReport.setConsultantList(consultantList);
					trainerDailySessionReport.setEmail(trainer.getEmail());
					trainerDailySessionReport.setEmpid(trainer.getId()+"");
					trainerDailySessionReport.setEndTime(trainingSessionsDetail.getEndtime().toString());
					trainerDailySessionReport.setName(trainer.getFirstName()+" "+trainer.getLastName());
					trainerDailySessionReport.setSessionDuration(trainingSessionsDetail.getTimeduration());
					trainerDailySessionReport.setStartTime(trainingSessionsDetail.getStarttime().toString());
					TechnologyEntity technologyEntity=technolgyCategoryDao.findTechnologyByTid(trainingSessionsDetail.getTechnology());
					trainerDailySessionReport.setTechnology(technologyEntity.getTname());
					trainerDailySessionReport.setTopicCovered(trainingSessionsDetail.getTopics());
					trainerDailySessionReport.setBatchName(trainingSessionsDetail.getBatch());
					dailySessionReportLists.add(trainerDailySessionReport);
		}
		
		return dailySessionReportLists;
	}
}
