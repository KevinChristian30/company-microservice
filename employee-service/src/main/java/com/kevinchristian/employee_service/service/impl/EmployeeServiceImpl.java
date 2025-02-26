package com.kevinchristian.employee_service.service.impl;

import java.util.Optional;

import com.kevinchristian.employee_service.service.APIClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kevinchristian.employee_service.dtos.request.EmployeeCreateRequestDTO;
import com.kevinchristian.employee_service.dtos.response.DepartmentResponseDTO;
import com.kevinchristian.employee_service.dtos.response.EmployeeResponseDTO;
import com.kevinchristian.employee_service.entity.Employee;
import com.kevinchristian.employee_service.mapper.EmployeeMapper;
import com.kevinchristian.employee_service.repository.EmployeeRepository;
import com.kevinchristian.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private APIClient apiClient;

    @Override
    public void createEmployee(EmployeeCreateRequestDTO employeeCreateRequestDTO) {
        DepartmentResponseDTO departmentResponseDTO = apiClient.getDepartment(employeeCreateRequestDTO.departmentCode());

        if (departmentResponseDTO == null) {
            throw new RuntimeException();
        }

        Employee employee = EmployeeMapper.INSTANCE.employeeCreateRequestDTOToEmployee(employeeCreateRequestDTO);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeResponseDTO findEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = employeeOptional.orElseThrow();

        DepartmentResponseDTO departmentResponseDTO = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeResponseDTO dto = EmployeeMapper.INSTANCE.employeeToEmployeeResponseDTO(employee);
        dto.setDepartmentResponseDTO(departmentResponseDTO);

        return dto;
    }
}
