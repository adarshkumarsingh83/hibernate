package com.adarsh.hibernate.service;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/25/12
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeService {

    public void listEmployees();
    public void deleteEmployee(Integer EmployeeID);
    public void updateEmployee(Integer EmployeeID, int salary);
    public Integer addEmployee(String fname, String lname, int salary);

}
