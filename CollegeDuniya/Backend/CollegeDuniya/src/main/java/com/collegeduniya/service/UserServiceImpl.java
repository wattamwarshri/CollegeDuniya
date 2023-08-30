package com.collegeduniya.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
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
		// TODO Auto-generated method stub
		//return null;
		 // String encodedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12));
          User user = this.modelMapper.map(userDto,User.class);
		
	    //sub.setProfessor(prof);
		//return null;
        user.setPassword(userDto.getPassword());
        //user.setRole(userDto.getRole().toUpperCase());
        if(userDto.getRole().equalsIgnoreCase("ADMIN") || userDto.getRole().equalsIgnoreCase("STUDENT") || userDto.getRole().equalsIgnoreCase("PROFESSOR")) {
        	User newUser = this.userRepo.save(user);
    		return newUser.getUsername()+" user added successfully";	
        }
        else {
		//User newUser = this.userRepo.save(user);
		return "User can not be added because of incorrect role";
        }
	}
	
	
	@Override
	public String login(String username,String password) {
		// TODO Auto-generated method stub
		//return null;
		User dbuser = userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user was not found"));
		//Boolean isPasswordMatch = BCrypt.checkpw(password, dbuser.getPassword());
//		System.out.println("Checking"+password);
//		System.out.println("Checking"+dbuser.getPassword());
//		if(password.equals(dbuser.getPassword()))
//		{
//			System.out.println("We are doing right");
//			
//		}
//		else {
//			System.out.println("We are not doing the well");
//		}
		if(password.equals(dbuser.getPassword()))
		{
			UserDto userDto = modelMapper.map(dbuser,UserDto.class);
			return userDto.getRole();
		}
		else
		{
			//return modelMapper.map(isPasswordMatch, null)
			return null;
		}
	}


	
}
