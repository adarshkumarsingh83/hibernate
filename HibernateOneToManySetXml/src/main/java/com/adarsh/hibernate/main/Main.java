package com.adarsh.hibernate.main;
 
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
 
        Employee emp1 = new Employee("Adarsh", "Kumar", "1212");
        Employee emp2 = new Employee("Amit ", "Kumar", "4343");
 
        emp1.setDepartment(department);
        emp2.setDepartment(department);
 
        session.save(emp1);
        session.save(emp2);
 
        session.getTransaction().commit();
        session.close();
    }
}