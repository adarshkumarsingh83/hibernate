package com.adarsh.factory;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Properties;

@Slf4j
public class SessionFactoryUtil {

    static SessionFactory sessionFactory;

    static {
        sessionFactory = createSessionFactory();
    }

    public static SessionFactory createSessionFactory() {
        Configuration hibernateConfigurationObject = null;
        try {
            Properties hibernateCfg = new Properties();
            hibernateCfg.load(new FileInputStream("src/main/resources/hibernate-cfg.properties"));
            hibernateConfigurationObject = new Configuration();
            hibernateConfigurationObject.setProperties(hibernateCfg);
            hibernateConfigurationObject.addFile("src/main/resources/person.hbm.xml");
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
            exceptionObject.printStackTrace();
        }
        return hibernateConfigurationObject.buildSessionFactory();
    }

    public static Session getHibernateSession() {
        return sessionFactory.openSession();
    }
}
