package edu.icet.employee_management_system.repository;

import edu.icet.employee_management_system.dto.Employee;
import edu.icet.employee_management_system.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void save(EmployeeEntity employeeEntity);

    Employee findByFirstname(String firstName);
}
