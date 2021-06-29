package com.adarsh.service;

import com.adarsh.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.adarsh.util.SessionFactoryUtil.getHibernateSession;

@Slf4j
public class PersonService {

    public static void insertPerson() {
        try {
            Session hibernateSession = getHibernateSession().openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            List<Person> personList = getPersonObject();
            for (int i = 0; i < personList.size(); i++) {
                Person person = (Person) personList.get(i);
                hibernateSession.saveOrUpdate(person);
            }
            hibernateTransaction.commit();
            hibernateSession.close();
        } catch (Exception excpetionObject) {
            log.error(excpetionObject.getMessage());
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
            }
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
        }
        return personList;
    }

    public static void displayPersonByQueryList() {
        try {
            Session sessionObject = getHibernateSession().openSession();
            Query hqlQueryObject = sessionObject.createQuery("SELECT pO.firstName ,pO.lastName FROM Person as pO");
            List personObjectList = hqlQueryObject.list();

            for (int i = 0; i < personObjectList.size(); i++) {
                Object[] personObject = (Object[]) personObjectList.get(i);
                for (int j = 0; j < personObject.length; j++) {
                    log.info("{}", personObject[j]);
                }
            }
            sessionObject.close();
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
        }
    }

    public static void displayPersonByQueryIterate() {
        try {
            Session sessionObject = getHibernateSession().openSession();
            Query hqlQueryObject = sessionObject.createQuery("SELECT pO.firstName,pO.dateOfBirth FROM Person as pO WHERE pO.lastName like 's%' ");
            Iterator personIteratorObject = hqlQueryObject.iterate();
            while (personIteratorObject.hasNext()) {
                Object[] personObject = (Object[]) personIteratorObject.next();
                for (int j = 0; j < personObject.length; j++) {
                    log.info("{}", personObject[j]);
                }
            }
            sessionObject.close();
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
        }
    }

    public static java.sql.Date getDob(String dateOfBirth) {
        java.sql.Date dataOfBirthObject = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date utilDate = formatter.parse(dateOfBirth);
            dataOfBirthObject = new java.sql.Date(utilDate.getTime());
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
        }
        return dataOfBirthObject;
    }
}
