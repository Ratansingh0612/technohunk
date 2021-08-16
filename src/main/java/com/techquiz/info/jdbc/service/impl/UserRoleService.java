package com.techquiz.info.jdbc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.techquiz.info.jdbc.dao.IUserRoleDao;
import com.techquiz.info.jdbc.service.IUserRoleService;

@Repository("UserRoleService")
@Scope("singleton")
public class UserRoleService  implements IUserRoleService {
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(UserRoleService.class);
	
	@Autowired
	@Qualifier("UserRoleDao")
	private IUserRoleDao userRoleDao;
	
	@Override
	public List<String> findActiveBatchForConsultant(){
		return userRoleDao.findActiveBatchForConsultant();
	}
}