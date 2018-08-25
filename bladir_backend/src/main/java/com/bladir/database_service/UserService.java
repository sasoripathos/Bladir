package com.bladir.database_service;

import java.util.Optional;

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
	
	public void queryUser() {
		Optional<User> a = userRepository.findById(1);
		if(a.isPresent()) {
			System.out.println(a.get().toString());
		} else {
			System.out.println("None");
		}
		
		a = userRepository.findById(2);
		if(a.isPresent()) {
			System.out.println(a.get().toString());
		} else {
			System.out.println("None");
		}
	}
	
}
