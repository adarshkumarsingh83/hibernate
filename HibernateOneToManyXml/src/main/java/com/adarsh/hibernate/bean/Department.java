package com.adarsh.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/11/12
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Department {

    private Integer deptId;
    private String deptName;
    private String deptLocation;
    private Set<Employee> employees = new HashSet<Employee>();

    public Department() {
    }

    public Department(Integer deptId, String deptName, String deptLocation ) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLocation = deptLocation;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLocation() {
        return deptLocation;
    }

    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employee) {
        this.employees.add(employee);
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
