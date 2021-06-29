package com.adarsh.sessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
    private static SessionFactory sessionFacoryObject = null;

    static {
        sessionFacoryObject = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFacoryObject;
    }
}
