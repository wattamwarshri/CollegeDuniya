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
import com.collegeduniya.dto.LoginDto;
import com.collegeduniya.dto.UserDto;
import com.collegeduniya.service.UserService;

@CrossOrigin()
@RestController
@RequestMapping("/users")
public class UserController {  
	
	@Autowired
	private UserService userService;
	//For Testing Purpose
	@PostMapping("/register")
	public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
		try {
			System.out.println("in add new user" + userDto);
			return new ResponseEntity<>(new ApiResponse(userService.signUp(userDto)),HttpStatus.CREATED);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
  
}