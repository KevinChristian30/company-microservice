package com.kevinchristian.department_service.service;

import com.kevinchristian.department_service.dtos.request.DepartmentCreateRequestDTO;
import com.kevinchristian.department_service.dtos.response.DepartmentResponseDTO;

public interface DepartmentService {
    public void createDepartment(DepartmentCreateRequestDTO dto);

    public DepartmentResponseDTO findDepartmentByCode(String code);
}
