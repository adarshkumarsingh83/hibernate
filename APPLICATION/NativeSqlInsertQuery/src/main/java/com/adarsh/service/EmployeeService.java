package com.adarsh.service;

import com.adarsh.entity.Employee;
import com.adarsh.factory.MySessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.DateType;
import org.hibernate.type.StringType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class EmployeeService {


    public static void insertEmployee() {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        SQLQuery sqlQuery = sessionObject.createSQLQuery("insert into employee(empNumber,firstName,middleName,lastName,city,dob) values(:p1,:p2,:p3,:p4,:p5,:p6)");
        sqlQuery.setInteger("p1", 107);
        sqlQuery.setString("p2", "sonu'");
        sqlQuery.setString("p3", "kumar'");
        sqlQuery.setString("p4", "singh'");
        sqlQuery.setString("p5", "'la");
        sqlQuery.setDate("p6", getDob("09/13/1983"));
        log.info(" " + sqlQuery.executeUpdate());
        transactionObject.commit();
        sessionObject.close();
    }

    public static List<Employee> getEmployee() throws Exception {
        Employee empObject = new Employee();
        List<Employee> empList = new ArrayList<Employee>();
        Integer empNumber[] = {101, 102, 103, 104, 105};
        String empName[] = {"adarsh", "amit", "abhishek", "amritesh", "ashok"};
        String empCity[] = {"delhi", "bangalore", "pune", "hyderabad", "allahabad"};
        String dateOfBirth[] = {"09/13/1983", "01/04/1986", "01/05/1986", "02/25/1983", "05/03/1984"};
        for (int i = 0; i < 5; i++) {
            Employee emp = (Employee) empObject.clone();
            emp.setEmpNumber(empNumber[i]);
            emp.setEmpFirstName(empName[i]);
            emp.setEmpMiddleName("Kumar");
            emp.setEmpLastName("Singh");
            emp.setEmpCity(empCity[i]);
            emp.setDateOfBirth(getDob(dateOfBirth[i]));
            empList.add(emp);
            emp = null;
        }
        return empList;
    }

    public static void displayEmployee() {
        try {
            Session sessionObject = MySessionFactory.getSessionFactory().openSession();
            SQLQuery sqlQueryObject = sessionObject.createSQLQuery("SELECT  firstName, dob FROM employee ");
            sqlQueryObject.addScalar("firstName", StringType.INSTANCE);
            sqlQueryObject.addScalar("dob", DateType.INSTANCE);
            List employeeList = sqlQueryObject.list();
            for (int i = 0; i < employeeList.size(); i++) {
                Object[] emp = (Object[]) employeeList.get(i);
                for (int j = 0; i < emp.length; j++) {
                    log.info("" + emp[j]);
                }
                emp = null;
            }
            sessionObject.close();
        } catch (Exception exceptionObject) {
            exceptionObject.getMessage();
        }
    }

    @SuppressWarnings("deprecation")
    public static java.sql.Date getDob(String dateOfBirth) {
        java.sql.Date dataOfBirthObject = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date utilDate = formatter.parse(dateOfBirth);
            dataOfBirthObject = new java.sql.Date(utilDate.getTime());
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
        }
        return dataOfBirthObject;
    }
}
