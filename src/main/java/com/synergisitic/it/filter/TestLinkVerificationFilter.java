package com.synergisitic.it.filter;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.synergisitic.it.listener.CreateDefaultUserListener;
import com.synergisitic.it.model.User;
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.LoggedInUserSessionUtil;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

public class TestLinkVerificationFilter  implements Filter {

	private static final Log logger = LogFactory.getLog(CreateDefaultUserListener.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//here we can write code for validating the link....
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		///OnlineTechTest
		//here our final url starts from slash
		String tlink=httpRequest.getParameter("utid");
		System.out.println("tlink = "+tlink);
		//here we have to database varification for link
		//Here ServletContext is application scope in JSP/Servlet container
		ServletContext context = httpRequest.getSession().getServletContext();
		// Here I am going to access spring root web application context
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		//UsererviceImpl userService = (UsererviceImpl) applicationContext.getBean("usererviceImpl");
		OnlineTechTestService testService = (OnlineTechTestService) applicationContext.getBean("OnlineTechTestServiceImpl");
		IConsultantAssesmentService consultantAssesmentService = (IConsultantAssesmentService) applicationContext.getBean("ConsultantAssesmentService");
		try {
			//fetching the test as per URL and we have to put a lot of validation
			AssignedTestUserForm atForm = testService.findAssignedTestByURL(tlink);
			if(atForm==null){
				HttpServletResponse resp=(HttpServletResponse)response;
				//Loading the test for registered user
				resp.sendRedirect(((HttpServletRequest) request).getContextPath()+"/action/load-tech-test?testName="+atForm.getTestName()+"&techName="+atForm.getTechName());
				//forward to the error page
				resp.sendRedirect(((HttpServletRequest) request).getContextPath()+"/home.jsp");
			}else if(atForm!=null && "COMPLETED".equalsIgnoreCase(atForm.getTestStatus())){
				HttpServletResponse resp=(HttpServletResponse)response;
				resp.sendRedirect(((HttpServletRequest) request).getContextPath()+"/home.jsp");
			}
			else if(atForm!=null &&  (atForm.getTestStatus().equals(ApplicationContant.NOT_STARTED) || atForm.getTestStatus().equals(ApplicationContant.IN_PROGRESS)))	{
				//create session for user
				ConsultantsVO consultantsVO=consultantAssesmentService.findConsultantByUserid(atForm.getUserId());
				UserId userId=new UserId();
				//userId.setId();
				userId.setLoginId(atForm.getUserId());
				//userId.setPassword(duser.getPassword());
				String	 forwardedURL="/action/consultantHomePage";
				User cuser=new User();
				cuser.setLoginid(consultantsVO.getUserid());
				cuser.setBatch(consultantsVO.getBatch());
				cuser.setConsultantid(consultantsVO.getEmpid());
				cuser.setRole(consultantsVO.getRole());
				cuser.setPassword(consultantsVO.getPassword());
				cuser.setEmail(consultantsVO.getEmail());
				cuser.setGender(consultantsVO.getGender());
				cuser.setMobile(consultantsVO.getMobile());
				cuser.setFirstName(consultantsVO.getName());
				cuser.setStream(consultantsVO.getStream());
				cuser.setActive(consultantsVO.getActive());
				cuser.setLockStatus(consultantsVO.getLockStatus());
				cuser.setAddress(consultantsVO.getOrg());
	    	 	LoggedInUserSessionUtil.createSession(httpRequest,cuser,forwardedURL.substring(1));
				//redirect to load test page
				HttpServletResponse resp=(HttpServletResponse)response;
				//Loading the test for registered user
				resp.sendRedirect(((HttpServletRequest) request).getContextPath()+"/action/load-tech-test?testName="+atForm.getTestName()+"&techName="+atForm.getTechName());
			}
			else {
				throw new Exception("Invalid Test");
			}	
		}
		catch(NoResultException e)
		{
			if(logger.isDebugEnabled()){
        		logger.debug("*****Invalid Link******"+tlink);
     		}
			request.setAttribute("errorMsg","Invalid Link");
			HttpServletResponse resp=(HttpServletResponse)response;
			resp.sendRedirect(((HttpServletRequest) request).getContextPath()+"/home.jsp");
		} catch (Exception e) {
			request.setAttribute("errorMsg","Invalid Test");
			HttpServletResponse resp=(HttpServletResponse)response;
			resp.sendRedirect(((HttpServletRequest) request).getContextPath()+"/home.jsp");
		}
	}
	
	

	@Override
	public void destroy() {
		
	}

}
