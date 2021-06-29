package com.adarsh.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionFactory {

    private static SessionFactory sessionFactoryObject = null;
    private static final Logger logger = LoggerFactory.getLogger("MySessionFactory");

    static {

        Configuration hibernateConfigurationObject = new Configuration();
        hibernateConfigurationObject = hibernateConfigurationObject.configure("hibernate/configuration/Myhibernate-cfg.xml");
        sessionFactoryObject = hibernateConfigurationObject.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactoryObject;
    }

}
