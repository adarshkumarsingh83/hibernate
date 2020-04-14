package com.adarsh;

import java.util.Date;
import org.hibernate.Session;
import com.adarsh.util.HibernateUtil;
import com.adarsh.user.DBUser;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(100);
		user.setUsername("adarsh kumar singh");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
		
		System.out.println("Done");
	}
}
