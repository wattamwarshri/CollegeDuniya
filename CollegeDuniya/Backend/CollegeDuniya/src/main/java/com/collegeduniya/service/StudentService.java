package com.collegeduniya.service;

import com.collegeduniya.dto.StudentDto;

public interface StudentService {
	String addStudent(StudentDto studentDto);
	StudentDto getStudentById(Long id);
}
