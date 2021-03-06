package com.sourceN.main;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sourceN.bean.*;
import com.sourceN.factory.MySessionFactory;
import org.hibernate.cfg.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientClass {

   private static final Logger logger= LoggerFactory.getLogger("ClientClass.class");

	public static void main(String[] args)throws Exception{
		Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
		Transaction transactionObject= sessionObject.beginTransaction();
		List<Employee> empList=ClientClass.getEmployee();
		
		for(int i=0;i<empList.size();i++){
		  sessionObject.saveOrUpdate(((Employee)empList.get(i)));
		}
		
		transactionObject.commit();
		sessionObject.close();
	   ClientClass.displayEmployee();
	}
	
	public static List<Employee> getEmployee()throws Exception{
		Employee empObject=new Employee();
		List<Employee> empList=new ArrayList<Employee>();
		Integer empNumber[]={101,102,103,104,105};
		String empName[]={"adarsh","amit","abhishek","amritesh","ashok"};
		String empCity[]={"delhi","bangalore","pune","hyderabad","allahabad"};
		String dateOfBirth[]={"09/13/1983","01/04/1986","01/05/1986","02/25/1983","05/03/1984"};
		for(int i=0;i<5;i++){
			Employee emp=(Employee)empObject.clone();
			 emp.setEmpNumber(empNumber[i]);
			 emp.setEmpFirstName(empName[i]);
			 emp.setEmpMiddleName("Kumar");
			 emp.setEmpLastName("Singh");
			 emp.setEmpCity(empCity[i]);
			 emp.setDateOfBirth(getDob(dateOfBirth[i]));
			 empList.add(emp);
			 emp=null;
		}		
		return empList;
	}

	public static void displayEmployee(){
		Integer empNumber[]={101,102,103,104,105};
		try{
			Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
			for(int i=0;i<5;i++){
			  Employee emp=(Employee)sessionObject.get(Employee.class,empNumber[i]);
			  emp.displayEmployee();
			  emp=null;
			}
			sessionObject.close();
		}catch(Exception exceptionObject){
            logger.error(exceptionObject.getMessage());
		}
	}


	public static java.sql.Date getDob(String dateOfBirth){
		java.sql.Date dataOfBirthObject=null;
		try{
			
			 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		      Date utilDate = formatter.parse(dateOfBirth);
		      dataOfBirthObject=new java.sql.Date(utilDate.getTime());
		}catch(Exception exceptionObject){
            logger.error(exceptionObject.getMessage());
		}
		return dataOfBirthObject;
	}
}
