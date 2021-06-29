package com.adarsh.manager.impl;

import com.adarsh.domain.Employee;
import com.adarsh.hibernate.HibernateUtil;
import com.adarsh.manager.EmployeeManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/6/12 9:35 AM#$
 */
public class EmployeeManagerImpl implements EmployeeManager {


    public Integer insertEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        return null;
    }


    public Integer updateEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        return 0;
    }


    public Integer deleteEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        return 0;
    }

    public Employee selectEmployee(Integer employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Employee) session.load(Employee.class, employee);
    }
}
