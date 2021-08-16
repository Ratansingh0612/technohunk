package com.techquiz.control.panel.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techquiz.control.panel.dao.AppSettingsDao;
import com.techquiz.control.panel.dao.entity.AppSettingsEntity;

@Repository("AppSettingsDaoImpl")
@Transactional
public class AppSettingsDaoImpl implements AppSettingsDao {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(AppSettingsDaoImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AppSettingsEntity findAppDefaultSettings(int isid){
			Query query=em.createQuery("from AppSettingsEntity where iid=?");
			query.setParameter(1, isid);
			AppSettingsEntity appSettingsEntity=null;
			try {
				 appSettingsEntity= (AppSettingsEntity)query.getSingleResult();
			}catch(Exception ex){
				if(logger.isWarnEnabled()){
					logger.warn("Sorry app setting is not configured.... ");
				}
			}
			return appSettingsEntity;
		}
}
