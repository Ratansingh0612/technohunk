package com.techquiz.programys.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techquiz.programys.common.dao.ISessionScheduleDao;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.ErrorLogEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Repository("SessionScheduleDao")
@Transactional
public class SessionScheduleDao  implements ISessionScheduleDao{
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(SessionScheduleDao.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TrainingSessionsDetailEntity> findActiveSessionSchedule() {
		Query query=em.createQuery("from TrainingSessionsDetailEntity");
		List<TrainingSessionsDetailEntity> trainingSessionsDetailEntityList=query.getResultList();
		return trainingSessionsDetailEntityList;
	}
	
	
	@Override
	public void logAppErrorDb(ErrorLogEntity entity){
		em.persist(entity);
	}


}
