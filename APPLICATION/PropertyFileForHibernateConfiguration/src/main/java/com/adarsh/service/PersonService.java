package com.adarsh.service;

import com.adarsh.entity.Person;
import com.adarsh.factory.SessionFactoryUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class PersonService {

    public static void insertPerson() {
        try {
            Session hibernateSession = SessionFactoryUtil.getHibernateSession();
            List<Person> personList = getPersonObject();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                hibernateSession.save(person);
            }
            hibernateTransaction.commit();
            hibernateSession.close();
        } catch (Exception exception) {
            log.error(exception.getMessage());
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

    public static void displayPerson(Integer[] personId) {
        try {
            Session sessionObject = SessionFactoryUtil.getHibernateSession();
            Person personObject = null;
            for (Integer personIdObject : personId) {
                personObject = sessionObject.load(Person.class, personIdObject);
                log.info(personObject.toString());
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
