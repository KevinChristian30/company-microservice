package com.kevinchristian.department_service.dtos.request;

public record DepartmentCreateRequestDTO(
        String code,
        String name,
        String description) {
}
