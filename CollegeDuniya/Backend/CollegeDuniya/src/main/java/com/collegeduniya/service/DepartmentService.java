package com.collegeduniya.service;

import com.collegeduniya.dto.DepartmentDto;

public interface DepartmentService {
	String addDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentById(Long id);
}
