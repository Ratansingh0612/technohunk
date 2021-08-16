package com.synergisitic.it.controller.advice;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.synergisitic.it.navigation.CommonNavigationPage;

/**
 * 
 * @author Nagendra
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		return "database_error";
	}
	
	//@ResponseStatus( reason="GeneralException")
	@ExceptionHandler(Exception.class)
	public String handleIOException(HttpServletRequest request, Exception ex,Model model){
		 ex.printStackTrace();
		 return CommonNavigationPage.COMMON_BASE+CommonNavigationPage.SESSION_EXPIRED_PAGE;
	}
}
