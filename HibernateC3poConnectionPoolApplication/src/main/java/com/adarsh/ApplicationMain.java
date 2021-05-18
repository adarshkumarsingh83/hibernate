package com.adarsh;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import com.adarsh.util.HibernateUtil;
import com.adarsh.user.DBUser;

@Slf4j
public class ApplicationMain {
    public static void main(String[] args) {
        log.info("Maven + Hibernate Annotation + Oracle");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        DBUser user = new DBUser();

        user.setUserId(100);
        user.setUsername("adarsh kumar singh");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        DBUser load = session.get(DBUser.class, 100);
        log.info("{}", load);
        session.close();
        log.info("Done");
    }
}
