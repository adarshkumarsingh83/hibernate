package com.adarsh;

import java.util.*;
import com.adarsh.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.adarsh.sessionFactory.MySessionFactory;
import static com.adarsh.service.EmployeeService.*;

public class ApplicationMain {


    public static void main(String[] args) throws Exception {
        String empName[] = {"adarsh", "amit", "abhishek", "amritesh", "ashok", "alok"};
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        List<Employee> empList = getEmployee();
        for (int i = 0; i < empList.size(); i++) {
            sessionObject.saveOrUpdate(((Employee) empList.get(i)));
        }
        transactionObject.commit();
        sessionObject.close();

        for (int i = 0; i <= 5; i++) {
            updateEmployee((i + 1) + 100, empName[i]);
        }
        for (int i = 0; i <= 6; i += 2) {
            displayEmployee(i, 2);
        }
    }


}
