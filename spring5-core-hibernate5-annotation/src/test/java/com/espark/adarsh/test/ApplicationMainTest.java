package com.espark.adarsh.test;

import com.espark.adarsh.configuration.ApplicationConfiguration;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class ApplicationMainTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testEmployeeService() throws ApplicationException {

        employeeService.getEmployees().stream().forEach(employee -> {

            System.out.println("Employee Id "+employee.getId());
            System.out.println("Employee Name "+employee.getName());
            System.out.println("Employee Email "+employee.getEmail());
        });
    }
}
