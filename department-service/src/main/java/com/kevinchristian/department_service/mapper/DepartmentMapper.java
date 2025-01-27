package com.kevinchristian.department_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kevinchristian.department_service.dtos.request.DepartmentCreateRequestDTO;
import com.kevinchristian.department_service.dtos.response.DepartmentResponseDTO;
import com.kevinchristian.department_service.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(target = "id", ignore = true)
    Department departmentCreateRequestDTOToDepartment(DepartmentCreateRequestDTO dto);
    
    DepartmentResponseDTO departmentToDepartmentResponseDTO(Department department);
}
