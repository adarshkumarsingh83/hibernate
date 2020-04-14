package com.adarsh.hibernate.bean;

import javax.persistence.*;
import java.io.Serializable;

import static java.lang.System.out;
import static javax.persistence.GenerationType.IDENTITY;

public class Employee implements Serializable, Cloneable {


    private static final long serialVersionUID = 1L;

    private Integer empId;
    private String empName;
    private String empEmail;
    private Address address;


    static {
        out.println("Static block of the employee");
    }

    public Employee() {
        out.println("Employee Constructor");
    }

    public Employee(Integer empId, String empName, String empEmail, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
