package com.kevinchristian.employee_service.service;

import com.kevinchristian.employee_service.dtos.request.EmployeeCreateRequestDTO;
import com.kevinchristian.employee_service.dtos.response.EmployeeResponseDTO;

public interface EmployeeService {
    public void createEmployee(EmployeeCreateRequestDTO employeeCreateRequestDTO);

    public EmployeeResponseDTO findEmployeeById(Long id);
}
