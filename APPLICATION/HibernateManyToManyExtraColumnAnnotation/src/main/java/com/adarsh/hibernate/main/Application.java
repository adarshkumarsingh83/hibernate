package com.adarsh.hibernate.main;

import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.bean.EmployeeProject;
import com.adarsh.hibernate.bean.Project;
import com.adarsh.hibernate.factory.MySessionFactory;
import com.mkyong.stock.Category;
import com.mkyong.stock.Stock;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/11/12
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Application {

    public static void main(String[] args) {

        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();

        Employee employee = new Employee("adarsh", "adarsh@kumar");

        Project project = new Project("dell acs", "dell");
        sessionObject.save(project);

        EmployeeProject employeeProject=new EmployeeProject();
        employeeProject.setEmployee(employee);
        employeeProject.setProject(project);
        employeeProject.setCreatedBy("adarsh kumar");
        employeeProject.setCreatedDate(new java.util.Date());


        employee.getEmployeeProject().add(employeeProject);
        sessionObject.save(employee);


        transactionObject.commit();


    }

}
