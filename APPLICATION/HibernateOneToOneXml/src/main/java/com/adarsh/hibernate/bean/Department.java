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
    private Employee employee;

    public Department() {
    }

    public Department(String deptName, String deptLocation ) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
