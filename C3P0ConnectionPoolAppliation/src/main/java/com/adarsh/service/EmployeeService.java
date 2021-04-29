package com.adarsh.service;

import com.adarsh.entity.Employee;
import com.adarsh.factory.MySessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class EmployeeService {

    public static void insertEmployee() throws Exception {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        List<Employee> empList = EmployeeService.getEmployee();

        for (int i = 0; i < empList.size(); i++) {
            sessionObject.saveOrUpdate(empList.get(i));
        }
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
        Integer empNumber[] = {101, 102, 103, 104, 105};
        try {
            Session sessionObject = MySessionFactory.getSessionFactory().openSession();
            for (int i = 0; i < 5; i++) {
                Employee emp = sessionObject.get(Employee.class, empNumber[i]);
                emp.displayEmployee();
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
