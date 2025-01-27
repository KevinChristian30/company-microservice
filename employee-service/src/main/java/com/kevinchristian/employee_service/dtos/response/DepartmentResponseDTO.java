package com.kevinchristian.employee_service.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DepartmentResponseDTO {
    private String name;
    private String description;
    private String code;
}
