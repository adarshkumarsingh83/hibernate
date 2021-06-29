package com.adarsh.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/11/12
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Project {

    private Integer projectId;
    private String projectName;
    private String client;
    private Set<Employee> employees=new HashSet<Employee>(0);

    public Project() {
    }

    public Project( String projectName, String client) {
        this.projectName = projectName;
        this.client = client;
    }

    public Project(Integer projectId, String projectName, String client) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employee) {
        this.employees.add(employee);
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
