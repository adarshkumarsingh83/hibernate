package com.adarsh.bean;


import java.io.Serializable;
import java.util.*;

import static java.lang.System.out;


public class Person implements Cloneable  ,Serializable{
	
	 private static final long serialVersionUID = 1L;
	   private Integer personId;
       private String firstName;
       private String middleName;
       private String lastName;
       private Date  dateOfBirth;
		
       public Person(){
    	   out.println("Person class constructor");
       }
       
       public Integer getPersonId(){
    	   return this.personId;
       }
       
       public void setPersonId(Integer personId){
    	   this.personId=personId;
       }
       
       public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
       public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

	public String toString(){
    	   return this.personId+" :  "+ this.firstName+" : "+this.middleName+" : "+this.lastName+" : "+this.dateOfBirth;
       }
       
       public Object clone(){
    	   Person personObject=null;
    	   try{
    		   personObject=(Person)super.clone();
    	   }catch(Exception exceptionObject){
    		   System.out.println(exceptionObject.getMessage());
    	   }
    	   return personObject;
       }
}
