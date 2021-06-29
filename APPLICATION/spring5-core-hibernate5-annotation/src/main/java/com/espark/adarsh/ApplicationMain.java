package com.espark.adarsh;

import com.espark.adarsh.configuration.ApplicationConfiguration;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) throws ApplicationException {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        /*
        AnnotationConfigApplicationContext applicationContext = new
                AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationConfiguration.class);
        applicationContext.refresh();
        */


        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

        employeeService.showMessage();

        employeeService.getEmployees().stream().forEach(employee -> {

            System.out.println("Employee Id " + employee.getId());
            System.out.println("Employee Name " + employee.getName());
            System.out.println("Employee Email " + employee.getEmail());
        });
    }
}
