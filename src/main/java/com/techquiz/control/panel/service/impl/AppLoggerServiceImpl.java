package com.techquiz.control.panel.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techquiz.codings.web.controller.vo.AppLoggerVO;
import com.techquiz.control.panel.dao.AppLoggerDao;
import com.techquiz.control.panel.dao.entity.AppLoggerEntity;
import com.techquiz.control.panel.service.AppLoggerService;

@Service("AppLoggerServiceImpl")
@Transactional
public class AppLoggerServiceImpl implements AppLoggerService {

	@Autowired
	@Qualifier("AppLoggerDaoImpl")
	private AppLoggerDao  appLoggerDao;

	@Override
	public String saveErrorLog(AppLoggerVO appLoggerVO) {
		AppLoggerEntity appLoggerEntity=new AppLoggerEntity();
		BeanUtils.copyProperties(appLoggerVO, appLoggerEntity);;
		String response=appLoggerDao.saveErrorLog(appLoggerEntity);
		return response;
	}

}
