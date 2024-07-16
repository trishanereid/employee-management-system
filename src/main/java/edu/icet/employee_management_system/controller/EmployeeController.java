package edu.icet.employee_management_system.controller;

import edu.icet.employee_management_system.bo.EmployeeBo;
import edu.icet.employee_management_system.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v4")
public class EmployeeController {
    final EmployeeBo employeeBo;

    @PostMapping("/add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        employeeBo.addEmployee(employee);
    }

    @GetMapping("/get-all")
    public List<Employee> getAll(){
        return employeeBo.getAll();
    }

    @DeleteMapping("/delete-employee/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id){
        employeeBo.deleteEmployeeById(id);
        return "Deleted";
    }

}
