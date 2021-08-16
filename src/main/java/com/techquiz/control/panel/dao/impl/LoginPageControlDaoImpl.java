package com.techquiz.control.panel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.util.DateUtils;
import com.techquiz.control.panel.dao.LoginPageControlDao;
import com.techquiz.control.panel.dao.entity.LoginSliderEntity;

@Repository("LoginPageControlDaoImpl")
@Transactional
public class LoginPageControlDaoImpl implements LoginPageControlDao {

	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(LoginPageControlDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<LoginSliderEntity> findSliderItems() {
		String sql="from LoginSliderEntity";
		Query query=em.createQuery(sql);
		List<LoginSliderEntity> mainSliderEntities=query.getResultList();
		return mainSliderEntities;
	}
	
	@Override
	public LoginSliderEntity updateLoginPage(LoginSliderEntity entity) {
		LoginSliderEntity loginSliderEntity=(LoginSliderEntity)em.getReference(LoginSliderEntity.class, entity.getLpid());
		loginSliderEntity.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		loginSliderEntity.setWelcomeMessage(entity.getWelcomeMessage());
		loginSliderEntity.setSliderImage(entity.getSliderImage());
		loginSliderEntity.setLoginTitle(entity.getLoginTitle());
		loginSliderEntity.setUserid(entity.getUserid());
		return loginSliderEntity;
	}
	
	
	@Override
	public LoginSliderEntity findLoginPageContenByLpid(int lpid){
		if(logger.isDebugEnabled()){
			logger.debug("findLoginPageContenByLpid method is called with lpid = "+lpid);
		}
		return (LoginSliderEntity)em.find(LoginSliderEntity.class, lpid);
	}
	
	
}
