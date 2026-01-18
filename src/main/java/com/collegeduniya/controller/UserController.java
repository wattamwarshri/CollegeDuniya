package com.collegeduniya.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeduniya.dto.ApiResponse;
import com.collegeduniya.dto.LoginDto;
import com.collegeduniya.dto.UserDto;
import com.collegeduniya.service.UserService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
		try {
			logger.info("In add new user: {}", userDto);
			return new ResponseEntity<>(new ApiResponse(userService.signUp(userDto)),HttpStatus.CREATED);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	 @PostMapping("/login")
	   public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		    try {
			logger.info("In login by username and password");
			if(userService.login(loginDto.getUsername(), loginDto.getPassword())!=null) {
				return new ResponseEntity<>(userService.login(loginDto.getUsername(), loginDto.getPassword()),HttpStatus.OK);
				
			}
			else {
			//return new ResponseEntity<>(userService.login(username,password),HttpStatus.OK);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("unable to find the user"));
			}
		}
	 	catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		

	}


}