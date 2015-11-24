package com.adarsh.main;

import com.adarsh.domain.Employee;
import com.adarsh.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    public static void main(String[] args) {

        logger.info("Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee(101, "adarsh", "adarsh@kumar", "IT");
        session.save(employee);
        transaction.commit();

        Query query = session.createSQLQuery(
                "CALL GETEMPLOYEE(:empId)")
                .addEntity(Employee.class)
                .setParameter("empId", "1");

        List result = query.list();
        for (int i = 0; i < result.size(); i++) {
            Employee emp = (Employee) result.get(i);
            System.out.println(emp);
        }


        logger.info("method executed sucessfully ");
    }
}
