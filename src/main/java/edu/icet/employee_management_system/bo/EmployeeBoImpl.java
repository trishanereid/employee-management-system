package edu.icet.employee_management_system.bo;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.employee_management_system.dto.Employee;
import edu.icet.employee_management_system.entity.EmployeeEntity;
import edu.icet.employee_management_system.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteEmployeeById(Long id) {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()){
            employeeRepository.save(
                    mapper.convertValue(employee, EmployeeEntity.class)
            );
        }
    }

    @Override
    public Employee findById(Long id) {
        if (employeeRepository.findById(id).isPresent()){
            Optional<Employee> byId = employeeRepository.findById(id);
            return mapper.convertValue(byId, Employee.class);
        }
        return new Employee();
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return mapper.convertValue(
                employeeRepository.findByFirstname(firstName), Employee.class
        );
    }
}
