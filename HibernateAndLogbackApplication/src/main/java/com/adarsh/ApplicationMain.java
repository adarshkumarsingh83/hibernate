package com.adarsh;

import com.adarsh.factory.MySessionFactory;
import com.adarsh.entity.DBUser;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.Date;

@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {
        Session session = MySessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        DBUser user = new DBUser();

        user.setUserId(100);
        user.setUsername("Hibernate101");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());

        Integer id = (Integer) session.save(user);
        session.getTransaction().commit();
        session.close();
        session = MySessionFactory.getSessionFactory().openSession();
        user = session.get(DBUser.class, id);
        log.info("User {}", user);
        session.close();
    }
}
