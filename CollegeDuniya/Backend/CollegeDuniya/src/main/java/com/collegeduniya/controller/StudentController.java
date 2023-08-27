package com.collegeduniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/singleStudent/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id) {
		try {
			System.out.println("in get student by id ");
			return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
			
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/listOfStudents")
	public ResponseEntity<?> getAllStudents() {
		try {
			System.out.println("in getAllStudents");
			return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
			} 
		catch (RuntimeException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			}
	}
	
}
