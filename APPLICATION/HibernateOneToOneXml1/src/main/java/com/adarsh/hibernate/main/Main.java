package com.adarsh.hibernate.main;

import java.sql.Date;
import java.util.List;

import com.adarsh.hibernate.bean.Employee;
import com.adarsh.hibernate.bean.EmployeeDetail;
import com.adarsh.hibernate.factory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction =session.beginTransaction();

		EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");
		
		Employee employee = new Employee("Adarsh ", "Kumar ", new Date(121212),
				"114-857-965",employeeDetail );
		employeeDetail.setEmployee(employee);
		
		
		session.save(employee);

		
		List<Employee> employees = session.createQuery("from Employee").list();
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstname() + " , "
					+ employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState());
		}

		transaction.commit();
		session.close();

	}
}
