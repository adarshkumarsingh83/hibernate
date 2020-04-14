package com.adarsh.main;

import com.adarsh.bean.*;
import com.adarsh.manager.EmployeeManager;

public class ClientClass {

    private static final  EmployeeManager employeeManager = new EmployeeManager();

    public static void main(String[] args) {
        /*All functionality is working */
        /*Employee employee = new Employee(105, "radha", "singh", "thakur", "city", new java.sql.Date(new java.util.Date().getTime()));
        employeeManager.insertEmployee(employee);*/
        employeeManager.displayEmployee(101);
        employeeManager.displayAllEmployee();
    }
}
