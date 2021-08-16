package com.synergisitic.it.base;

import java.util.Date;

import javax.servlet.http.HttpSession;

import com.synergisitic.it.web.form.UserId;

/**
 * 
 * @author nagendra.yadav
 *
 */
abstract public class AbstractUserSession {
	
	public Date getCurrentDate() {
		 Date date = new Date();
		 return date;
	}
	
	abstract public UserId getUserIdFromSession(HttpSession session);
	
	public static void main(String[] args) {
	//	System.out.println(new AbstractUserSession().getCurrentDate());
	}

}
