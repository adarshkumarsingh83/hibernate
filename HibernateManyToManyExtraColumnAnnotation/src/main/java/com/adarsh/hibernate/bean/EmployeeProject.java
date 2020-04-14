package com.adarsh.hibernate.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/12/12
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "" +
        "Employee_Project", catalog = "hibernate")
@AssociationOverrides({
        @AssociationOverride(name = "pk.Employee", joinColumns = @JoinColumn(name = "Emp_Id")),
        @AssociationOverride(name = "pk.Project", joinColumns = @JoinColumn(name = "Project_Id"))})

public class EmployeeProject implements java.io.Serializable {

    @EmbeddedId
    private EmployeeProjectId employeeProjectId=new EmployeeProjectId();

    public EmployeeProjectId getEmployeeProjectId() {
        return employeeProjectId;
    }

    public void setEmployeeProjectId(EmployeeProjectId employeeProjectId) {
        this.employeeProjectId = employeeProjectId;
    }

    @Transient
    public Employee getEmployee() {
        return getEmployeeProjectId().getEmployee();
    }

    public void setEmployee(Employee employee) {
        this.getEmployeeProjectId().setEmployee(employee);
    }

    @Transient
    public Project getProject() {
        return getEmployeeProjectId().getProject();
    }

    public void setProject(Project project) {
        this.getEmployeeProjectId().setProject(project);
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "Created_Date", nullable = false, length = 10)
    private Date createdDate;

    @Column(name = "Created_By", nullable = false, length = 10)
    private String createdBy;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }



    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EmployeeProject that = (EmployeeProject) o;

        if (getEmployeeProjectId() != null ? !getEmployeeProjectId().equals(that.getEmployeeProjectId())
                : that.getEmployeeProjectId() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getEmployeeProjectId() != null ? getEmployeeProjectId().hashCode() : 0);
    }
}
