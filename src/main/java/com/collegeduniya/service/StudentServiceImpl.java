package com.collegeduniya.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.StudentDto;
import com.collegeduniya.entities.Course;
import com.collegeduniya.entities.Professor;
import com.collegeduniya.entities.Student;
import com.collegeduniya.repository.CourseRepository;
import com.collegeduniya.repository.ProfessorRepository;
import com.collegeduniya.repository.StudentRepository;

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
	
	@Override
	public StudentDto getStudentById(Long id) {
		Student student = studentRepo.findById(id).orElseThrow(() 
						-> new ResourceNotFoundException("Invalid id"));
		StudentDto stud = mapper.map(student, StudentDto.class);
		stud.setCourseName(student.getCourse().getCourseName());
		stud.setProfessorName(student.getProfessor().getFirstName()+" "+student.getProfessor().getLastName());
		return stud;
	}
	
	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> studentList = studentRepo.findAll();
		List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
		for (Student student : studentList) {
			StudentDto studentDto = mapper.map(student,StudentDto.class);
			studentDto.setCourseName(student.getCourse().getCourseName());
			studentDto.setProfessorName(student.getProfessor().getFirstName());
			studentDtoList.add(studentDto);
		}
		return studentDtoList;
	}
	
	@Override
	public String updateStudent(StudentDto studentDto,Long id) {
		Student student = studentRepo.findById(id).orElseThrow(() 
					-> new ResourceNotFoundException("Invalid id"));
		Professor professor = professorRepo.findByFirstName(studentDto.getProfessorName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Professor Name!!!"));
		Course course = courseRepo.findByCourseName(studentDto.getCourseName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Course Name !!!"));
		student.setProfessor(professor);
		student.setCourse(course);
		mapper.map(studentDto, student);
		
		return student.getFirstName()+" successfully updated";
	}
	
	@Override
	public String deleteStudentById(Long id) {
		Student s = studentRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		List<Student> list = studentRepo.findAll();
		list.remove(s);
		studentRepo.delete(s);
		studentRepo.saveAll(list);
		return s.getFirstName()+" was removed";
	}	

}
