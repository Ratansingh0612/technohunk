package com.techquiz.control.panel.dao;

import java.util.List;

import com.techquiz.control.panel.dao.entity.CompanyBusinessEntity;
import com.techquiz.control.panel.dao.entity.MainSliderEntity;
import com.techquiz.control.panel.dao.entity.PopularJavaInterviewEntity;

/**
 * 
 * @author Nagendra
 *
 */
public interface LandingPageDao {

	public List<MainSliderEntity> findSliderItems();
	public MainSliderEntity findMainSliderVOById(int lpid);
	public MainSliderEntity updateSliderItems(MainSliderEntity entity);

	public List<PopularJavaInterviewEntity> findPopularInterviewItems();
	public PopularJavaInterviewEntity updatePopularJavaInterview(PopularJavaInterviewEntity entity);
	public PopularJavaInterviewEntity findPopularJavaInterviewEntityById(int pjiid);
	
	public List<CompanyBusinessEntity> findCompanyBusinessItems();
	public CompanyBusinessEntity updateCompanyBusiness(CompanyBusinessEntity entity);
	public CompanyBusinessEntity findCompanyBusinessEntityById(int cbid);
	
}
