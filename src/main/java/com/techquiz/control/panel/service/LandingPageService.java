package com.techquiz.control.panel.service;

import java.util.List;

import com.techquiz.control.panel.controller.model.CompanyBusinessVO;
import com.techquiz.control.panel.controller.model.MainSliderVO;
import com.techquiz.control.panel.controller.model.PopularJavaInterviewVO;

/**
 * 
 * @author Nagendra
 *
 */
public interface LandingPageService {

	public List<MainSliderVO> findSliderItems();
	public MainSliderVO 	findMainSliderVOById(int lpid);
	public MainSliderVO updateSliderItems(MainSliderVO mainSliderVO);
	
	public List<PopularJavaInterviewVO> findPopularInterviewItems();
	public PopularJavaInterviewVO updatePopularJavaInterviewItem(PopularJavaInterviewVO interviewVO);
	public PopularJavaInterviewVO findPopularJavaInterviewEntityById(int pjiid);
	
	public List<CompanyBusinessVO> findCompanyBusinessItems();
	public CompanyBusinessVO updateCompanyBusiness(CompanyBusinessVO pcompanyBusinessVO);
	public CompanyBusinessVO findCompanyBusinessEntityById(int pjiid);

	
}
