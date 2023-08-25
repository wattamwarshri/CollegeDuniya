package com.collegeduniya.controller;

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
import com.collegeduniya.dto.DepartmentDto;
import com.collegeduniya.service.DepartmentService;                                                                                                                                                                                                                          

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<?> addNewDepartment(@RequestBody DepartmentDto departmentDto){
		try {
			System.out.println("in add department "+departmentDto);
			return new ResponseEntity<>(new ApiResponse(departmentService.addDepartment(departmentDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
		try {
			System.out.println("in get department by id ");
			return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/ListOfDepartments")
	public ResponseEntity<?> getAllAvailableDepartments() {
		try {
			System.out.println("in get all available Departments ");
			return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id){
		try {
			System.out.println("in delete department by id ");
			return new ResponseEntity<>(departmentService.deleteDepartment(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("/updateDepartment/{id}")
	public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDto dept, @PathVariable Long id) {
		try {
			System.out.println("in update department by id");
			return new ResponseEntity<>( departmentService.updateDepartmentDetails(dept, id),HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@DeleteMapping("/{deptId}/deleteCourse/{courseId}")
	public ResponseEntity<?> deletecourseFromDepartment(@PathVariable Long deptId,@PathVariable Long courseId){
		try {
			return new ResponseEntity<>(departmentService.cancelCourseFromDepartment(deptId,courseId),HttpStatus.OK);
		}catch(RuntimeException e){
			return new ResponseEntity<>(new ApiResponse(e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
}
