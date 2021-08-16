package com.synergisitic.it.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.TrainingSessionDao;
import com.synergisitic.it.util.ApplicationContant;
import com.techquiz.trainer.dao.entity.TrainerSessionEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

@Repository("TrainingSessionDaoImpl")
@Transactional
public class TrainingSessionDaoImpl  implements TrainingSessionDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public String addTrainerSession(TrainerSessionEntity entity) {
		em.persist(entity);
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	public String deleteTrainerSession(TrainerSessionEntity entity) {
		TrainerSessionEntity trainerSessionEntity=em.getReference(TrainerSessionEntity.class, entity.getTsid());
		em.remove(trainerSessionEntity);
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	public List<TrainerSessionEntity> findAllTrainerSchedule() {
		Query query=em.createQuery("from TrainerSessionEntity");
		List<TrainerSessionEntity> trainerSessionEntityList=(List<TrainerSessionEntity>)query.getResultList();
		return trainerSessionEntityList;
	}
	
	@Override
	public List<TrainerSessionEntity> findAllTrainerScheduleByBatch(String batch) {
		Query query=em.createQuery("from TrainerSessionEntity where batch=?");
		query.setParameter(1, batch);
		List<TrainerSessionEntity> trainerSessionEntityList=(List<TrainerSessionEntity>)query.getResultList();
		return trainerSessionEntityList;
	}
	
	
	@Override
	public List<TrainingSessionsDetailEntity> findTrainingSessionDetailByUserid(String userid, String techId) {
		Query query=em.createQuery("from TrainingSessionsDetailEntity  where userid=? and technology=?");
		query.setParameter(1, userid);
		query.setParameter(2, techId);
		List<TrainingSessionsDetailEntity> trainingSessionsDetailEntity=(List<TrainingSessionsDetailEntity>)query.getResultList();
		return trainingSessionsDetailEntity;
	}
	
	@Override
	public List<TrainingSessionsDetailEntity> findTrainingSessionsDetailByDate(String dot) {
		  //dot="05-04-2018";
		  String doe=dot+" 23:59:59";
	     Date startDate;
	     Date endDate;
	 	Query query=null;
		try {
			startDate = new SimpleDateFormat("dd-MM-yyyy").parse(dot);
		     endDate=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(doe);
		 	String sql="SELECT * FROM training_sessions_detail_tbl  WHERE  sessiondate  BETWEEN ? AND ?"; 
			 query= em.createNativeQuery(sql, TrainingSessionsDetailEntity.class);
			query.setParameter(1, startDate);
			query.setParameter(2, endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TrainingSessionsDetailEntity> trainingSessionsDetailEntityList=new ArrayList<>();
		try {
	/*	 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<TrainingSessionsDetailEntity> cq=cb.createQuery(TrainingSessionsDetailEntity.class);
		 Root<TrainingSessionsDetailEntity> root=cq.from(TrainingSessionsDetailEntity.class);
		 CriteriaQuery<TrainingSessionsDetailEntity> select=cq.select(root);
		 //elect.where(cb.like(from.get("QWE"),"DDD");
		 select.where(cb.like(root.<String>get("sessiondate"),"%"+dot+"%"));
		 TypedQuery<TrainingSessionsDetailEntity> tq=em.createQuery(cq);
		  trainingSessionsDetailEntityList=tq.getResultList();*/
			
			trainingSessionsDetailEntityList=(List<TrainingSessionsDetailEntity>)query.getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	/*	
		Query query=em.createQuery("from TrainingSessionsDetailEntity  where sessiondate");
		Date pdot=new Date();
		pdot.setYear(2018);
		pdot.setMonth(03);
		pdot.setDate(05);
		query.setParameter("pdot",pdot,TemporalType.DATE);
		List<TrainingSessionsDetailEntity> trainingSessionsDetailEntityList=new ArrayList<>();
		try {
			trainingSessionsDetailEntityList=(List<TrainingSessionsDetailEntity>)query.getResultList();*/
		
		return trainingSessionsDetailEntityList;
	}
}
