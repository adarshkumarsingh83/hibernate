package com.adarsh;

import com.adarsh.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        EmployeeService.insertEmployee();
        EmployeeService.displayEmployee();

    }


}
