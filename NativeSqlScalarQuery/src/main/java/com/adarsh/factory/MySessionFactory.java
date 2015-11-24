package com.adarsh.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
public class MySessionFactory {
     
	    private static SessionFactory sessionFactoryObject=null;
	    
	    static{
	    	sessionFactoryObject=new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
	    }
	    
	    public static SessionFactory getSessionFactory(){
	    	return sessionFactoryObject;
	    }
	
}
