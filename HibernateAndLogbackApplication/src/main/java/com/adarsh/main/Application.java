package com.adarsh.main;

import com.adarsh.factory.MySessionFactory;
import com.adarsh.user.DBUser;
import org.hibernate.Session;

import java.util.Date;

public class Application {
    public static void main(String[] args) {


        Session session = MySessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        DBUser user = new DBUser();

        user.setUserId(100);
        user.setUsername("Hibernate101");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();
    }
}
