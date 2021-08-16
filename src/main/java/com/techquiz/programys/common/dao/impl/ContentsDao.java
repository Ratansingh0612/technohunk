package com.techquiz.programys.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.util.ApplicationContant;
import com.techquiz.programys.common.dao.IContentsDao;
import com.techquiz.programys.common.dao.entity.TopicEntity;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.CourseContentsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

@Repository("ContentsDao")
@Transactional
public class ContentsDao  implements IContentsDao{
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ContentsDao.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String addTopicsCourse(List<CourseContentsEntity> contentsEntityList){
		for(CourseContentsEntity contentsEntity:contentsEntityList){
			TopicEntity topicEntity=em.find(TopicEntity.class, contentsEntity.getTopicid());
			contentsEntity.setTopicname(topicEntity!=null?topicEntity.getTopic():"NA");
			TechnologyEntity technology=em.find(TechnologyEntity.class, Integer.parseInt(contentsEntity.getTechnologyid()));
			contentsEntity.setTopicname(topicEntity!=null?topicEntity.getTopic():"NA");
			contentsEntity.setTechnologyname(technology!=null?technology.getTname():"NA");
			em.persist(contentsEntity);
		}
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	public List<TrainingSessionsDetailEntity> findCourseCoveredStatusForBatch(String batchName){
		Query fetchSessonDetails=em.createQuery("from TrainingSessionsDetailEntity as tsde where  tsde.batch=? order by tsde.technology asc");
		fetchSessonDetails.setParameter(1,batchName);
		List<TrainingSessionsDetailEntity> trainingSessionsDetailsList=fetchSessonDetails.getResultList();
		/*for(TrainingSessionsDetailEntity trainingSessionsDetailEntity:trainingSessionsDetailsList){
			try {
				Query query=em.createQuery("from Technology tech where tech.tname=?");
				query.setParameter(1,trainingSessionsDetailEntity.getTechName() );
				Technology technology=(Technology)query.getSingleResult();
				trainingSessionsDetailEntity.setTechnology(technology.getTname());
				Query findTotalCourseContet=em.createQuery("from CourseContentsEntity as tsde cce where  tsde.technologyid=?");
				fetchSessonDetails.setParameter(1,trainingSessionsDetailEntity.getTechnology());
				List<CourseContentsEntity> courseContentsEntityList=findTotalCourseContet.getResultList();
				List<String> totalTopicsList=new ArrayList<String>();
				for(CourseContentsEntity contentsEntity:courseContentsEntityList) {
					totalTopicsList.add(contentsEntity.getTopicname());
			    }
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}*/
		return trainingSessionsDetailsList;	
	}
	
	@Override
	public List<String> findTotalTopicsByTechName(String techName){
				Query findTotalCourseContet=em.createQuery("from CourseContentsEntity as tsde  where  tsde.technologyname=?");
				findTotalCourseContet.setParameter(1,techName);
				List<CourseContentsEntity> courseContentsEntityList=findTotalCourseContet.getResultList();
				List<String> totalTopicsList=new ArrayList<String>();
				for(CourseContentsEntity contentsEntity:courseContentsEntityList){
					totalTopicsList.add(contentsEntity.getTopicname());
				}
				return totalTopicsList;	
	}
	
	@Override
	public List<ConsultantsEntity> findConsultantDetailsByBatch(String batchName){
		Query query=em.createQuery("from ConsultantsEntity where  batch=?");
		query.setParameter(1, batchName);
		List<ConsultantsEntity> consultantsEntityList=query.getResultList();
		return consultantsEntityList;
	}

}
