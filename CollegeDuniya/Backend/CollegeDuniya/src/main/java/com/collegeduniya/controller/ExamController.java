package com.collegeduniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/updateExam/{examId}")
	public String updateExam(@RequestBody ExamDto examDto ,@PathVariable Long examId)
	{
//		SubjectDto updateSubject = this.subjectService.updateSubject(subjectDto,subjectId);
//		return new ResponseEntity<SubjectDto>(updateSubject, HttpStatus.OK);
		
		return examService.updateExamDetails(examDto, examId);
	}
	
	@DeleteMapping("/deleteSingleExam/{examId}")
	public ResponseEntity<?> deleteSubjectById(@PathVariable Long examId )
	{
//		this.subjectService.deleteSubject(subjectId);
//	    return new ApiResponse("Subject is successfully deleted");
		try {
			System.out.println("in delete Subject by id");
			return new ResponseEntity<>(examService.deleteExamById(examId),HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
}