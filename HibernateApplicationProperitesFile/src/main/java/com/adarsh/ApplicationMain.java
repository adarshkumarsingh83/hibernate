package com.adarsh;

import com.adarsh.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import com.adarsh.persistence.HibernateUtil;
import org.hibernate.Transaction;

@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {

        log.info("Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee(101, "sonu", "adarsh@kumar", "account");
        session.save(employee);
        transaction.commit();
        log.info("method executed successfully ");
    }
}
