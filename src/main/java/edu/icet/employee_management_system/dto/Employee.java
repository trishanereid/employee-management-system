package edu.icet.employee_management_system.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String departmentId;
    private String roleId;
}