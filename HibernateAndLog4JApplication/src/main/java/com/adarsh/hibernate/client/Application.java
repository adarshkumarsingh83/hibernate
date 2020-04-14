package com.adarsh.hibernate.client;

import java.util.Date;

import com.adarsh.hibernate.factory.MySessionFactory;
import com.adarsh.hibernate.user.DBUser;
import org.hibernate.Session;

public class Application {

    public static void main(String[] args) {

        Session session = MySessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        DBUser user = new DBUser();
        user.setUserId(100);
        user.setUsername("Adarsh kumar singh");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());
        session.save(user);

        session.getTransaction().commit();
    }
}
