package com.adarsh.hibernate.bean;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/12/12
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class EmployeeProjectId implements java.io.Serializable {

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Project project;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeProjectId that = (EmployeeProjectId) o;

        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (project != null ? !project.equals(that.project) : that.project != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }
}
