package com.bladir.database_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bladir.entity.Role;
import com.bladir.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser() {
		Role role = new Role("patient");
		User user = new User("jerry", "123456", role, "jerry", "pan", "male", "123@gmail.com");
		System.out.println("on saving");
		if(userRepository.save(user) == null) {
			System.out.println("no insert");
		} else {
			System.out.println("insert success");
		}
	}
	
}
