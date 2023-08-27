package com.collegeduniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeduniya.dto.ApiResponse;
import com.collegeduniya.dto.StudentDto;
import com.collegeduniya.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> addNewStudent(@RequestBody StudentDto studentDto) {
		try {
			System.out.println("in add student "+ studentDto);
			return new ResponseEntity<>(new ApiResponse(studentService.addStudent(studentDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
}
