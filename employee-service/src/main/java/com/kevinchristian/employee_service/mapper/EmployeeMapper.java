package com.kevinchristian.employee_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kevinchristian.employee_service.dtos.request.EmployeeCreateRequestDTO;
import com.kevinchristian.employee_service.dtos.response.EmployeeResponseDTO;
import com.kevinchristian.employee_service.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", ignore = true)
    Employee employeeCreateRequestDTOToEmployee(EmployeeCreateRequestDTO dto);

    EmployeeResponseDTO employeeToEmployeeResponseDTO(Employee employee);
}
