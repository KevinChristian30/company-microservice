package com.kevinchristian.employee_service.dtos.request;

public record EmployeeCreateRequestDTO(
                String email,
                String firstName,
                String lastName,
                String departmentCode) {
}
