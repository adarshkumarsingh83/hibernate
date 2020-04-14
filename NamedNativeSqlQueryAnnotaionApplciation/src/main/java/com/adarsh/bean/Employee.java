package com.adarsh.bean;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

import static java.lang.System.out;


@NamedNativeQueries({

        @NamedNativeQuery(
                name = "empSelect",
                query = " Select * From Employee where empNumber = :empNumber ",
                resultClass = com.adarsh.bean.Employee.class
        )
        ,
        @NamedNativeQuery(
                name = "empSelectAll",
                query = " Select * From Employee ",
                resultClass = com.adarsh.bean.Employee.class
        )

})
@Entity
@Table(name = "Employee", catalog = "hibernate")
public class Employee implements Serializable, Cloneable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empNumber", unique = true, nullable = false, precision = 5, scale = 0)
    private Integer empNumber;

    @Column(name = "empFirstName", nullable = false, length = 20)
    private String empFirstName;

    @Column(name = "empMiddleName", nullable = false, length = 20)
    private String empMiddleName;

    @Column(name = "empLastName", nullable = false, length = 20)
    private String empLastName;

    @Column(name = "empCity", nullable = false, length = 20)
    private String empCity;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth", nullable = false, length = 7)
    private Date dateOfBirth;

    static {
        out.println("Static block of the employee");
    }

    public Employee() {
        out.println("Employee Constructor");
    }

    public Employee(Integer empNumber, String empFirstName, String empMiddleName, String empLastName, String empCity, Date dateOfBirth) {
        this.empNumber = empNumber;
        this.empFirstName = empFirstName;
        this.empMiddleName = empMiddleName;
        this.empLastName = empLastName;
        this.empCity = empCity;
        this.dateOfBirth = dateOfBirth;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Object clone() throws CloneNotSupportedException {
        /* out.println("Employee Object is Cloned ");*/
        Employee newEmpObject = (Employee) super.clone();
        return newEmpObject;
    }

    public String toString() {
        return this.empNumber + " " + this.empFirstName + " " + this.empMiddleName + " " + this.empLastName + " " + this.empCity;
    }

    public void displayEmployee() {
        out.println("\nEmployee Number :" + this.empNumber + "\nEmployee Name: " + this.empFirstName + " " + this.empMiddleName + " " + this.empLastName + " " + this.empCity + " " + this.dateOfBirth);
    }
}
