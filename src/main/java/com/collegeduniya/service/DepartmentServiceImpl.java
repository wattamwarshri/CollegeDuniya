package com.collegeduniya.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.DepartmentDto;
import com.collegeduniya.entities.Course;
import com.collegeduniya.entities.Department;
import com.collegeduniya.entities.Exam;
import com.collegeduniya.entities.Professor;
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
	
	@Override
	public String updateDepartmentDetails(DepartmentDto departmentDto, Long id) {
		Department department = departmentRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));	
		mapper.map(departmentDto, department);
	
		return department.getDepartmentName()+" successfully updated";
	}
	
	@Override
	public String cancelCourseFromDepartment(Long deptId, Long courseId) {
		
		Department department = departmentRepo.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Invalid department ID!!!!!"));
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Invalid  course ID!!!!!"));
		department.removeCourse(course);
		return "Deleted course : " + course.getCourseName();
	}

	@Override
	public String cancelProfessorFromDepartment(Long deptId, Long professorId) {
		Department department = departmentRepo.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Invalid Department ID!!!!!"));
		Professor professor = professorRepo.findById(professorId).orElseThrow(() -> new ResourceNotFoundException("Invalid Professor ID!!!!!"));
		department.removeProfessor(professor);
		return "Deleted professor : " + professor.getFirstName()+" "+professor.getLastName();
	}
	
	@Override
	public String cancelExamFromDepartment(Long deptId, Long examId) {
		Department department = departmentRepo.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Invalid Department ID!!!!!"));
		Exam exam = examRepo.findById(examId).orElseThrow(() -> new ResourceNotFoundException("Invalid Exam ID!!!!!"));
		department.removeExam(exam);
		return "Deleted Exam Id : " + exam.getExamId();
	}

}
