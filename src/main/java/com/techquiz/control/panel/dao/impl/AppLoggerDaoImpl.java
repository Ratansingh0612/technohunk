package com.techquiz.control.panel.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techquiz.control.panel.dao.AppLoggerDao;
import com.techquiz.control.panel.dao.entity.AppLoggerEntity;

@Repository("AppLoggerDaoImpl")
@Transactional
public class AppLoggerDaoImpl implements AppLoggerDao {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(AppLoggerDaoImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String saveErrorLog(AppLoggerEntity appLoggerEntity){
		if(logger.isDebugEnabled())
		logger.debug(appLoggerEntity.toString());
		em.persist(appLoggerEntity);
		return "success";
	}

}
