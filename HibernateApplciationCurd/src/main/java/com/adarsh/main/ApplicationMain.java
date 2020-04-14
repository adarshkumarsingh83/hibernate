package com.adarsh.main;


import com.adarsh.domain.Employee;
import com.adarsh.manager.EmployeeManager;
import com.adarsh.manager.impl.EmployeeManagerImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/6/12 9:29 AM#$
 */

public class ApplicationMain {

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManagerImpl();

        /*insertion in the db*/
        Employee employee1 = new Employee("Adarsh", "Adarsh@kumar", "IT", new Date());
        employeeManager.insertEmployee(employee1);

        /*update in the db*/
        Employee employee2 = new Employee(1,"Adarsh Kumar", "Adarsh@kumar.singh", "IT", new Date());
        employeeManager.updateEmployee(employee2);



        /*complete selection from db*/
        Employee employee = employeeManager.selectEmployee(1);
        System.out.println(employee);


        /* Deletion of the employee */
        Employee employee5 = new Employee(1,"Adarsh Kumar", "Adarsh@kumar.singh", "IT", new Date());
        employeeManager.deleteEmployee(employee5);
    }
}
