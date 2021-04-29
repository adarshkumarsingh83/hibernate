package com.adarsh;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import com.adarsh.util.HibernateUtil;
import com.adarsh.entity.User;
import org.hibernate.Transaction;

@Slf4j
public class ApplicationMain {
    public static void main(String[] args) {
        Integer id = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setUserId(100);
        user.setUsername(System.getProperty("user.name"));
        user.setCreatedBy(System.getProperty("user.name"));
        user.setCreatedDate(new Date());
        id = (Integer) session.save(user);
        transaction.commit();
        session.close();
        log.info("Done {}", id);
        session = HibernateUtil.getSessionFactory().openSession();
        user = session.get(User.class, id);
        log.info(user.toString());
        session.close();

    }
}
