package com.adarsh.hibernate.main;

import com.adarsh.hibernate.bean.Department;
import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.factory.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;


public class ApplicationMain {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        SessionFactory sf = MySessionFactory.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction=session.beginTransaction();


        Department department = new Department();
        department.setDepartmentName("Sales");



        Employee emp1 = new Employee("Adarsh", "Kumar",new Date(), "999999",department);
        Employee emp2 = new Employee("Amit", "Kumar",new Date(), "888888",department);

        department.setEmployees(emp1);
        department.setEmployees(emp2);
        session.save(department);
        session.save(emp1);
        session.save(emp2);
        session.save(emp1);

        transaction.commit();
        session.close();
    }

}
