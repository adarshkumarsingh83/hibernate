package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.exception.EmpployeeAlreadyExisitException;
import com.espark.adarsh.exception.EmpployeeNotFoundException;
import com.espark.adarsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Value("${application.message}")
    private String message;

    @Autowired
    EmployeeRepository employeeRepository;

    public void showMessage() {
        System.out.println("Message " + this.message);
    }

    public Employee saveEmployee(Employee employee) throws ApplicationException {
        return this.employeeRepository.saveEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) throws ApplicationException {
        return this.employeeRepository.updateEmployee(employee);
    }

    public Employee getEmployee(Integer employeeId) throws ApplicationException {
        return this.employeeRepository.getEmployee(employeeId);
    }

    public Employee deleteEmployee(Integer employeeId) throws ApplicationException{
        return this.employeeRepository.deleteEmployee(employeeId);
    }

    public List<Employee> getEmployees() throws ApplicationException {
        return this.employeeRepository.getEmployees();
    }
}
