/*package com.experian.checkout.security;


 * @author : Srinath Medala(a03678a)
 * @version : 1.0
 
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.AuthenticationManager;
//import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;
//import org.springframework.util.TextUtils;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

import com.experian.checkout.common.ApplicationConfig;
import com.experian.checkout.common.Constants;
import com.experian.checkout.domain.PFConfiguration;
import com.experian.checkout.domain.User;
import com.experian.checkout.exception.CheckoutBaseException;
import com.experian.checkout.service.MailUtility;
import com.experian.checkout.service.UserService;
import com.experian.checkout.util.EncryptUtil;




public class CustomAuthenticationProcessingFilter  extends UsernamePasswordAuthenticationFilter{//AuthenticationProcessingFilter{
	
	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";

	@Autowired
	UserService userService;
	
	@Autowired
	EncryptUtil encryptUtil;
	
	@Autowired
	private MailUtility mailUtility;
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.ui.AbstractProcessingFilter#
	 * onSuccessfulAuthentication(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.Authentication) This method specifically is
	 * overwritten to log the login time of the user once the user is
	 * successfully authenticated by the system
	 
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response,FilterChain chain, Authentication authResult)
			throws IOException,ServletException {

		try {
			super.successfulAuthentication(request, response,chain, authResult);
			String currentUserNameKey = request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);//AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY;
			String currentUserName = "";
			User user = null;
			if (request.getSession().getAttribute(currentUserNameKey) != null) {
				currentUserName = (String) request.getSession().getAttribute(
						currentUserNameKey);
				user = (User) userService.findUserByUserName(currentUserName);
			}
			if(user.getLoginDate() != null){
				Date lastloginDate = user.getLoginDate();			
				user.setLastLoginDate(lastloginDate);
			}
			user.setLoginDate(new Date());
			
			if(user.getUserStatusCode().equals(Constants.USER_STATUS_CODE_LOCKED)) {
				user.setUserStatusCode(Constants.USER_STATUS_CODE_ACTIVE);
				user.setLockedTime(null);
			}
			
			userService.mergeUser(user);
		} catch (IOException e) {
			throw new IOException();
		} catch (CheckoutBaseException c) {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
        String password = obtainPassword(request);
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        } else {
        	//IMPORTANT DO NOT DELETE THIS BLOCK OF CODE
        	if(password.length() > 16) {
        		//Reset the Password to Null
        		//This should not happen
        		//This is Security Exception 
        		password="";
        	}
        }
        
        username = username.trim().toLowerCase();
        
        //GC Modification Starts
        if(request.getParameter(Constants.GC_AUTH_TOKEN) != null) {           
        	try {
				String clearTextToken = encryptUtil.decrypty3DESWithURL(request.getParameter(Constants.GC_AUTH_TOKEN));
				if(clearTextToken.indexOf("::") > 0) {
					username = encryptUtil.getUserNamefromToken(clearTextToken);					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				logger.error("Unable to Decrypt the Token");
				e1.printStackTrace();
			}        	
           //String    		request.getParameter(Constants.CSC_APP_LOGIN).equalsIgnoreCase(Constants.YES)) {
        	try {
        		if(username != null && username.length() > 0) {
					User user=userService.findUserByUserName(username);
					if(user != null && user.getUserName() != null) {
						//USER Exist
						//Assign the Token to the password Field						
						password=request.getParameter(Constants.GC_AUTH_TOKEN);
						
						//CSC App Request
						request.getSession().setAttribute(Constants.CSC_APP_REQUEST, "Y");
						
					}
        		}
			} catch (CheckoutBaseException e) {				
				e.printStackTrace();
			}
        }
        //GC Modification ENDS 
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        // Place the last username attempted into HttpSession for views
        HttpSession session = request.getSession(false);

        if (session != null || getAllowSessionCreation()) {
            request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextEscapeUtils.escapeEntities(username));//TextUtils.escapeEntities(username));
            
            //request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextUtils.escapeEntities(username));
            //request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextUtils.escapeEntities(username));

        }

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);
        Authentication auth = null;
        try {
        	auth = this.getAuthenticationManager().authenticate(authRequest);
        } catch (AuthenticationException e) {    		
        	checkLoginAttempts(request,username);
        	throw e;
        	
        }
        
        
        if(auth.getPrincipal()!=null){
        	SecurityUser s = (SecurityUser)auth.getPrincipal();
        	User u = s.getUser();
        	String firstName = u.getFirstName();
        	String lastName = u.getLastName();
        	 request.getSession().setAttribute(Constants.USER_FIRST_NAME, firstName);
        	 request.getSession().setAttribute(Constants.USER_LAST_NAME, lastName);
        	//Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
            System.out.println("");
        }
        return auth;
	}
        
	*//**
	 * 
	 * @param request
	 * @param username
	 *//*

	private void checkLoginAttempts(HttpServletRequest request, String username) {
		Integer loginCount = (Integer) request.getSession().getAttribute(Constants.SESSION_LOGIN_ATTEMPT_COUNT_PARAM);
        if (loginCount == null) {
            loginCount = 0;
        }
        if (loginCount < 5) {
            loginCount++;
            request.getSession().setAttribute(Constants.SESSION_LOGIN_ATTEMPT_COUNT_PARAM, loginCount);
        }

        if (loginCount >= 5) {        	
        	try {
				User user = (User) userService.findUserByUserName(username);
				if(user != null) {
					user.setUserStatusCode(Constants.USER_STATUS_CODE_LOCKED);
					user.setLockedTime(new Timestamp(new Date().getTime()));
					userService.mergeUser(user);
				}
				String []receipients = receipients = new String[] {"anjali.pipriya@experian.com",Constants.MARKETINGTECHNOLOGISTS};
				HashMap model = new HashMap();
				model.put("username",username);
				model.put("time", new Date());
				model.put("webContext", applicationConfig.getEnvHost());
				model.put("remoteaddress", request.getRemoteAddr());
				
				mailUtility.sendMail(model, receipients,"security-alert.vm","Ecommerce: Security Alert");
				
			} catch (CheckoutBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 		
	}

  
	
}
*/