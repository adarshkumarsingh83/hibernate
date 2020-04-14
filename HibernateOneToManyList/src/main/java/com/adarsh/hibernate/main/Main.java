package com.adarsh.hibernate.main;

import java.util.ArrayList;

import com.adarsh.hibernate.bean.Department;
import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.factory.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {


    public static void main(String[] args) {

        SessionFactory sf = MySessionFactory.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);

        Employee emp1 = new Employee("Adarsh", "Kumar", "111");
        Employee emp2 = new Employee("Amit", "Amit", "222");

        department.setEmployees(new ArrayList<Employee>());
        department.getEmployees().add(emp1);
        department.getEmployees().add(emp2);

        session.save(department);

        session.getTransaction().commit();
        session.close();
    }
}
