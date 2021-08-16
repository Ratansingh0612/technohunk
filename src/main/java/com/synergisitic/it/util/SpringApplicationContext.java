package com.synergisitic.it.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Deprecated
public class SpringApplicationContext {
		
	private static ApplicationContext applicationContext;
	
	public static void init(String contextFileName){
		 if(applicationContext==null){
			 applicationContext=new
			 ClassPathXmlApplicationContext(contextFileName);
		 }
	}
	
	public static Object getBean(String beanName){
		return applicationContext.getBean(beanName);
	}

}
