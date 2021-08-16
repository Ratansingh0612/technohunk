package com.synergisitic.it.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.synergisitic.it.listener.CreateDefaultUserListener;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.UserId;

/**
 * Access filter class
 * nagendra.yadav
 */
public class OnlineTechFilter implements Filter {
	

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(OnlineTechFilter.class);

	@SuppressWarnings("unused")
	private Set<String> searchAllowPages;
	/**
	 * Method init.
	 * @param config
	 * @throws javax.servlet.ServletException
	 */
	public void init(FilterConfig config) throws ServletException {
        searchAllowPages=new HashSet<String>();
		String strList=config.getServletContext().getInitParameter("allowPages");
		String strToken[]=strList.split(",");
		for(String param : strToken){
			searchAllowPages.add(param);
		}
	}
	
	public void destroy() {
	}

	/**
	 * @param FilterChain is used to call another filter
	 * @param req
	 * @param resp
	 */

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws ServletException, IOException {
		String expath =((HttpServletRequest) req).getPathInfo();
		//System.out.println("expath = "+expath);
		String action = ((HttpServletRequest) req).getServletPath().substring(1);
		if(action==null  || action.length()<=1){
			    System.out.println("_@)@)@@)  = action = "+action);
				chain.doFilter(req, resp);
		}else {
		if(expath!=null)
        action=action+expath;
		if(logger.isDebugEnabled()){
		   logger.debug("****************************** = "+action);
	        logger.debug("searchAllowPages = "+searchAllowPages);
		}
     	if(action.contains("action/add-consultant-admin") || action.contains("action/consutant/registration") || action.contains("assessment") || action.contains("images")  || action.contains("css") || action.contains("js") || searchAllowPages.contains(action)){
						//Do not block the request for above requests
			     		//call other filter if filter exists or call requested resource
			     		chain.doFilter(req, resp);
		}else{
				//Give me session if session is already there otherwise return null	
				HttpSession session=((HttpServletRequest)req).getSession(false);
		        if(session!=null && session.getAttribute(ApplicationContant.USER_SESSION_DATA)!=null && ((UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA)).getLoginId()!=null){
					        	//Do not block the request for above requests
					     		//call other filter if filter exists or call requested resource
					        	if(logger.isDebugEnabled()) {
					        		logger.debug("*****Session exists for  ***** = "+action);
					     		}
					        	String userid=req.getParameter("login");
					        	if(action.contains("action/validateUser") &&  ((UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA)).getLoginId().equals(userid)) {
					        		req.setAttribute("errorMsg","Session time out,Please click on login button to login again!");
									HttpServletResponse response=(HttpServletResponse)resp;
									response.sendRedirect(((HttpServletRequest) req).getContextPath()+"/already-logged-in.jsp");
					        	}else {
					        			chain.doFilter(req, resp);
					        	}		
		        }else{
				    		if(logger.isDebugEnabled()){
				        		logger.debug("*****Session does not exist for  ***** = "+action);
				     		}
				    		if(action.contains("action/validateUser")) {
				    				chain.doFilter(req, resp);
				    		}else {
				    					req.setAttribute("errorMsg","Session time out,Please click on login button to login again!");
				    					HttpServletResponse response=(HttpServletResponse)resp;
				    					response.sendRedirect(((HttpServletRequest) req).getContextPath()+"/sessionExpired.jsp");
				    		}			
		        }
			/////modifying the response here######################
			logger.debug("AT LAST  =="+action);
		}
	}
	}

	


}



