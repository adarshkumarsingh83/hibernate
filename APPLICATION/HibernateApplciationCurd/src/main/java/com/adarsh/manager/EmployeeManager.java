package com.adarsh.manager;

import com.adarsh.domain.Employee;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 6/6/12 9:34 AM#$
 */
public interface EmployeeManager {

    public Integer insertEmployee(Employee employee);
    public Integer updateEmployee(Employee employee);
    public Integer deleteEmployee(Employee employee);
    public Employee selectEmployee(Integer employeeId);
}
