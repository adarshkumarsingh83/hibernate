package com.adarsh.hibernate.main;




import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.bean.Owner;
import com.adarsh.hibernate.bean.Person;
import com.adarsh.hibernate.factory.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class ClientClass {

    public static void main(String[] args) throws Exception {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();

        Person person = new Person("Adarsh kumar",new Date());
        sessionObject.save(person);

        Employee employee = new Employee("Amit kumar ",new Date(), "it", "bangalore");
        sessionObject.save(employee);

        Owner owner= new Owner("Radha",new Date(),"71%");
        sessionObject.save(owner);

        transactionObject.commit();
        sessionObject.close();
    }

}

