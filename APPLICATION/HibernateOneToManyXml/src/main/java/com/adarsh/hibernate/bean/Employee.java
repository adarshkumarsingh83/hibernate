package com.adarsh.hibernate.bean;

import java.io.Serializable;
import java.sql.Date;

import static java.lang.System.out;

public class Employee implements Serializable, Cloneable {


    private static final long serialVersionUID = 1L;
    private Integer empId;
    private String empName;
    private String empEmail;
    private Department department;


    static {
        out.println("Static block of the employee");
    }

    public Employee() {
        out.println("Employee Constructor");
    }

    public Employee(Integer empId, String empName, String empEmail, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
