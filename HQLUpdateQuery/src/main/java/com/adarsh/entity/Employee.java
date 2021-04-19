package com.adarsh.entity;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.sql.Date;

import static java.lang.System.out;

@Slf4j
public class Employee implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer empNumber;
    private String empFirstName;
    private String empMiddleName;
    private String empLastName;
    private String empCity;
    private String empMail;
    private Date dateOfBirth;

    static {
        log.info("Static block of the employee");
    }

    public Employee() {
        log.info("Employee Constructor");
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpMiddleName() {
        return empMiddleName;
    }

    public void setEmpMiddleName(String empMiddleName) {
        this.empMiddleName = empMiddleName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public String getEmpMail() {
        return this.empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Object clone() throws CloneNotSupportedException {
        /* log.info("Employee Object is Cloned ");*/
        Employee newEmpObject = (Employee) super.clone();
        return newEmpObject;
    }

    public String toString() {
        return this.empNumber + " " + this.empFirstName + " " + this.empMiddleName + " " + this.empLastName + " " + this.empCity;
    }

    public void displayEmployee() {
        log.info("\nEmployee Number :" + this.empNumber + "\nEmployee Name: " + this.empFirstName + " " + this.empMiddleName + " " + this.empLastName + " " + this.empCity + " " + this.dateOfBirth);
    }
}