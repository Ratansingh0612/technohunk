package com.synergisitic.it.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.synergisitic.it.email.service.IAttendanceEmailReminderService;

/**
 * 
 * @author nagendra.yadav This class will create a default user for the
 *         application as an admin role.
 *         ..............
 * 
 *         Note : we have create some concrete class which implements
 *         ServletContextListener
 *         @author VC1@
 *         @since
 *         
 *         
 * 
 */
public class CreateDefaultUserListener implements ServletContextListener {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(CreateDefaultUserListener.class);

	@Override
	/**
	 * This method will be invoked at the timing deploying the application
	 * 
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is up and running...#&^#^#^#^#^#^#");
		if (logger.isInfoEnabled()) {
			logger.info(" inside starting of the method contextInitialized");
		}
		
		//Here ServletContext is application scope in JSP/Servlet container
		/*ServletContext context = sce.getServletContext();
		// Here I am going to access spring root web application context
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		
		UsererviceImpl userService = (UsererviceImpl) applicationContext
				.getBean("usererviceImpl");
		User user = userService.findUserById(1);
		if (user == null) {
			User duser = new User();
			duser.setAddress("New Delhi");
			duser.setDescription("This default user");
			duser.setDob(new java.util.Date());
			duser.setEmail(context.getInitParameter("adminemail"));
			duser.setFirstName("admin");
			duser.setLastName("admin");
			duser.setLoginid(context.getInitParameter("adminlogin"));
			duser.setMobile(context.getInitParameter("adminmobile"));
			duser.setRole("admin");
			try {
				//DESedeEncryption deSedeEncryption = new DESedeEncryption();
				String adminpassword = context
						.getInitParameter("adminpassword");
				//String dpassword = deSedeEncryption.encrypt(adminpassword);
				duser.setPassword(adminpassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (logger.isDebugEnabled()) {
				logger.debug(duser);
			}
			userService.addUser(duser);
		}*/
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("_@@)##(#@*@*##&Application is down and not running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is down and not running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is down and not running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is down and not running...#&^#^#^#^#^#^#");
		System.out.println("_@@)##(#@*@*##&Application is down and not running...#&^#^#^#^#^#^#");
		
		int mb = 1024 * 1024; 
		// get Runtime instance
		Runtime instance = Runtime.getRuntime();
		logger.debug("***** Heap utilization statistics [MB] *****\n");
		// available memory
		logger.debug("Total Memory: " + instance.totalMemory() / mb);
		// free memory
		logger.debug("Free Memory: " + instance.freeMemory() / mb);
		// used memory
		logger.debug("Used Memory: "
				+ (instance.totalMemory() - instance.freeMemory()) / mb);
		// Maximum available memory
		logger.debug("Max Memory: " + instance.maxMemory() / mb);
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		//String imageContextPath=DateUtils.getImageContextPath(request);
		String imageContextPath="http://javahunk.com/images/";
		String message="Sorry your application is down now , please look into this.";
		IAttendanceEmailReminderService attendanceEmailReminderService=(IAttendanceEmailReminderService)applicationContext.getBean("AttendanceEmailReminderService");
		attendanceEmailReminderService.sendConfirmationEmail(message, "Mr Nagendra","javahunk100@gmail.com", imageContextPath);
	}

}
