package com.adarsh.hibernate.main;
 
import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.bean.Meeting;
import com.adarsh.hibernate.factory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
 
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction=session.beginTransaction();

        Meeting meeting1 = new Meeting("Quaterly Sales meeting");
        Meeting meeting2 = new Meeting("Weekly Status meeting");
        
        Employee employee1 = new Employee("Adarsh ", "Kumar ");
        Employee employee2 = new Employee("Amit ", "Kumar");

        employee1.setMeetings(meeting1);
        employee1.setMeetings(meeting2);
        employee2.setMeetings(meeting1);
        
        session.save(employee1);
        session.save(employee2);

        transaction.commit();
        session.close();
    }
}