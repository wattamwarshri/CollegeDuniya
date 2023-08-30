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

    private Long userId;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String role;
	
	private String address;
	
	private String contact;
}
