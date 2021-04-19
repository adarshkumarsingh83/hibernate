package com.adarsh.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

    static SessionFactory sessionFactoryObject = null;

    public static SessionFactory getHibernateSession() {
        if (sessionFactoryObject == null) {
            sessionFactoryObject = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
        }
        return sessionFactoryObject;
    }
}
