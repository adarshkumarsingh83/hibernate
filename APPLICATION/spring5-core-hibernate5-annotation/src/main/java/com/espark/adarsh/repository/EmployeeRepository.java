package com.espark.adarsh.repository;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    static Map<Integer, Employee> employeeStore = new HashMap<>();

    @PostConstruct
    void init() {
        Employee employee1 = new Employee();
        employee1.setId(100);
        employee1.setName("adarsh kumar");
        employee1.setEmail("adarsh@kumar");
        employeeStore.put(employee1.getId(), employee1);
        Employee employee2 = new Employee();
        employee2.setId(200);
        employee2.setName("radha singh");
        employee2.setEmail("radha@singh");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(employee1);
            session.save(employee2);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employee saveEmployee(Employee employee) throws ApplicationException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Integer id = (Integer) session.save(employee);
            employee = session.get(Employee.class, id);
            return employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ApplicationException(e.getMessage());
        }
    }


    public Employee updateEmployee(Employee employee) throws ApplicationException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.update(employee);
            employee = session.get(Employee.class, employee.getId());
            return employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ApplicationException(e.getMessage());
        }
    }

    public Employee getEmployee(Integer employeeId) throws ApplicationException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            return employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ApplicationException(e.getMessage());
        }
    }

    public Employee deleteEmployee(Integer employeeId) throws ApplicationException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            session.delete(employee);
            return employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ApplicationException(e.getMessage());
        }
    }

    public List<Employee> getEmployees() throws ApplicationException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
            return employees;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ApplicationException(e.getMessage());
        }
    }
}

