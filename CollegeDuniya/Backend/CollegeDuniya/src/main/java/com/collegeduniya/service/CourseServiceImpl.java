package com.collegeduniya.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.CourseDto;
import com.collegeduniya.entities.Course;
import com.collegeduniya.entities.Department;
import com.collegeduniya.repository.CourseRepository;
import com.collegeduniya.repository.DepartmentRepository;
import com.collegeduniya.repository.StudentRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String addCourse(CourseDto courseDto) {
		Department department = departmentRepo.findByDepartmentName(courseDto.getDepartmentName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id !!!"));
		Course course = mapper.map(courseDto, Course.class);
		Course persistentcourse = courseRepo.save(course);
		department.addCourse(persistentcourse);
		return persistentcourse.getCourseName() + " Course added successfully";
	}
	
	@Override
	public CourseDto getCourseById(Long id) {
		Course course = courseRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		CourseDto courseDto = mapper.map(course, CourseDto.class);
		courseDto.setDepartmentName(course.getDepartment().getDepartmentName());
		return courseDto;
	}

}