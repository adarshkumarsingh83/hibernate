package com.adarsh.main;

import com.adarsh.domain.Stock;
import com.adarsh.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationMain {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {
        logger.info("Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Stock stock = new Stock("111","adarsh");
        session.save(stock);
        transaction.commit();
        logger.info("execution completed");
    }
}
