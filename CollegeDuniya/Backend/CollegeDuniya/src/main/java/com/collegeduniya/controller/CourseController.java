package com.collegeduniya.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeduniya.dto.ApiResponse;
import com.collegeduniya.dto.CourseDto;
import com.collegeduniya.service.CourseService;


@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> addNewCourse(@RequestBody CourseDto courseDto){
		try {
			System.out.println("in add new course "+courseDto);
			return new ResponseEntity<>(new ApiResponse(courseService.addCourse(courseDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/singleCourse/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Long id) {
		try {
			System.out.println("in get course by id ");
			return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
}
