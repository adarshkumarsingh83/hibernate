package com.adarsh.domain;

import java.io.Serializable;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/4/12 9:42 AM#$
 */
public class Employee implements Serializable {

    private Integer empId;
    private String empName;
    private String empDept;
    private String empEmail;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empDept, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
        this.empEmail = empEmail;
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

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDept='" + empDept + '\'' +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }
}
