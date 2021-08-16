package com.techquiz.control.panel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.techquiz.control.panel.controller.model.CompanyBusinessVO;
import com.techquiz.control.panel.controller.model.MainSliderVO;
import com.techquiz.control.panel.controller.model.PopularJavaInterviewVO;
import com.techquiz.control.panel.dao.LandingPageDao;
import com.techquiz.control.panel.dao.entity.CompanyBusinessEntity;
import com.techquiz.control.panel.dao.entity.MainSliderEntity;
import com.techquiz.control.panel.dao.entity.PopularJavaInterviewEntity;
import com.techquiz.control.panel.service.LandingPageService;

/**
 * 
 * @author Nagendra
 *
 */
@Service("LandingPageServiceImpl")
public class LandingPageServiceImpl implements LandingPageService {
	
	@Autowired
	@Qualifier("LandingPageDaoImpl")
	private LandingPageDao landingPageDao;
	
	@Override
	public List<MainSliderVO> findSliderItems() {
		 List<MainSliderVO> mainSliderVOs=new ArrayList<>();
		 List<MainSliderEntity>  mainSliderEntititList=landingPageDao.findSliderItems();
		 for(MainSliderEntity entity:mainSliderEntititList){
			 MainSliderVO mainSliderVO=new MainSliderVO();
			 BeanUtils.copyProperties(entity, mainSliderVO);
			 mainSliderVOs.add(mainSliderVO);
		 }
		 return mainSliderVOs;
	}
	
	@Override
	public MainSliderVO updateSliderItems(MainSliderVO mainSliderVO){
		MainSliderEntity pentity=new MainSliderEntity();
		 BeanUtils.copyProperties(mainSliderVO, pentity);
		MainSliderEntity	entity=landingPageDao.updateSliderItems(pentity);
		MainSliderVO emainSliderVO=new MainSliderVO();
		BeanUtils.copyProperties(entity, emainSliderVO);
		return emainSliderVO;
	}
	
	@Override
	public MainSliderVO findMainSliderVOById(int lpid) {
		 MainSliderVO mainSliderVO=new MainSliderVO();
		 BeanUtils.copyProperties(landingPageDao.findMainSliderVOById(lpid), mainSliderVO);
		return mainSliderVO;
	}
	
	
	@Override
	public List<PopularJavaInterviewVO> findPopularInterviewItems() {
		 List<PopularJavaInterviewVO>  popularJavaInterviewVOs=new ArrayList<PopularJavaInterviewVO>();
		 List<PopularJavaInterviewEntity>  entitityList=landingPageDao.findPopularInterviewItems();
		 for(PopularJavaInterviewEntity entity:entitityList){
			 PopularJavaInterviewVO popularJavaInterviewVO=new PopularJavaInterviewVO();
			 BeanUtils.copyProperties(entity, popularJavaInterviewVO);
			 popularJavaInterviewVOs.add(popularJavaInterviewVO);
		 }
		 return popularJavaInterviewVOs;
	}
	
	@Override
	public PopularJavaInterviewVO updatePopularJavaInterviewItem(PopularJavaInterviewVO  interviewVO){
		PopularJavaInterviewEntity pentity=new PopularJavaInterviewEntity();
		 BeanUtils.copyProperties(interviewVO, pentity);
		 PopularJavaInterviewEntity	entity=landingPageDao.updatePopularJavaInterview(pentity);
		 PopularJavaInterviewVO  popularJavaInterviewVO=new PopularJavaInterviewVO();
		BeanUtils.copyProperties(entity, popularJavaInterviewVO);
		return popularJavaInterviewVO;
	}
	
	@Override
	public PopularJavaInterviewVO findPopularJavaInterviewEntityById(int pjiid) {
		PopularJavaInterviewVO popularJavaInterviewVO=new PopularJavaInterviewVO();
		 BeanUtils.copyProperties(landingPageDao.findPopularJavaInterviewEntityById(pjiid), popularJavaInterviewVO);
		return popularJavaInterviewVO;
	}
	
	
	@Override
	public List<CompanyBusinessVO> findCompanyBusinessItems() {
		 List<CompanyBusinessVO>  companyBusinessVOs=new ArrayList<CompanyBusinessVO>();
		 List<CompanyBusinessEntity>  entitityList=landingPageDao.findCompanyBusinessItems();
		 for(CompanyBusinessEntity entity:entitityList){
			 CompanyBusinessVO companyBusinessVO=new CompanyBusinessVO();
			 BeanUtils.copyProperties(entity, companyBusinessVO);
			 companyBusinessVOs.add(companyBusinessVO);
		 }
		 return companyBusinessVOs;
	}
	
	@Override
	public CompanyBusinessVO updateCompanyBusiness(CompanyBusinessVO  pcompanyBusinessVO){
		CompanyBusinessEntity pentity=new CompanyBusinessEntity();
		 BeanUtils.copyProperties(pcompanyBusinessVO, pentity);
		 CompanyBusinessEntity	entity=landingPageDao.updateCompanyBusiness(pentity);
		 CompanyBusinessVO  companyBusinessVO=new CompanyBusinessVO();
		BeanUtils.copyProperties(entity, companyBusinessVO);
		return companyBusinessVO;
	}
	
	@Override
	public CompanyBusinessVO findCompanyBusinessEntityById(int pjiid) {
		CompanyBusinessVO companyBusinessVO=new CompanyBusinessVO();
		 BeanUtils.copyProperties(landingPageDao.findCompanyBusinessEntityById(pjiid), companyBusinessVO);
		return companyBusinessVO;
	}
	
	
	

}
