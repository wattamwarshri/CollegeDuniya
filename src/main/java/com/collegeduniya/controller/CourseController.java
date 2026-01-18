package com.collegeduniya.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeduniya.dto.ApiResponse;
import com.collegeduniya.dto.CourseDto;
import com.collegeduniya.service.CourseService;


@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> addNewCourse(@RequestBody CourseDto courseDto){
		try {
            logger.info("in add new course {}", courseDto);
			return new ResponseEntity<>(new ApiResponse(courseService.addCourse(courseDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/singleCourse/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Long id) {
		try {
			logger.info("In get course by id {} ", id);
			return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/department_Name/{departmentName}")
	public ResponseEntity<?> getAllCourseByDepartmentName(@PathVariable String departmentName) {
		try {

			logger.info("In get courses by departmentName: {}", departmentName);
			return new ResponseEntity<>(courseService.getAllCoursesByDepartmentName(departmentName), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}
	

	@GetMapping("/ListOfCourses")
	public ResponseEntity<?> getAllAvailableCourses() {
		try {
			logger.info("In get all available courses ");
			return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}
	
	@PutMapping("/updateCourse/{id}")
	public  ResponseEntity<?>updateCourse(@RequestBody CourseDto course, @PathVariable Long id) {
		try {
			logger.info("In get course by id: {}", id);
			return new ResponseEntity<>( courseService.updateCourseDetails(course, id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@DeleteMapping("/{courseId}/student/{studentId}")
	public ResponseEntity<?> deleteStudentFromCourse(@PathVariable Long courseId,@PathVariable Long studentId){
		try {
			logger.info("In delete course by id {} and student {}", courseId, studentId);
			return new ResponseEntity<>(courseService.cancelStudentFromCourse(courseId,studentId),HttpStatus.OK);
		}catch(RuntimeException e){
			return new ResponseEntity<>(new ApiResponse(e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteSingleCourse/{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable Long id){
		try {
			logger.info("In delete Course by id: {}", id);
			return new ResponseEntity<>(courseService.deleteCourseById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
}
