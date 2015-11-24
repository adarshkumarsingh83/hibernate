package com.adarsh.manager.impl;

import com.adarsh.domain.Employee;
import com.adarsh.hibernate.HibernateUtil;
import com.adarsh.manager.EmployeeManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/6/12 9:35 AM#$
 */
public class EmployeeManagerImpl implements EmployeeManager {


    public Integer insertEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        return null;
    }


    public Integer updateEmployee(Employee employee) {
        final String hqlQuery = "UPDATE Employee set empEmail = :empEmail ,empDept = :empDept WHERE empId = :empId ";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hqlQuery);
        query.setParameter("empEmail", employee.getEmpEmail());
        query.setParameter("empDept", employee.getEmpDept());
        query.setParameter("empId", employee.getEmpId());
        Integer result = query.executeUpdate();
        transaction.commit();
        return result;
    }


    public Integer deleteEmployee(Employee employee) {
        final String hqlQuery = "DELETE FROM Employee WHERE empId = :empId";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hqlQuery);
        query.setParameter("empId", employee.getEmpId());
        Integer result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public Employee selectEmployee(Integer employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        final String hqlQuery = "SELECT E FROM Employee AS E  WHERE E.empId = :empId ";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("empId", employee);
        List<Employee> list = query.list();
        return (list.size() > 0) ? (Employee) list.get(0) : null;
    }

    public List<Object[]> selectEmployee(Employee employeeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hqlQuery = "SELECT E.empId,E.empName,E.empEmail,E.empDept FROM Employee AS E";
        Query query = session.createQuery(hqlQuery);
        return query.list();

    }

    public List<Employee> selectAllEmployee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hqlQuery = "SELECT E FROM Employee AS E ";
        Query query = session.createQuery(hqlQuery);
        return query.list();
    }
}
