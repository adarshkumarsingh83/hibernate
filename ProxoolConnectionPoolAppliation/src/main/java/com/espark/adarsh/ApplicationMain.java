package com.espark.adarsh;

import com.espark.adarsh.service.EmployeeService;

public class ApplicationMain {


    public static void main(String[] args) throws Exception {
        EmployeeService.insertEmployee();
        EmployeeService.displayEmployee();
    }


}
