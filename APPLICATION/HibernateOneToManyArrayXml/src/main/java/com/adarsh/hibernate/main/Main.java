package com.adarsh.hibernate.main;

import com.adarsh.hibernate.bean.Department;
import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.factory.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        SessionFactory sf = MySessionFactory.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);

        Employee emp1 = new Employee("Adarsh", "Kumar", "111");
        Employee emp2 = new Employee("Amit", "Kumar", "222");

        department.setEmployees(new Employee[]{emp1, emp2});

        session.save(department);

        session.getTransaction().commit();
        session.close();
    }
}
