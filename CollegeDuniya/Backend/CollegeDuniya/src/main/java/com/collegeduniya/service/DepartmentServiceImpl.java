package com.collegeduniya.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.DepartmentDto;
import com.collegeduniya.entities.Department;
import com.collegeduniya.repository.CourseRepository;
import com.collegeduniya.repository.DepartmentRepository;
import com.collegeduniya.repository.ExamRepository;
import com.collegeduniya.repository.ProfessorRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ProfessorRepository professorRepo;
	
	@Autowired
	private ExamRepository examRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public String addDepartment(DepartmentDto departmentDto) {
		Department department = mapper.map(departmentDto, Department.class);
		departmentRepo.save(department);
		return null;
	}
	
	@Override
	public DepartmentDto getDepartmentById(Long id) {
		Department department = departmentRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		DepartmentDto dept = mapper.map(department, DepartmentDto.class);
		return dept;
	}
	
	@Override
	public List<DepartmentDto> getAllDepartments() {
		List<Department> departmentList = departmentRepo.findAll();
		return departmentList.stream().map(department -> mapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
	}
	
	@Override
	public String deleteDepartment(Long id) {
		Department department = departmentRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		departmentRepo.delete(department);
		return department.getDepartmentName()+" deleted";
	}

}
