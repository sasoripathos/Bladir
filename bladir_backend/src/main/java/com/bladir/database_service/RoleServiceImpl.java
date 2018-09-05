package com.bladir.database_service;

import com.bladir.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public Role getRoleByName(String name) {
		Role role = null;
		try {
			role = roleRepository.findByRoleName(name);
		} catch (Exception ex){
			System.err.println("Can't find role");
		}
		return role;
	}

	@Autowired
	private RoleRepository roleRepository;
}
