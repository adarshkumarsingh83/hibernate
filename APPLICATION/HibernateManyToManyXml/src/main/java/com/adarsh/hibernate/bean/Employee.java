package com.adarsh.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

public class Employee implements Serializable, Cloneable {


    private static final long serialVersionUID = 1L;
    private Integer empId;
    private String empName;
    private String empEmail;
    private Set<Project> projects= new HashSet<Project>(0);


    static {
        out.println("Static block of the employee");
    }

    public Employee() {
        out.println("Employee Constructor");
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Project project) {
        this.projects.add(project);
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
