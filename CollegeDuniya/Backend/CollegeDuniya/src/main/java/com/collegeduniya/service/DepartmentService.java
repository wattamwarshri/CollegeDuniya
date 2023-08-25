package com.collegeduniya.service;

import java.util.List;

import com.collegeduniya.dto.DepartmentDto;

public interface DepartmentService {
	String addDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentById(Long id);
	List<DepartmentDto> getAllDepartments();
	String deleteDepartment(Long id);
	String updateDepartmentDetails(DepartmentDto departmentDto,Long id);
}
