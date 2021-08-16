package com.techquiz.control.panel.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.util.DateUtils;
import com.techquiz.control.panel.controller.model.NewsLetterVO;
import com.techquiz.control.panel.dao.LandingPageDao;
import com.techquiz.control.panel.dao.NewsLetterDao;
import com.techquiz.control.panel.dao.entity.LoginSliderEntity;
import com.techquiz.control.panel.dao.entity.NewsLetterEntity;
import com.techquiz.control.panel.dao.entity.PopularJavaInterviewEntity;
import com.techquiz.control.panel.service.NewsLetterService;

@Repository("NewsLetterServiceImpl")
@Transactional
public class NewsLetterServiceImpl implements NewsLetterService{

	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(NewsLetterServiceImpl.class);

	@Autowired
	@Qualifier("NewsLetterDaoImpl")
	private NewsLetterDao newsLetterDao;
	
	@Override
	public String registerNewsLetters(NewsLetterVO newsLetterVO){
		NewsLetterEntity entity=new NewsLetterEntity();
		BeanUtils.copyProperties(newsLetterVO, entity);
		return newsLetterDao.registerNewsLetters(entity);
	}
}
