package com.adarsh.hibernate.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionFactory {

    private static SessionFactory sessionFactoryObject = null;
    private static final Logger logger = LoggerFactory.getLogger("MySessionFactory");

    static {
        sessionFactoryObject = new Configuration().configure("hibernate/configuration/hibernate-cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactoryObject;
    }

}
