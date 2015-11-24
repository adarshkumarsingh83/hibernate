package com.adarsh.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/6/12 9:29 AM#$
 */
@Entity
@Table(name = "Employee")
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID", unique = true, nullable = false, precision = 5, scale = 0)
    private int empId;

    @Column(name = "EMP_NAME", nullable = false, length = 20)
    private String empName;

    @Column(name = "EMP_EMAIL", unique = true, nullable = false, length = 20)
    private String empEmail;

    @Column(name = "EMP_DEPT", nullable = false, length = 20)
    private String empDept;

    @Temporal(TemporalType.DATE)
    @Column(name = "EMP_DOB", nullable = false, length = 9)
    private Date empDob;

    public Employee() {
    }

    public Employee(int empId) {
        this.empId = empId;
    }

    public Employee(String empName, String empEmail, String empDept, Date empDob) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.empDept = empDept;
        this.empDob = empDob;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
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

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public Date getEmpDob() {
        return empDob;
    }

    public void setEmpDob(Date empDob) {
        this.empDob = empDob;
    }

    @Override
    public String toString() {
        return "ApplicationMain{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", emprEmail='" + empEmail + '\'' +
                ", empDept='" + empDept + '\'' +
                ", empDob=" + empDob +
                '}';
    }
}
