package com.kevinchristian.department_service.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kevinchristian.department_service.dtos.request.DepartmentCreateRequestDTO;
import com.kevinchristian.department_service.dtos.response.DepartmentResponseDTO;
import com.kevinchristian.department_service.entity.Department;
import com.kevinchristian.department_service.mapper.DepartmentMapper;
import com.kevinchristian.department_service.repository.DepartmentRepository;
import com.kevinchristian.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    
    @Override
    public void createDepartment(DepartmentCreateRequestDTO dto) {
        Department department = DepartmentMapper.INSTANCE.departmentCreateRequestDTOToDepartment(dto);
        departmentRepository.save(department);
    }

    @Override
    public DepartmentResponseDTO findDepartmentByCode(String code) {
        Optional<Department> departmentOptional = departmentRepository.findByCode(code);
        Department department = departmentOptional.orElseThrow();
        return DepartmentMapper.INSTANCE.departmentToDepartmentResponseDTO(department);
    }
}
