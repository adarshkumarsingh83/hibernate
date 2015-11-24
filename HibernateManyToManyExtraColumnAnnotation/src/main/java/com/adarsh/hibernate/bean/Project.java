package com.adarsh.hibernate.bean;

import com.mkyong.stock.StockCategory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/11/12
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "Project", catalog = "hibernate")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Project_Id", unique = true, nullable = false)
    private Integer projectId;

    @Column(name = "Project_Name", nullable = false, length = 10)
    private String projectName;

    @Column(name = "Project_Client", nullable = false, length = 10)
    private String projectClient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.Project")
    private Set<EmployeeProject> employeeProject = new HashSet<EmployeeProject>(0);

    public Project() {
    }

    public Project(String projectName, String projectClient) {
        this.projectName = projectName;
        this.projectClient = projectClient;
    }

    public Project(Integer projectId, String projectName, String projectClient) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectClient = projectClient;
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

    public String getProjectClient() {
        return projectClient;
    }

    public void setProjectClient(String projectClient) {
        this.projectClient = projectClient;
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
