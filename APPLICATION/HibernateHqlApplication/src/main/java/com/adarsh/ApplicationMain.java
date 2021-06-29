package com.adarsh;


import com.adarsh.domain.Employee;
import com.adarsh.manager.EmployeeManager;
import com.adarsh.manager.impl.EmployeeManagerImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/6/12 9:29 AM#$
 */
@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManagerImpl();

        /*insertion in the db*/
        Employee employee1 = new Employee("Adarsh", "Adarsh@kumar", "IT", new Date());
        employeeManager.insertEmployee(employee1);

        /* update in the db*/
        Employee employee2 = new Employee("Adarsh Kumar", "Adarsh@kumar.singh", "IT", new Date());
        employeeManager.updateEmployee(employee2);

        /* partial selection from db*/
        Employee employee3 = new Employee(1);
        List<Object[]> list = employeeManager.selectEmployee(employee3);
        for (Object[] objectArray : list) {
            for (Object data : objectArray) {
                log.info(" {}", data);
            }
        }

        /* complete selection from db*/
        Employee employee = employeeManager.selectEmployee(1);
        log.info("{}", employee);

        /* all record selection from db */
        List<Employee> empList = employeeManager.selectAllEmployee();
        for (Employee emp : empList) {
            log.info("{} :=> ", emp);
        }

        /* Deletion of the employee */
        Employee employee5 = new Employee(1);
        employeeManager.deleteEmployee(employee5);
    }
}
