package com.espark.adarsh;

import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) throws ApplicationException {
        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext( "application-configuration.xml" );

        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

        employeeService.showMessage();
        
        employeeService.getEmployees().stream().forEach(employee -> {

            System.out.println("Employee Id "+employee.getId());
            System.out.println("Employee Name "+employee.getName());
            System.out.println("Employee Email "+employee.getEmail());
        });
    }
}
