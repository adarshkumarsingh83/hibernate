package com.adarsh.hibernate.main;

import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.bean.Project;
import com.adarsh.hibernate.factory.MySessionFactory;
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
        employee.setProjects(project);
        sessionObject.save(employee);
        transactionObject.commit();


    }

}
