package com.synergisitic.it.util;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.techquiz.codings.web.controller.vo.AppLoggerVO;
import com.techquiz.control.panel.service.AppLoggerService;

/**
 * 
 * @author VC1
 * @since 01-AUG-2018
 */
public class ErrorLoggerDBUtils {
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ErrorLoggerDBUtils.class);

	public static void logErrorInDb(AppLoggerVO appLoggerVO){
		 if(logger.isErrorEnabled()){
			 logger.error(appLoggerVO);
		 }
		 appLoggerVO.setDoe(new Timestamp(new Date().getTime()));
		 ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		 AppLoggerService appLoggerService=(AppLoggerService)applicationContext.getBean("AppLoggerServiceImpl");
		 appLoggerService.saveErrorLog(appLoggerVO);
		
	}
}
