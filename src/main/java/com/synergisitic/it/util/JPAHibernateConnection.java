/*package com.synergisitic.it.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

*//**
 * 
 * @author nagendra.yadav
 *  this is based on Singleton Design Pattern
 *  Because this code make sure that only one instance of
 *  SessionFactory is created.
 *
 *//*
public class JPAHibernateConnection {
	
	private static EntityManagerFactory entityManagerFactory;
	
	//static block will execute only one time , when class is loaded
	static{
		 entityManagerFactory=Persistence.createEntityManagerFactory("professorUnit");
	}
	
	public static EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
	
	public static void closeEntityManager(){
		if(entityManagerFactory!=null){
			entityManagerFactory.close();
			System.out.println("#################entityManagerFactory  is closed!###########");
			
		}
		
	}
	


}
*/