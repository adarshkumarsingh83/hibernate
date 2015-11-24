package com.adarsh.main;

import java.util.*;
import java.text.SimpleDateFormat;

import com.adarsh.factory.MySessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import com.adarsh.bean.*;

public class ClientClass {

    public static void main(String[] args) {
        try {
            ClientClass.insertPerson();
            displayPerson(new Integer[]{100, 101, 102, 103, 104});

        } catch (Exception exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
    }

    public static void insertPerson() {
        try {
            Session hibernateSession = MySessionFactory.getSessionFactory().openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            List<Person> personList = getPersonObject();
            for (int i = 0; i < personList.size(); i++) {
                Person person = (Person) personList.get(i);
                hibernateSession.saveOrUpdate(person);
            }
            hibernateTransaction.commit();
            hibernateSession.close();
        } catch (Exception excpetionObject) {
            System.out.println(excpetionObject.getMessage());
        }
    }

    public static List<Person> getPersonObject() {
        List<Person> personList = new ArrayList<Person>();
        try {
            Person personObject = new Person();
            String firstName[] = {"adarsh", "amit", "abhishek", "amritesh", "ashok"};
            String personDob[] = {"09/13/1983", "01/04/1986", "01/05/1986", "02/25/1983", "05/03/1984"};
            for (int i = 0; i <= 5; i++) {
                Person person = (Person) personObject.clone();
                person.setPersonId(100 + i);
                person.setFirstName(firstName[i]);
                person.setMiddleName("Kumar");
                person.setLastName("Singh");
                person.setDateOfBirth(getDob(personDob[i]));
                personList.add(person);
                person = null;
                System.out.println("===> " + i);
            }
        } catch (Exception exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
        return personList;
    }

    public static void displayPerson(Integer[] personId) {
        try {
            Session sessionObject = MySessionFactory.getSessionFactory().openSession();
            Person personObject = null;
            for (Integer personIdObject : personId) {
                personObject = (Person) sessionObject.load(Person.class, personIdObject);
                System.out.println(personObject);
            }
            sessionObject.close();
        } catch (Exception exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
    }

    public static java.sql.Date getDob(String dateOfBirth) {
        java.sql.Date dataOfBirthObject = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date utilDate = formatter.parse(dateOfBirth);
            dataOfBirthObject = new java.sql.Date(utilDate.getTime());
        } catch (Exception exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
        return dataOfBirthObject;
    }
}
