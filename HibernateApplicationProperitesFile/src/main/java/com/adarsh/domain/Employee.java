package com.adarsh.domain;

import java.io.Serializable;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/4/12 9:42 AM#$
 */
public class Employee implements Serializable{

    private Integer empId;
    private String empName;
    private String empEmail;
    private String empDept;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empEmail, String empDept) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empDept = empDept;
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

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }
}
