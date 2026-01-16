package com.collegeduniya.service;

import java.util.List;

import com.collegeduniya.dto.StudentDto;

public interface StudentService {
	String addStudent(StudentDto studentDto);
	StudentDto getStudentById(Long id);
	List<StudentDto> getAllStudents();
	String updateStudent(StudentDto studentDto,Long id);
	String deleteStudentById(Long id);
}
