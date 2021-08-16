package com.techquiz.programys.exception.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.programys.common.controller.model.ErrorLogForm;
import com.techquiz.programys.common.service.ISessionSchedule;
//Since Spring 3.2
@ControllerAdvice
public class GpsGlobalExceptionHandler {
	
	public GpsGlobalExceptionHandler(){
		System.out.println("_@_@_GpsGlobalExceptionHandler@@_____");
		System.out.println("_@_@_GpsGlobalExceptionHandler@@_____");
	}
	
	
	@Autowired
	@Qualifier("SessionSchedule")
	private ISessionSchedule sessionSchedule;
	
	
	 private void logExceptionIntoDatabase(Exception ex,HttpServletRequest request){
		  StringWriter stringWriter=new StringWriter();
		  PrintWriter printWriter=new  PrintWriter(stringWriter);
		  ex.printStackTrace(printWriter);
		  String exceptionMessage=stringWriter.toString();
		  UserId userid=(UserId)request.getSession().getAttribute(ApplicationContant.USER_SESSION_DATA);
		  ErrorLogForm errorLogForm=new ErrorLogForm();
		  errorLogForm.setErrorText(exceptionMessage);
		  errorLogForm.setUserName(userid.getLoginId());
		  errorLogForm.setDoe(new Timestamp(new Date().getTime()));
		  sessionSchedule.logAppErrorDb(errorLogForm);
		  
	  }
	  
	  /**
		 *  <init-param>
	        <param-name>throwExceptionIfNoHandlerFound</param-name>
	        <param-value>true</param-value>
	    	</init-param>
		 * @param req
		 * @param ex
		 * @return
		 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandlerFoundException(HttpServletRequest req, Exception exception)   {
			 ModelAndView mav = new ModelAndView();
			    mav.addObject("exception", exception);
			    mav.addObject(ApplicationMessageConstant.APPLICATION_MESSAGE,"Error occurs during processing request at the server...");
			    exception.printStackTrace();
			    logExceptionIntoDatabase(exception,req);
			    mav.setViewName(CommonNavigationPage.COMMON_BASE + CommonNavigationPage.ERROR_STATUS_PAGE);
			    return mav;
	 }
	
	 @ExceptionHandler(IOException.class)
	  public ModelAndView commonError(HttpServletRequest req,IOException exception) {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject(ApplicationMessageConstant.APPLICATION_MESSAGE,"Error occurs during processing the data");
	    mav.setViewName(CommonNavigationPage.COMMON_BASE + CommonNavigationPage.ERROR_STATUS_PAGE);
	    exception.printStackTrace();
	    logExceptionIntoDatabase(exception,req);
	    return mav;
	  }
	 
	 
	  @ExceptionHandler(NullPointerException.class)
	  public ModelAndView notFound(HttpServletRequest req,NullPointerException exception) {
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("exception", exception);
		    mav.addObject(ApplicationMessageConstant.APPLICATION_MESSAGE,"Your session  is seems to be timeout, please login in once again. ");
		    mav.setViewName(CommonNavigationPage.COMMON_BASE + CommonNavigationPage.ERROR_STATUS_PAGE);
		    exception.printStackTrace();
		    logExceptionIntoDatabase(exception,req);
		    return mav;
	  }
	  
	  @ExceptionHandler(RuntimeException.class)
	  public ModelAndView catchRuntimeException(HttpServletRequest req,Exception exception) {
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("exception", exception);
		    mav.addObject(ApplicationMessageConstant.APPLICATION_MESSAGE,"Your session  is seems to be timeout, please login in once again. ");
		    mav.setViewName(CommonNavigationPage.COMMON_BASE + CommonNavigationPage.ERROR_STATUS_PAGE);
		    exception.printStackTrace();
		    logExceptionIntoDatabase(exception,req);
		    return mav;
	  }
	  
	  @ExceptionHandler(Exception.class)
	  public ModelAndView generealException(HttpServletRequest req,Exception exception) {
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("exception", exception);
		    mav.addObject(ApplicationMessageConstant.APPLICATION_MESSAGE,"Your session  is seems to be timeout, please login in once again. ");
		    mav.setViewName(CommonNavigationPage.COMMON_BASE + CommonNavigationPage.ERROR_STATUS_PAGE);
		    exception.printStackTrace();
		    logExceptionIntoDatabase(exception,req);
		    return mav;
	  }

}
