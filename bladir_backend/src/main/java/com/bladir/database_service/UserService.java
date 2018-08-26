package com.bladir.database_service;

import com.bladir.entity.User;

public interface UserService {
	public int addDoctor(User doctor);
	public int addPatient(User patient);
	public int addAnalyst(User analyst);
	public boolean authentication(String username, String passward, String role);
	public User findUserByUsername(String username);
}
