package com.kevinchristian.employee_service.service;

import com.kevinchristian.employee_service.dtos.response.DepartmentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/v1/departments/{code}")
    DepartmentResponseDTO getDepartment(@PathVariable("code") String code);
}
