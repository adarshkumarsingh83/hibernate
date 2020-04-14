package com.adarsh.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "Employee", catalog = "hibernate", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Emp_Email"),
        @UniqueConstraint(columnNames = "Emp_Name")})
public class Employee implements Serializable, Cloneable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name ="Emp_Id", unique = true, nullable = false)
    private Integer empId;

    @Column(name = "Emp_Name", unique = true, nullable = false, length = 10)
    private String empName;

    @Column(name = "Emp_Email", unique = true, nullable = false, length = 10)
    private String empEmail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.Employee", cascade = CascadeType.ALL)
    private Set<EmployeeProject> employeeProject = new HashSet<EmployeeProject>(0);


    static {
        System.out.println("Static block of the employee");
    }

    public Employee() {
        System.out.println("Employee Constructor");
    }

    public Employee(String empName, String empEmail) {
        this.empName = empName;
        this.empEmail = empEmail;
    }

    public Employee(Integer empId, String empName, String empEmail) {
        this.empId = empId;
        this.empName = empName;
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

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }


    public Set<EmployeeProject> getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProject employeeProject) {
        this.employeeProject.add(employeeProject);
    }

    public void setEmployeeProject(Set<EmployeeProject> employeeProject) {
        this.employeeProject = employeeProject;
    }
}
