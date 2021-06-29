package com.adarsh.service;

import com.adarsh.entity.Employee;
import com.adarsh.sessionFactory.MySessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class EmployeeService {

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

    public static void updateEmployee(Integer empNumber, String empMail) {
        try {
            Session sessionObject = MySessionFactory.getSessionFactory().openSession();
            Transaction transactionObject = sessionObject.beginTransaction();
            Query hqlQueryObject = sessionObject.createQuery("UPDATE Employee  SET  empMail = ? WHERE empNumber = :eno");
            hqlQueryObject.setString(0, empMail);
            hqlQueryObject.setInteger("eno", empNumber);
            System.out.println(hqlQueryObject.executeUpdate());
            transactionObject.commit();
            sessionObject.close();
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
        }
    }

    public static void displayEmployee() {
        try {
            Session sessionObject = MySessionFactory.getSessionFactory().openSession();
            Query hqlQueryObject = sessionObject.createQuery("SELECT empBean FROM Employee AS empBean WHERE empBean.empNumber  >= :eno ");
            hqlQueryObject.setInteger("eno", 101);
            List empList = hqlQueryObject.list();
            for (int i = 0; i < empList.size(); i++) {
                Employee empObject = (Employee) empList.get(i);
                empObject.displayEmployee();
            }
            sessionObject.close();
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
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
