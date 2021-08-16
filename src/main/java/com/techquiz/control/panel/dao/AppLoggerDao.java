package com.techquiz.control.panel.dao;

import com.techquiz.control.panel.dao.entity.AppLoggerEntity;

public interface AppLoggerDao {

	public String saveErrorLog(AppLoggerEntity appLoggerEntity);

}
