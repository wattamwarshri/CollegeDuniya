package com.collegeduniya.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String contact;
}
