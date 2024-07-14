package edu.icet.employee_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String departmentId;
    private String roleId;
}