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
import com.techquiz.control.panel.dao.NewsLetterDao;
import com.techquiz.control.panel.dao.entity.LoginSliderEntity;
import com.techquiz.control.panel.dao.entity.NewsLetterEntity;
import com.techquiz.control.panel.dao.entity.PopularJavaInterviewEntity;

@Repository("NewsLetterDaoImpl")
@Transactional
public class NewsLetterDaoImpl implements NewsLetterDao {

	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(NewsLetterDaoImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String registerNewsLetters(NewsLetterEntity entity){
		String sql="from NewsLetterEntity where email=?";
		Query query=em.createQuery(sql);
		query.setParameter(1,entity.getEmail());
		List<NewsLetterEntity> newsLetterEntityList=query.getResultList();
		if(newsLetterEntityList!=null && newsLetterEntityList.size()>0){
			return "registered";
		}else{
			em.persist(entity);
			return "success";
		}
	}
}
