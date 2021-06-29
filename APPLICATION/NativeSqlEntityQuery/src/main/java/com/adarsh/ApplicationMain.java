package com.adarsh;

import static com.adarsh.service.EmployeeService.displayEmployee;
import static com.adarsh.service.EmployeeService.insertEmployee;

public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        insertEmployee();
        displayEmployee();
    }


}
