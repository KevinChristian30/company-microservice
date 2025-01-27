package com.kevinchristian.department_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinchristian.department_service.dtos.request.DepartmentCreateRequestDTO;
import com.kevinchristian.department_service.dtos.response.DepartmentResponseDTO;
import com.kevinchristian.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Void> createDepartment(@RequestBody DepartmentCreateRequestDTO dto) {
        departmentService.createDepartment(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentResponseDTO> getDepartment(@PathVariable("code") String code) {
        return ResponseEntity.ok(departmentService.findDepartmentByCode(code));
    }
}
