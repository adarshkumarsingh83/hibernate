package com.adarsh.hibernate.main;

import com.adarsh.hibernate.bean.Address;
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

        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        Address address = new Address("BTM ", "Delhi", "India", 5000L);
        Employee employee = new Employee(101,"Adarsh ", "Adarsh@kumar", address);
        sessionObject.save(employee);
        transactionObject.commit();


    }

}
