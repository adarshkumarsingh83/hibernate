package com.adarsh.main;

import java.util.*;
import com.adarsh.bean.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.text.SimpleDateFormat;
import com.adarsh.sessionFactory.MySessionFactory;

public class ClientClass {
     
	 
	public static void main(String[] args)throws Exception{
		String empName[]={"adarsh","amit","abhishek","amritesh","ashok","alok"};
		Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
		Transaction transactionObject= sessionObject.beginTransaction();
		List<Employee> empList=ClientClass.getEmployee();
				for(int i=0;i<empList.size();i++){
				      sessionObject.saveOrUpdate(((Employee)empList.get(i)));
				}
				transactionObject.commit();
				sessionObject.close();
			
				for(int i=0;i<=5 ;i++){
					updateEmployee((i+1)+100, empName[i]);
				}
				for(int i=0;i<=6 ;i+=2){
		              ClientClass.displayEmployee(i,2);
				}
	}
	
	public static List<Employee> getEmployee()throws Exception{
		Employee empObject=new Employee();
		List<Employee> empList=new ArrayList<Employee>();
		Integer empNumber[]={101,102,103,104,105,106};
		String empName[]={"adarsh","amit","abhishek","amritesh","ashok","alok"};
		String empCity[]={"delhi","bangalore","pune","hyderabad","allahabad","chenni"};
		String dateOfBirth[]={"09/13/1983","01/04/1986","01/05/1986","02/25/1983","05/03/1984","07/06/1985"};
		for(int i=0;i<=5;i++){
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

	public static void updateEmployee(Integer empNumber,String empMail){
					try{
								Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
								Transaction transactionObject=sessionObject.beginTransaction();
					            Query hqlQueryObject=sessionObject.createQuery("UPDATE Employee  SET  empMail = ? WHERE empNumber = :eno");
					              hqlQueryObject.setString(0,empMail);
					              hqlQueryObject.setInteger("eno",empNumber);
					              System.out.println(hqlQueryObject.executeUpdate());
					              transactionObject.commit();
								 sessionObject.close();
					}catch(Exception exceptionObject){
					        	exceptionObject.getMessage();
				}
	}
	
	public static void displayEmployee(Integer startPoint,Integer numberOfEmployee){
		try{
			Session  sessionObject= MySessionFactory.getSessionFactory().openSession();
            Query hqlQueryObject=sessionObject.createQuery("SELECT empBean FROM Employee AS empBean ");
                 hqlQueryObject.setFirstResult(startPoint);
                 hqlQueryObject.setMaxResults(numberOfEmployee);
                 List empList=hqlQueryObject.list();
                   for(int i=0;i<empList.size();i++){
                	   Employee empObject=(Employee)empList.get(i);
                	              empObject.displayEmployee();
                   }
			sessionObject.close();
			Thread.currentThread().sleep(5000);
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
