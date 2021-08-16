package com.synergisitic.it.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.synergisitic.it.model.User;
import com.synergisitic.it.web.form.UserId;

/**
 * 
 * @author nagendra
 * @Since 31-05-2018
 *
 */
public class LoggedInUserSessionUtil {
	
	public static void clearTestDataFromSession(HttpSession session) {
		   session.removeAttribute("currentQuestionNo");
		   session.removeAttribute("questionsMapForTest");
		   session.removeAttribute("testName");
		   session.removeAttribute("techName");
		   session.removeAttribute("utestName");
		   session.removeAttribute("utechName");
		   session.removeAttribute("currentQuestionNo");
	       session.removeAttribute("currentQuestionId");
	       session.removeAttribute("correctAnswerId");
	       session.removeAttribute("testDuration");
	       session.removeAttribute("userSessionId");
	}
	
	/**
	 * This method creates session once user
	 * logged in into the application and store id of user object and userid
	 * into the session.
	 * @param request
	 * @param duser actual object mapped into the database
	 */
	public static  void createSession(HttpServletRequest request,User duser,String homePage){
		HttpSession session=request.getSession(true);
		clearTestDataFromSession(session);
		UserId userId=new UserId();
		userId.setEmail(duser.getEmail());
		userId.setId(duser.getId());
		userId.setAddress(duser.getAddress());
		if("male".equalsIgnoreCase(duser.getGender())){
			userId.setSalutation("Mr.");
		}else{
			userId.setSalutation("Ms.");
		}
		if(duser.getLastName()!=null)
		userId.setName(duser.getFirstName()+" "+duser.getLastName());
		else{
			userId.setName(duser.getFirstName());
		}
		userId.setLoggedInTime(new Date());
		userId.setLoginId(duser.getLoginid());
		//userId.setPassword(duser.getPassword());
		userId.setHomePage(homePage);
		userId.setPassword(duser.getPassword());
		userId.setRole(duser.getRole());
		userId.setBatch(duser.getBatch());
		userId.setDeleteAllow(duser.isDeleteAllow());
		userId.setConsultantid(duser.getConsultantid());
		session.setAttribute(ApplicationContant.USER_SESSION_DATA, userId);
	}
	

}
