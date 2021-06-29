package com.adarsh.hibernate.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class MySessionFactory {

    private static SessionFactory sessionFactoryObject = null;

    static {
        sessionFactoryObject = new Configuration().configure("hibernate/configuration/hibernate-cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactoryObject;
    }

}
