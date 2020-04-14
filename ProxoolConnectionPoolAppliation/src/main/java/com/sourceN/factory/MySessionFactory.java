package com.sourceN.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionFactory {

    private static final Logger logger = LoggerFactory.getLogger("MySessionFactory.class");
    private static SessionFactory sessionFactoryObject = null;

    static {
        sessionFactoryObject = new Configuration().configure("hibernate/configuration/hibernate-cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactoryObject;
    }

}
