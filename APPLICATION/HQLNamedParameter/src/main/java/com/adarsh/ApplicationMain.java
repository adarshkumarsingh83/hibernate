package com.adarsh;

import java.util.*;

import com.adarsh.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adarsh.sessionFactory.MySessionFactory;

import static com.adarsh.service.EmployeeService.*;

@Slf4j
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        Session sessionObject = MySessionFactory.getSessionFactory().openSession();
        Transaction transactionObject = sessionObject.beginTransaction();
        List<Employee> empList = getEmployee();
        for (int i = 0; i < empList.size(); i++) {
            sessionObject.saveOrUpdate(((Employee) empList.get(i)));
        }
        transactionObject.commit();
        sessionObject.close();
        displayEmployee();
    }
}
