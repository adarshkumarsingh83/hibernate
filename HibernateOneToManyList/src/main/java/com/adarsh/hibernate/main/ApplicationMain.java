package com.adarsh.hibernate.main;

import java.util.Date;
import java.util.ArrayList;

import com.adarsh.hibernate.bean.Department;
import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.factory.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ApplicationMain {


    public static void main(String[] args) {

        SessionFactory sf = MySessionFactory.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);

        Employee emp1 = new Employee("Adarsh", "Kumar", new Date(), "99999", department);
        Employee emp2 = new Employee("Amit", "Amit", new Date(), "88888", department);

        department.setEmployees(emp1);
        department.setEmployees(emp2);

        session.save(department);
        transaction.commit();
        session.close();
    }
}
