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
import com.collegeduniya.dto.ProfessorDto;
import com.collegeduniya.service.ProfessorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/professors")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	public ResponseEntity<?> addNewProfessor(@RequestBody ProfessorDto professorDto){
		try {
			System.out.println("in add new Professor "+ professorDto);
			return new ResponseEntity<>(new ApiResponse(professorService.addProfessor(professorDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
}
