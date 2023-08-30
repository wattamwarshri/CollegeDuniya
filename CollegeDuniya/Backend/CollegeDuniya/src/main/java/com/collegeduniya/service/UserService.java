package com.collegeduniya.service;

import com.collegeduniya.dto.UserDto;

public interface UserService {

    String signUp(UserDto userDto);
	
	String login(String username, String password);
}
