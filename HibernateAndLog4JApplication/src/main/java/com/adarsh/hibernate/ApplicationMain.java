package com.adarsh.hibernate;

import java.util.Date;

import com.adarsh.hibernate.factory.MySessionFactory;
import com.adarsh.hibernate.entity.DBUser;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {

        Session session = MySessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        DBUser user = new DBUser();
        user.setUserId(100);
        user.setUsername("Adarsh kumar singh");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());
        Integer id = (Integer) session.save(user);

        session.getTransaction().commit();
        session.close();
        session = MySessionFactory.getSessionFactory().openSession();
        user = session.load(DBUser.class, id);
        log.info("User {}", user);
        session.close();
    }
}
