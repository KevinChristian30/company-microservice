package com.kevinchristian.employee_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinchristian.employee_service.dtos.request.EmployeeCreateRequestDTO;
import com.kevinchristian.employee_service.dtos.response.EmployeeResponseDTO;
import com.kevinchristian.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Void> createEmployee(@RequestBody EmployeeCreateRequestDTO employeeCreateRequestDTO) {
        employeeService.createEmployee(employeeCreateRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponseDTO> findEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }
}
