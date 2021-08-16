package com.techquiz.control.panel.dao;

import java.util.List;

import com.techquiz.control.panel.dao.entity.LoginSliderEntity;

/**
 * 
 * @author Nagendra
 *
 */
public interface LoginPageControlDao {

	public List<LoginSliderEntity> findSliderItems();
	public LoginSliderEntity updateLoginPage(LoginSliderEntity entity);
	public LoginSliderEntity findLoginPageContenByLpid(int lpid);

}
