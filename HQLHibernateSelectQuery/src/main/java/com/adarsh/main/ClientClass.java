package com.adarsh.main;

import java.util.*;
import java.text.SimpleDateFormat;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import com.adarsh.bean.*;

public class ClientClass {

		public static void main(String[] args) {
	        try{
	             insertPerson();
	             displayPersonByQueryList();
	            displayPersonByQueryIterate();
	             
	        }catch(Exception exceptionObject){
	        	System.out.println(exceptionObject.getMessage());
	        }
	   }

		static SessionFactory sessionFactoryObject=null;
		public static SessionFactory getHibernateSession(){
		    if(sessionFactoryObject == null){
		    	sessionFactoryObject=new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		    }
			return sessionFactoryObject;
		}
		 
		public static void insertPerson(){
				try{	         
				         Session hibernateSession=getHibernateSession().openSession();
				         Transaction hibernateTransaction=hibernateSession.beginTransaction();
				          List<Person> personList=getPersonObject();
					              for(int i=0;i<personList.size();i++){
					            	    Person person=(Person)personList.get(i);
					            	    hibernateSession.saveOrUpdate(person);
					              }
				         hibernateTransaction.commit();
				        hibernateSession.close();
				}catch(Exception excpetionObject){
				         System.out.println(excpetionObject.getMessage());
				}
		}
		
		public static List<Person> getPersonObject(){		
			List <Person>personList=new ArrayList<Person>();
					try{
						 Person personObject =new Person();
				         String firstName[]={"adarsh","amit","abhishek","amritesh","ashok"};
				         String  personDob[]={"09/13/1983","01/04/1986","01/05/1986","02/25/1983","05/03/1984"};
									for(int i=0; i<=5;i++){
								        	 Person person=(Person)personObject.clone();
								        	  person.setPersonId(100+i);
								        	  person.setFirstName(firstName[i]);
								        	  person.setMiddleName("Kumar");
								        	  person.setLastName("Singh");
								        	  person.setDateOfBirth(getDob(personDob[i]));
								        	 personList.add(person);
								        	 person=null;
							         }		
					}catch(Exception exceptionObject){
						System.out.println(exceptionObject.getMessage());
					}
			return personList;
		}
		
		public static void displayPersonByQueryList(){
			try{
					Session sessionObject=getHibernateSession().openSession();
					Query hqlQueryObject=sessionObject.createQuery("SELECT pO FROM Person as pO");
					List personObjectList=hqlQueryObject.list();
					Person personObject=null;
				        	for(int i=0;i<personObjectList.size();i++){
				        		  personObject=(Person)personObjectList.get(i);
				        		  System.out.println(personObject.toString());
				        	}     	
		        	sessionObject.close();
			}catch(Exception exceptionObject){
				System.out.println(exceptionObject.getMessage());
			}	
		}
		 public static void displayPersonByQueryIterate(){
				try{
					Session sessionObject=getHibernateSession().openSession();
					Query hqlQueryObject=sessionObject.createQuery("FROM Person as pO");
					Iterator personIteratorObject=hqlQueryObject.iterate();
					Person personObject=null;
				        while(personIteratorObject.hasNext()){
				        		  personObject=(Person)personIteratorObject.next();
				        		  System.out.println(personObject);
				        	}     	
		        	sessionObject.close();
			}catch(Exception exceptionObject){
				System.out.println(exceptionObject.getMessage());
			}	
		 }
		 
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
