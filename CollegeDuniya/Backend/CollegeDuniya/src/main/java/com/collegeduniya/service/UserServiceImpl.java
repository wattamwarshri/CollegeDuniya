package com.collegeduniya.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.UserDto;
import com.collegeduniya.entities.User;
import com.collegeduniya.repository.UserRepository;

@Service
@Controller
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String signUp(UserDto userDto) {
		User persistentUser = modelMapper.map(userDto,User.class);
		userRepo.save(persistentUser);			
		return persistentUser.getUsername()+" user added successfully";
	}
	
	
	@Override
	public String login(String username,String password) {

		User dbuser = userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user was not found"));
		if(password.equals(dbuser.getPassword()))
		{
			UserDto userDto = modelMapper.map(dbuser,UserDto.class);
			return userDto.getUsername()+" loggoed in successfully";
		}
		else
		{
			return "Invalid credential";
		}
	}
}
