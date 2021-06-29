package com.adarsh.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import static java.lang.System.out;

public class Employee extends Person
        implements Serializable {


    private static final long serialVersionUID = 1L;
    private Integer empNumber;
    private String deptName;
    private String empCity;


    static {
        out.println("Static block of the employee");
    }

    public Employee(String empName,Date dob, String deptName, String empCity) {
        super(empName,dob);
        this.deptName = deptName;
        this.empCity = empCity;
        out.println("Employee Constructor");
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }


    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }


    public Object clone() throws CloneNotSupportedException {
        /* out.println("Employee Object is Cloned ");*/
        Employee newEmpObject = (Employee) super.clone();
        return newEmpObject;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void displayEmployee() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " Employee{" +
                "empNumber=" + empNumber +
                ", deptName='" + deptName + '\'' +
                ", empCity='" + empCity + '\'' +
                '}';
    }
}
