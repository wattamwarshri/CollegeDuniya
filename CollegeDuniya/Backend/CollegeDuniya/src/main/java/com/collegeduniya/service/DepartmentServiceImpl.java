package com.collegeduniya.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
