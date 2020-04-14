package com.adarsh.hibernate.service.impl;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.factory.MySessionFactory;
import com.adarsh.hibernate.interceptor.MyInterceptor;
import com.adarsh.hibernate.service.EmployeeService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/25/12
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeServiceImpl implements EmployeeService{

    private static SessionFactory factory;

    public EmployeeServiceImpl(){
        factory=MySessionFactory.getSessionFactory();
    }



    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession(new MyInterceptor());
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    /* Method to  READ all the employees */
    public void listEmployees() {
        Session session = factory.openSession(new MyInterceptor());
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator =
                         employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary) {
        Session session = factory.openSession(new MyInterceptor());
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee =
                    (Employee) session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession(new MyInterceptor());
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee =
                    (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
