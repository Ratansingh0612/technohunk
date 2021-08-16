package com.synergisitic.it.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.synergisitic.it.model.User;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.SpringApplicationContext;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@Deprecated //this is eclipse feature
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	//I have to fetch all the data which used has filled on  UI
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String dob=request.getParameter("dob");
		String description=request.getParameter("description");
		
		//AGENDA = ?
		//Servlet and Spring Integration
		SpringApplicationContext.init("applicationContext.xml");
		User user=(User)SpringApplicationContext.getBean("user");
	
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setDob(new Date());
		user.setDoe(new Date());
		user.setDescription(description);
		user.setAddress(address);
		user.setMobile(mobile);
		user.setLoginid(firstName); //
		user.setPassword("admin");
		
		UsererviceImpl userService=(UsererviceImpl)SpringApplicationContext.getBean("usererviceImpl");
		String result=userService.addUser(user);
		
		//forwarding request to the JSP page
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		request.setAttribute("message","Dear User ,"+firstName+"! , You have registered into the application,Thanks!");
		rd.forward(request, response);
		
		///I have to call service Layer
		
	}

}
