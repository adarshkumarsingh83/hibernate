package com.adarsh.hibernate;

import com.adarsh.hibernate.service.EmployeeService;
import com.adarsh.hibernate.service.impl.EmployeeServiceImpl;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/25/12
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationMain {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl();

        /* Add few employee records in database */
        Integer empID1 = employeeService.addEmployee("Adarsh", "Singh", 1000);
        Integer empID2 = employeeService.addEmployee("Amit", "Singh", 5000);
        Integer empID3 = employeeService.addEmployee("Radha", "Singh", 10000);

        /* List down all the employees */
        employeeService.listEmployees();

        /* Update employee's records */
        employeeService.updateEmployee(empID1, 5000);

        /* Delete an employee from the database */
        employeeService.deleteEmployee(empID2);

        /* List down new list of the employees */
        employeeService.listEmployees();
    }
}
