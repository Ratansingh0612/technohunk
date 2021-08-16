package com.techquiz.trainer.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.techquiz.trainer.dao.IConsultantAssignmentDao;

@Repository("ConsultantAssignmentDao")
@Scope("singleton")

public class ConsultantAssignmentDao implements IConsultantAssignmentDao {
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ConsultantAssignmentDao.class);

	@PersistenceContext
	private EntityManager em;
	
	

	
	

}
