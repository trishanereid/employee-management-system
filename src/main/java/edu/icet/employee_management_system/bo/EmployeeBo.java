package edu.icet.employee_management_system.bo;

import edu.icet.employee_management_system.dto.Employee;

import java.util.List;

public interface EmployeeBo {

    void addEmployee(Employee employee);

    List<Employee> getAll();
}