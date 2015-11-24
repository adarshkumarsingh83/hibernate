package com.adarsh.main;

import com.adarsh.domain.Employee;
import com.adarsh.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    public static void main( String[] args ){

        logger.info("Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Employee employee = new Employee(101,"adarsh","adarsh@kumar","IT");
        session.save(employee);
        transaction.commit();
        logger.info("method executed sucessfully ");
    }
}
