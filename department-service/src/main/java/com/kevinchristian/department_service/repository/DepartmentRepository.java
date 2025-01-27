package com.kevinchristian.department_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevinchristian.department_service.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Optional<Department> findByCode(String code);
}
