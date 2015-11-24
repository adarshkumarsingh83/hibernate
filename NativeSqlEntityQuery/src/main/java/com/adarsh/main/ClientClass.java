package com.adarsh.main;


import java.util.*;

import com.adarsh.bean.*;
import com.adarsh.factory.*;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.text.SimpleDateFormat;

public class ClientClass {

					public static void main(String[] args)throws Exception{
						insertEmployee();
						displayEmployee();
					}
					
					public static void insertEmployee()throws Exception{
							Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
							Transaction transactionObject= sessionObject.beginTransaction();
							List<Employee> empList=getEmployee();
										for(int i=0;i<empList.size();i++){
										       sessionObject.saveOrUpdate(((Employee)empList.get(i)));
										}		
							transactionObject.commit();
							sessionObject.close();
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
								try{
										Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
										 SQLQuery sqlQueryObject=sessionObject.createSQLQuery("SELECT {E.*} FROM Employee E");
										 sqlQueryObject.addEntity("E",Employee.class);
										 List employeeList =sqlQueryObject.list();
													for(int i=0;i<employeeList.size();i++){
													       Employee emp=(Employee)employeeList.get(i);
													       emp.displayEmployee();
													       emp=null;
													}
									sessionObject.close();
								}catch(Exception exceptionObject){
									exceptionObject.getMessage();
								}
					}
					
					@SuppressWarnings("deprecation")
					public static java.sql.Date getDob(String dateOfBirth){
						java.sql.Date dataOfBirthObject=null;
								try{		
			    						 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		    						      Date utilDate = formatter.parse(dateOfBirth);
	    							      dataOfBirthObject=new java.sql.Date(utilDate.getTime());
								}catch(Exception exceptionObject){
    									System.out.println(exceptionObject.getMessage());
								}
						return dataOfBirthObject;
					}
}
