package com.collegeduniya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegeduniya.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Optional<Department> findByDepartmentName(String departmentName);
}
