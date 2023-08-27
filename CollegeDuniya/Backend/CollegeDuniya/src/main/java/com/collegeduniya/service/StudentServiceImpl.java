package com.collegeduniya.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.StudentDto;
import com.collegeduniya.entities.Course;
import com.collegeduniya.entities.Professor;
import com.collegeduniya.entities.Student;
import com.collegeduniya.repository.CourseRepository;
import com.collegeduniya.repository.ProfessorRepository;
import com.collegeduniya.repository.StudentRepository;

@CrossOrigin
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository  courseRepo;
	
	@Autowired
	private ProfessorRepository  professorRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addStudent(StudentDto studentDto) {
		
		Course course = courseRepo.findByCourseName(studentDto.getCourseName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Course Name !!!"));
		
		Professor professor = professorRepo.findByFirstName(studentDto.getProfessorName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Professor Name!!!"));
		
		Student student = mapper.map(studentDto, Student.class);	
		Student persistentStudent =  studentRepo.save(student);
		course.addStudent(persistentStudent);
		professor.addStudent(persistentStudent);
		return persistentStudent.getFirstName() + " Student added successfully";
	}
	
}
