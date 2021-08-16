package com.techquiz.trainer.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.DateUtils;
import com.techquiz.programys.common.ApplicationRestColorPicker;
import com.techquiz.trainer.dao.IManagerAssesmentDao;
import com.techquiz.trainer.dao.entity.CourseContentsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.service.IManagerAssesmentService;
import com.techquiz.trainer.web.controller.vo.CourseContentsDetailVO;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Service("ManagerAssesmentService")
@Scope("singleton")
public class ManagerAssesmentService  implements IManagerAssesmentService {

	
	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	
	@Autowired
	@Qualifier("ManagerAssesmentDao")
	private IManagerAssesmentDao managerAssesmentDao;
	
	
	@Override
	public Map<String,String> findAllTrainer() {
		List<User> trainerList=managerAssesmentDao.findAllTrainer();
		Map<String,String> trainerNames=new LinkedHashMap<String,String>();
		for(User u:trainerList){
			trainerNames.put(u.getLoginid(), u.getFirstName()+" "+u.getLastName());
		}
		return trainerNames;
	}


	@Override
	public List<TrainingSessionsDetailVO> findTrainerSessionDetailByTid(String trainerId, String startDate,
			String endDate) {
		
		
		
		Timestamp sd=DateUtils.convertDateIntoTimestamp(startDate);
		Timestamp ed=DateUtils.convertDateIntoTimestamp(endDate);
		List<TrainingSessionsDetailEntity> tsdeList=
				managerAssesmentDao.findTrainerSessionDetailByTid(trainerId,sd,ed);
		List<TrainingSessionsDetailVO> tsdVOList=new ArrayList<TrainingSessionsDetailVO>();
		for(TrainingSessionsDetailEntity tsdE:tsdeList){
			TrainingSessionsDetailVO tsdVO=new TrainingSessionsDetailVO();
			BeanUtils.copyProperties(tsdE, tsdVO);
			tsdVOList.add(tsdVO);
		}
		return tsdVOList;
	}


	@Override
	public Map<String,List<TrainingSessionsDetailVO>> findAllTrainerSessionDetail(String startDate, String endDate) {
		Timestamp sd=DateUtils.convertDateIntoTimestamp(startDate);
		Timestamp ed=DateUtils.convertDateIntoTimestamp(endDate);
		Map<String,List<TrainingSessionsDetailEntity>> tsdEM= managerAssesmentDao.findAllTrainerSessionDetail(sd,ed);
		Map<String,List<TrainingSessionsDetailVO>> tsdVO=new LinkedHashMap<String, List<TrainingSessionsDetailVO>>();
		List<String> trainerList=new ArrayList<String>();
		List<String> colorList=ApplicationRestColorPicker.getColorList();
		int colorCount=0;
		String color="";
		for(String s:tsdEM.keySet()){
			List<TrainingSessionsDetailVO> detailVOs=new ArrayList<TrainingSessionsDetailVO>();
			for(TrainingSessionsDetailEntity tsd:tsdEM.get(s)){
				if(!trainerList.contains(tsd.getUserid())){
					trainerList.add(tsd.getUserid());
					color=colorList.get(colorCount);
					colorCount++;
				}
				TrainingSessionsDetailVO detailVO=new TrainingSessionsDetailVO();
				BeanUtils.copyProperties(tsd, detailVO);
				detailVO.setColor(color);
				detailVOs.add(detailVO);
			}
			tsdVO.put(s, detailVOs);
		}
		return tsdVO;
	}


	@Override
	public List<TrainingSessionsDetailVO> findTrainerTotalSessionDuration() {
		List<TrainingSessionsDetailEntity> tSessionDetailTotalDuration=managerAssesmentDao.findTrainerTotalSessionDuration();
		List<TrainingSessionsDetailVO> detailVOs=new ArrayList<TrainingSessionsDetailVO>();
		for(TrainingSessionsDetailEntity detailEntity:tSessionDetailTotalDuration){
			TrainingSessionsDetailVO detailVO=new TrainingSessionsDetailVO();
			BeanUtils.copyProperties(detailEntity, detailVO);
			detailVOs.add(detailVO);
		}
		return detailVOs;
	}


	@Override
	public Map<String, List<CourseContentsDetailVO>> findAllCourseContentsTopics(String course) {
		List<CourseContentsEntity> cContentsList=managerAssesmentDao.findAllTechnologyFromCourseContent(course);
		Set<String> techNameSet=new LinkedHashSet<String>();
		Map<String,List<CourseContentsDetailVO>> cContentMap=new LinkedHashMap<String, List<CourseContentsDetailVO>>();
		for(CourseContentsEntity contentsEntity:cContentsList){
			techNameSet.add(contentsEntity.getTechnologyname());
		}
		for(String tName:techNameSet){
			List<CourseContentsDetailVO> ccontentsDetailVOsList=new ArrayList<CourseContentsDetailVO>();
			List<CourseContentsEntity> contentsEntities=managerAssesmentDao.findAllCourseContentesTopics(tName);
			TechnologyEntity techLogo=managerAssesmentDao.findLogoByTechName(tName);
			for(CourseContentsEntity contentsEntity:contentsEntities){
				CourseContentsDetailVO contentsDetailVO=new CourseContentsDetailVO();
				BeanUtils.copyProperties(contentsEntity, contentsDetailVO);
				contentsDetailVO.setTechnologyname(techLogo.getShortName());
				ccontentsDetailVOsList.add(contentsDetailVO);
			}
			cContentMap.put(tName, ccontentsDetailVOsList);
		}
		return cContentMap;
	}

}
