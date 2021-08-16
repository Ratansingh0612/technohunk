package com.techquiz.info.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.techquiz.info.jdbc.dao.IUserRoleDao;
import com.techquiz.programys.common.dao.entity.BatchEntity;

@Repository("UserRoleDao")
@Scope("singleton")
public class UserRoleDao  implements IUserRoleDao {
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(UserRoleDao.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<String> findActiveBatchForConsultant(){
			Query query=em.createQuery("from BatchEntity");
			List<BatchEntity> batchEntities=query.getResultList();
			List<String> batchList= new ArrayList<String>();
			for(BatchEntity batchEntity:batchEntities){
				if(!batchList.contains(batchEntity.getBatch()))
				batchList.add(batchEntity.getBatch());
			}
			return batchList;
	}
}
