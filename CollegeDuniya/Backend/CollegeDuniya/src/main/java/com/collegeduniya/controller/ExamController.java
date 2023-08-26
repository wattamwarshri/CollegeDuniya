package com.collegeduniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeduniya.dto.ApiResponse;
import com.collegeduniya.dto.ExamDto;
import com.collegeduniya.service.ExamService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

	@Autowired
	private ExamService examService; 	
	
	@PostMapping
	public ResponseEntity<?> addExam(@RequestBody ExamDto examDto){
	          
//		SubjectDto createdSubjectDto =  this.subjectService.addSubject(subjectDto, professorId);
//		return  new ResponseEntity<SubjectDto>(createdSubjectDto,HttpStatus.CREATED);
		try {
			System.out.println("in add new exam" + examDto);
			return new ResponseEntity<>(new ApiResponse(examService.addExam(examDto)),HttpStatus.CREATED);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
}