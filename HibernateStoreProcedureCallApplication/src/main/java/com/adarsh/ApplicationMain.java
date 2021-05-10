package com.adarsh;

import com.adarsh.domain.Employee;
import com.adarsh.persistence.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Slf4j
public class ApplicationMain {


    public static void main(String[] args) {

        log.info("Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee(101, "adarsh", "IT", "adarsh@"+System.nanoTime());
        session.save(employee);
        transaction.commit();

        Query query = session.createSQLQuery(
                "CALL GETEMPLOYEE(:empId)")
                .addEntity(Employee.class)
                .setParameter("empId", "1");

        List result = query.list();
        for (int i = 0; i < result.size(); i++) {
            Employee emp = (Employee) result.get(i);
            log.info("employee {}", emp);
        }
        log.info("method executed successfully ");
    }
}
