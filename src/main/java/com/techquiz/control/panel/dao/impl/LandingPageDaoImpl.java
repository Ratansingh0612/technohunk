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
import com.techquiz.control.panel.dao.LandingPageDao;
import com.techquiz.control.panel.dao.entity.CompanyBusinessEntity;
import com.techquiz.control.panel.dao.entity.MainSliderEntity;
import com.techquiz.control.panel.dao.entity.PopularJavaInterviewEntity;

@Repository("LandingPageDaoImpl")
@Transactional
public class LandingPageDaoImpl implements LandingPageDao {

	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(LandingPageDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<MainSliderEntity> findSliderItems() {
		String sql="from MainSliderEntity";
		Query query=em.createQuery(sql);
		List<MainSliderEntity> mainSliderEntities=query.getResultList();
		return mainSliderEntities;
	}
	
	@Override
	public MainSliderEntity updateSliderItems(MainSliderEntity entity) {
		MainSliderEntity mainSliderEntity=(MainSliderEntity)em.getReference(MainSliderEntity.class, entity.getLpid());
		mainSliderEntity.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		mainSliderEntity.setMainHeading(entity.getMainHeading());
		mainSliderEntity.setIcon(entity.getIcon());
		mainSliderEntity.setSliderImage(entity.getSliderImage());
		mainSliderEntity.setSubHeading(entity.getSubHeading());
		mainSliderEntity.setUserid(entity.getUserid());
		return mainSliderEntity;
	}
	
	
	@Override
	public MainSliderEntity findMainSliderVOById(int lpid){
		return (MainSliderEntity)em.find(MainSliderEntity.class, lpid);
	}
	
	
	@Override
	public List<PopularJavaInterviewEntity> findPopularInterviewItems() {
		String sql="from PopularJavaInterviewEntity";
		Query query=em.createQuery(sql);
		List<PopularJavaInterviewEntity> popularJavaInterviewEntities=query.getResultList();
		return popularJavaInterviewEntities;
	}
	
	@Override
	public PopularJavaInterviewEntity  updatePopularJavaInterview(PopularJavaInterviewEntity entity) {
		PopularJavaInterviewEntity dentity=(PopularJavaInterviewEntity)em.getReference(PopularJavaInterviewEntity.class, entity.getPjiid());
		dentity.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		dentity.setAuthor(entity.getAuthor());
		dentity.setIcon(entity.getIcon());
		dentity.setImage(entity.getImage());
		dentity.setTechnology(entity.getTechnology());
		dentity.setText(entity.getText());
		dentity.setUrl(entity.getUrl());
		dentity.setUserid(entity.getUserid());
		return dentity;
	}
	
	
	@Override
	public PopularJavaInterviewEntity findPopularJavaInterviewEntityById(int pjiid){
		return (PopularJavaInterviewEntity)em.find(PopularJavaInterviewEntity.class, pjiid);
	}
	
	
	@Override
	public List<CompanyBusinessEntity> findCompanyBusinessItems() {
		String sql="from CompanyBusinessEntity";
		Query query=em.createQuery(sql);
		List<CompanyBusinessEntity> companyBusinessEntities=query.getResultList();
		return companyBusinessEntities;
	}
	
	@Override
	public CompanyBusinessEntity  updateCompanyBusiness(CompanyBusinessEntity entity) {
		CompanyBusinessEntity dentity=(CompanyBusinessEntity)em.getReference(CompanyBusinessEntity.class, entity.getCbid());
		dentity.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		dentity.setImage(entity.getImage());
		dentity.setMainHeading(entity.getMainHeading());
		dentity.setText(entity.getText());
		dentity.setUrl(entity.getUrl());
		dentity.setUserid(entity.getUserid());
		return dentity;
	}
	
	
	@Override
	public CompanyBusinessEntity findCompanyBusinessEntityById(int cbid){
		return (CompanyBusinessEntity)em.find(CompanyBusinessEntity.class, cbid);
	}
	
	
}
