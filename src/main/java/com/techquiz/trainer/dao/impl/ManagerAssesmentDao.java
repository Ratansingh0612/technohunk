package com.techquiz.trainer.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.web.form.Technology;
import com.techquiz.trainer.dao.IManagerAssesmentDao;
import com.techquiz.trainer.dao.entity.CourseContentsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

@Repository("ManagerAssesmentDao")
@Scope("singleton")
public class ManagerAssesmentDao implements IManagerAssesmentDao{

	
	private static final Log logger = LogFactory.getLog(ManagerAssesmentDao.class);

	@PersistenceContext
	private EntityManager em;
	

	@Override
	public List<User> findAllTrainer() {
		Query query=em.createQuery("from User where role=?");
		query.setParameter(1, "trainer");
		List<User> userList=query.getResultList();
		return userList;
	}

	@Override
	public List<TrainingSessionsDetailEntity> findTrainerSessionDetailByTid(String trainerId, Timestamp startDate,
			Timestamp endDate) {
		
		Query query=em.createQuery("from TrainingSessionsDetailEntity as tsd where tsd.userid=:trainerId AND tsd.sessiondate BETWEEN :startDate AND :endDate");
		
		query.setParameter("trainerId", trainerId);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		List<TrainingSessionsDetailEntity> tsdL=query.getResultList();
		TrainingSessionsDetailEntity e1=(TrainingSessionsDetailEntity)tsdL.get(0);
		query=em.createQuery("from User where loginid=?");
		query.setParameter(1, e1.getUserid());
		User name=(User)query.getSingleResult();
		String tid=null;
		TechnologyEntity tech=null;
		for(TrainingSessionsDetailEntity e:tsdL){
			e.setName(name.getFirstName()+" "+name.getLastName());
			tid=e.getTechnology();
			query=em.createQuery("from TechnologyEntity where id=? ");
			query.setParameter(1, Integer.parseInt(tid));
			tech=(TechnologyEntity)query.getSingleResult();
			e.setTechName(tech.getTname());
		}
		return tsdL;
	}


	@Override
	public Map<String,List<TrainingSessionsDetailEntity>> findAllTrainerSessionDetail(Timestamp startDate, Timestamp endDate) {
		
		Query query=em.createQuery("from TrainingSessionsDetailEntity as tsd where tsd.sessiondate BETWEEN :startDate AND :endDate  ORDER BY tsd.batch, tsd.sessiondate asc");
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		List<TrainingSessionsDetailEntity> tsdL=query.getResultList();
		String tid=null;
		Technology tech=null;
		Map<String,List<TrainingSessionsDetailEntity>> sesMap=new LinkedHashMap<String, List<TrainingSessionsDetailEntity>>();
		Set<String> checkBatch=new HashSet<String>();
		List<TrainingSessionsDetailEntity> detailEntities=null;
		for(TrainingSessionsDetailEntity e:tsdL){
			if(!checkBatch.contains(e.getBatch())){
				detailEntities=new ArrayList<TrainingSessionsDetailEntity>();
				sesMap.put(e.getBatch(),detailEntities);
				checkBatch.add(e.getBatch());
			}
			
			query=em.createQuery("from User where loginid=?");
			query.setParameter(1, e.getUserid());
			User name=(User)query.getSingleResult();
			e.setName(name.getFirstName()+" "+name.getLastName());
			tid=e.getTechnology();
			query=em.createQuery("from TechnologyEntity where id=? ");
			query.setParameter(1, Integer.parseInt(tid));
			tech=(Technology)query.getSingleResult();
			e.setTechName(tech.getTname());
			detailEntities.add(e);
		}
		return sesMap;
	}


	@Override
	public String findUserNameByLoginId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingSessionsDetailEntity> findTrainerTotalSessionDuration() {
		Query query=em.createQuery("from TrainingSessionsDetailEntity");
		List<TrainingSessionsDetailEntity> tSessiondetailEntites=query.getResultList();
		List<TrainingSessionsDetailEntity> tdetailEntities=new ArrayList<TrainingSessionsDetailEntity>();
		Set<String> userId=new HashSet<String>();
		int totalDuration=0;
		for(TrainingSessionsDetailEntity detailEntity:tSessiondetailEntites){
			userId.add(detailEntity.getUserid());
		}
		for(String id:userId){
			query=em.createQuery("from TrainingSessionsDetailEntity where userid=:userid");
			query.setParameter("userid", id);
			List<TrainingSessionsDetailEntity> detailEntities=query.getResultList();
			for(TrainingSessionsDetailEntity detailEntity:detailEntities){
				totalDuration+=Integer.parseInt(detailEntity.getTimeduration());
			}
			query=em.createQuery("from User where loginid=?");
			query.setParameter(1, id);
			User username=(User)query.getSingleResult();
			TrainingSessionsDetailEntity detailEntity=new TrainingSessionsDetailEntity();
			detailEntity.setName(username.getFirstName()+" "+username.getLastName());
			detailEntity.setTotalDuration(totalDuration);
			tdetailEntities.add(detailEntity);
		}
		return tdetailEntities;
	}

	@Override
	public List<CourseContentsEntity> findAllTechnologyFromCourseContent(String course) {
		Query query=em.createQuery("from CourseContentsEntity where course=?");
		query.setParameter(1, course);
		List<CourseContentsEntity> contentsEntities=query.getResultList();
		return contentsEntities;
	}

	@Override
	public List<CourseContentsEntity> findAllCourseContentesTopics(String tName) {
		Query query=em.createQuery("from CourseContentsEntity where technologyname=?");
		query.setParameter(1, tName);
		List<CourseContentsEntity> contentsEntities=query.getResultList();
		return contentsEntities;
	}

	@Override
	public TechnologyEntity findLogoByTechName(String tName) {
		Query query=em.createQuery("from TechnologyEntity where tname=:tname");
		query.setParameter("tname", tName);
		TechnologyEntity techLogo=(TechnologyEntity)query.getSingleResult();
		return techLogo;
	}

}
