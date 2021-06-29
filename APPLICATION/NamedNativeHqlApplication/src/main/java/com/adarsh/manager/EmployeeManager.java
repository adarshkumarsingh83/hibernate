package com.adarsh.manager;

import com.adarsh.bean.Employee;
import com.adarsh.factory.MySessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/13/12
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeManager {

    public void displayAllEmployee() {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        Query query = sessionObject.getNamedQuery("emp_select_all");
        List<Employee> employeeList = query.list();
        for (Employee employee : employeeList) {
            employee.displayEmployee();
        }
        transactionObject.commit();
    }

    public void displayEmployee(Integer empId) {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        Query query = sessionObject.getNamedQuery("emp_select");
        query.setParameter("empNo", empId);
        List<Employee> employeeList = query.list();
        for (Employee employee : employeeList) {
            employee.displayEmployee();
        }
        transactionObject.commit();
    }


    public void displayPartialEmployee() {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        Query query = sessionObject.getNamedQuery("emp_select_partial");
        List<Object[]> employeeList = query.list();
        for (Object[] employeeObject : employeeList) {
            System.out.println("Employee Nubmer " + employeeObject[0]);
            System.out.println("Employee FirstName " + employeeObject[1]);
            System.out.println("Employee City " + employeeObject[2]);
        }
        transactionObject.commit();
    }


    public void updateEmployee(String empCity, Integer empId) {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        Query query = sessionObject.getNamedQuery("update_employee");
        query.setParameter("empCity", empCity);
        query.setParameter("empNo", empId);
        query.executeUpdate();
        transactionObject.commit();
    }


    public void deleteEmployee(Integer empNo) {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        Query query = sessionObject.getNamedQuery("delete_employee");
        query.setParameter("empNo", empNo);
        query.executeUpdate();
        transactionObject.commit();
    }


    public void insertEmployee(Employee employee) {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        Query query = sessionObject.getNamedQuery("insert_employee");
        query.setParameter("empNo", employee.getEmpNumber());
        query.setParameter("empFirstName", employee.getEmpFirstName());
        query.setParameter("empMiddleName", employee.getEmpMiddleName());
        query.setParameter("empLastName", employee.getEmpLastName());
        query.setParameter("empCity", employee.getEmpCity());
        query.setParameter("empDob", employee.getDateOfBirth());
        query.executeUpdate();
        transactionObject.commit();
    }
}
