package com.espark.adarsh.factory;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

@Slf4j
public class MySessionFactory {

    private static SessionFactory sessionFactoryObject = null;

    static {
        sessionFactoryObject = new Configuration().configure("hibernate/configuration/hibernate-cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactoryObject;
    }

}
