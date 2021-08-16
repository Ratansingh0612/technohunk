package com.techquiz.control.panel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techquiz.control.panel.controller.model.LoginSliderVO;
import com.techquiz.control.panel.controller.model.MainSliderVO;
import com.techquiz.control.panel.dao.LoginPageControlDao;
import com.techquiz.control.panel.dao.entity.LoginSliderEntity;
import com.techquiz.control.panel.service.LoginPageControlService;

@Repository("LoginPageControlServiceImpl")
@Transactional
public class LoginPageControlServiceImpl implements LoginPageControlService {

	
	@Autowired
	@Qualifier("LoginPageControlDaoImpl")
	private LoginPageControlDao loginPageControlDao;
	
	@Override
	public List<LoginSliderVO> findLoginPageContents() {
		 List<LoginSliderVO> mainSliderVOs=new ArrayList<>();
		 List<LoginSliderEntity>  loginSliderEntityList=loginPageControlDao.findSliderItems();
		 for(LoginSliderEntity entity:loginSliderEntityList){
			 LoginSliderVO loginSliderVO=new LoginSliderVO();
			 BeanUtils.copyProperties(entity, loginSliderVO);
			 mainSliderVOs.add(loginSliderVO);
		 }
		 return mainSliderVOs;
	}
	
	@Override
	public LoginSliderVO updateLoginPageItem(LoginSliderVO loginSliderVO){
		LoginSliderEntity pentity=new LoginSliderEntity();
		 BeanUtils.copyProperties(loginSliderVO, pentity);
		 LoginSliderEntity	entity=loginPageControlDao.updateLoginPage(pentity);
		 LoginSliderVO loginSliderVO2=new LoginSliderVO();
		BeanUtils.copyProperties(entity, loginSliderVO2);
		return loginSliderVO2;
	}
	
	@Override
	public LoginSliderVO findLoginPageVOById(int lpid) {
		LoginSliderVO loginSliderVO=new LoginSliderVO();
		 BeanUtils.copyProperties(loginPageControlDao.findLoginPageContenByLpid(lpid), loginSliderVO);
		 return loginSliderVO;
	}
	
}
