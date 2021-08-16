package com.techquiz.control.panel.service;

import java.util.List;

import com.techquiz.control.panel.controller.model.LoginSliderVO;
import com.techquiz.control.panel.controller.model.MainSliderVO;

/**
 * 
 * @author Nagendra
 *
 */
public interface LoginPageControlService {

	public List<LoginSliderVO> findLoginPageContents();

	public LoginSliderVO updateLoginPageItem(LoginSliderVO loginSliderVO);

	public LoginSliderVO findLoginPageVOById(int lpid);

}
