package edu.icet.employee_management_system.bo;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.employee_management_system.dto.Employee;
import edu.icet.employee_management_system.entity.EmployeeEntity;
import edu.icet.employee_management_system.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeBoImpl implements EmployeeBo{
    final EmployeeRepository employeeRepository;
    final ObjectMapper mapper;

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class);
        employeeRepository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
