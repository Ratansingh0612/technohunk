package com.techquiz.programys.common.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergisitic.it.report.model.CourseCoveredStatusKey;
import com.synergisitic.it.report.model.CourseCoveredStatusVO;
import com.techquiz.programys.common.dao.IContentsDao;
import com.techquiz.programys.common.service.IContentsService;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.CourseContentsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.web.controller.vo.CourseContentsDetailVO;

@Service("ContentsService")
@Scope("singleton")
public class ContentsService  implements IContentsService{
	
	@Autowired
	@Qualifier("ContentsDao")
	private IContentsDao contentsDao;
	
	@Override
	public String addTopicsCourse(List<CourseContentsDetailVO> courseContentsDetailVOs){
		List<CourseContentsEntity> contentsEntityList=new ArrayList<CourseContentsEntity>();
		for(CourseContentsDetailVO contentsDetailVO:courseContentsDetailVOs){
			CourseContentsEntity contentsEntity=new CourseContentsEntity();
			BeanUtils.copyProperties(contentsDetailVO, contentsEntity);
			contentsEntityList.add(contentsEntity);
		}
		return contentsDao.addTopicsCourse(contentsEntityList);
	}
	
	@Override
	public  Map<CourseCoveredStatusKey,List<CourseCoveredStatusVO>>  findCourseCoveredStatusForBatch(String batchName){
		List<ConsultantsEntity> consultantsEntityList=contentsDao.findConsultantDetailsByBatch(batchName);
		List<TrainingSessionsDetailEntity> trainingSessionsDetailEntityList=contentsDao.findCourseCoveredStatusForBatch(batchName);
		Map<CourseCoveredStatusKey,List<CourseCoveredStatusVO>> courseCoveredStatusMap=new LinkedHashMap<CourseCoveredStatusKey, List<CourseCoveredStatusVO>>();

		for(ConsultantsEntity consultantsEntity: consultantsEntityList) {
				//Creating key for the map as per the consultant details
				CourseCoveredStatusKey courseCoveredStatusKey=new CourseCoveredStatusKey();
				courseCoveredStatusKey.setCids(consultantsEntity.getEmpid());
				courseCoveredStatusKey.setConsultantId(consultantsEntity.getUserid());
				courseCoveredStatusKey.setName(consultantsEntity.getName());
				List<CourseCoveredStatusVO> courseCoveredStatusVOList=new ArrayList<CourseCoveredStatusVO>();
				Set<String> techCheckList=new HashSet<String>();
				StringBuilder topocsCovered=new StringBuilder();
				CourseCoveredStatusVO courseCoveredStatusVO=new CourseCoveredStatusVO();
				List<String> totalTopics=new ArrayList<String>();
				List<String> totalTopicsCovered=new ArrayList<String>();
				String preTechName="";
				int firstTime=0;
				float totalPercentage=0.0F;
				for(TrainingSessionsDetailEntity trainingSessionsDetailEntity:trainingSessionsDetailEntityList){
							if(!techCheckList.contains(trainingSessionsDetailEntity.getTechnology())){
								courseCoveredStatusVO.setTopicCovered(topocsCovered.toString());
								
								if(firstTime>0) {
								totalTopicsCovered=Arrays.asList(topocsCovered.toString().split(","));
								 //computing the topics remaining
								totalTopics=contentsDao.findTotalTopicsByTechName(preTechName);
								int totalTopicsSize=totalTopics.size();
								totalTopics.removeAll(totalTopicsCovered);
								StringBuilder remainingTopics=new StringBuilder();
								for(String rtopic:totalTopics){
									remainingTopics.append(rtopic+",");
								}
								courseCoveredStatusVO.setTopicRemaining(remainingTopics.toString());
								if(totalTopicsSize>0){
									float percentage=(((float)(topocsCovered.toString().split(",").length))/totalTopicsSize)*100;
									totalPercentage=totalPercentage+percentage;
									DecimalFormat df = new DecimalFormat();
									df.setMaximumFractionDigits(2);
									courseCoveredStatusVO.setCourseStatus(df.format(percentage)+"");
								}else{
									courseCoveredStatusVO.setCourseStatus("NK");
								}
								}else{
									firstTime++;
								}
								
								topocsCovered=new StringBuilder();
							     courseCoveredStatusVO=new CourseCoveredStatusVO();
							     courseCoveredStatusVO.setComment("NA");
							     courseCoveredStatusVO.setTechnology(trainingSessionsDetailEntity.getTechnology());
							     courseCoveredStatusVO.setTopicCovered(topocsCovered.toString());
							     courseCoveredStatusVO.setTopicRemaining("TODO");
							     courseCoveredStatusVOList.add(courseCoveredStatusVO);
								techCheckList.add(trainingSessionsDetailEntity.getTechnology());
								
							}
							preTechName=trainingSessionsDetailEntity.getTechnology();
							topocsCovered.append(trainingSessionsDetailEntity.getTopics()+",");
				}
				//for last row...
				totalTopics=contentsDao.findTotalTopicsByTechName(preTechName);
				totalTopicsCovered=Arrays.asList(topocsCovered.toString().split(","));
				int totalTopicsSize=totalTopics.size();
				totalTopics.removeAll(totalTopicsCovered);
				StringBuilder remainingTopics=new StringBuilder();
				for(String rtopic:totalTopics){
					remainingTopics.append(rtopic+",");
				}
				courseCoveredStatusVO.setTopicRemaining(remainingTopics.toString());
				if(totalTopicsSize>0){
					float percentage=((topocsCovered.toString().split(",").length)/totalTopicsSize)*100;
					totalPercentage=totalPercentage+percentage;
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					courseCoveredStatusVO.setCourseStatus(df.format(percentage)+"");
				}else{
					courseCoveredStatusVO.setCourseStatus("NK");
				}
				
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				courseCoveredStatusKey.setTotalCoursePer(Float.parseFloat(df.format(totalPercentage/techCheckList.size())));
				techCheckList.clear();
				totalPercentage=0;
				courseCoveredStatusVO.setTopicCovered(topocsCovered.toString());
				//Adding particular consultant course covered status into the map
				courseCoveredStatusMap.put(courseCoveredStatusKey, courseCoveredStatusVOList);
		}
		return courseCoveredStatusMap;
 	}
}
