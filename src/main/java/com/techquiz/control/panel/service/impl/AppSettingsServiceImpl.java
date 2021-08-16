package com.techquiz.control.panel.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.techquiz.control.panel.controller.model.AppSettingsVO;
import com.techquiz.control.panel.dao.AppSettingsDao;
import com.techquiz.control.panel.dao.entity.AppSettingsEntity;
import com.techquiz.control.panel.service.AppSettingsService;

@Service("AppSettingsServiceImpl")
public class AppSettingsServiceImpl implements AppSettingsService {

	@Autowired
	@Qualifier("AppSettingsDaoImpl")
	private AppSettingsDao  appSettingsDao;
	
	@Override
	public AppSettingsVO findAppDefaultSettings(int isid) {
		AppSettingsEntity appSettingsEntity=(AppSettingsEntity)appSettingsDao.findAppDefaultSettings(isid);
		AppSettingsVO appSettingsVO=new AppSettingsVO();
		if(appSettingsEntity!=null)
		BeanUtils.copyProperties(appSettingsEntity,appSettingsVO);
		return appSettingsVO;
	}
	
}
