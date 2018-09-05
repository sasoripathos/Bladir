package com.bladir.database_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bladir.entity.User;
import com.bladir.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public int addDoctor(User doctor) {
		try {
			userRepository.save(doctor);
		} catch (Exception ex){
			System.err.println("Can't save doctor");
		}
		return doctor.getId();
	}

	@Override
	public int addPatient(User patient) {
		try {
			userRepository.save(patient);
		} catch (Exception ex){
			System.err.println("Can't save patient");
		}
		return patient.getId();
	}

	@Override
	public int addAnalyst(User analyst) {
		try {
			userRepository.save(analyst);
		} catch (Exception ex){
			System.err.println("Can't save analyst");
		}
		return analyst.getId();
	}

	/*@Override
	public boolean authentication(String username, String passward, String role) {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public User findUserByUsername(String username) throws UserNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw(new UserNotFoundException("Invalid Username: " + username));
		} else {
			return user;
		}
	}
	
	/*public void createUser() {
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
	}*/
	
}
