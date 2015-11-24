package com.adarsh.hibernate.main;

import com.adarsh.hibernate.bean.Department;
import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.factory.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/11/12
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Application {

    public static void main(String[] args) {

        Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject= sessionObject.beginTransaction();
        Department department=new Department(101,"It","India");
        sessionObject.save(department);
        Employee employee=new Employee(101,"adarsh","adarsh@kumar",department);
        sessionObject.save(employee);
        transactionObject.commit();


    }

}
