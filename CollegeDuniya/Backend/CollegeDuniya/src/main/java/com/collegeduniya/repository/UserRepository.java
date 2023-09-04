package com.collegeduniya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.collegeduniya.entities.Subject;
import com.collegeduniya.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsernameAndPassword(String userName, String password);

	Optional<User> findByUsername(String username);

}
