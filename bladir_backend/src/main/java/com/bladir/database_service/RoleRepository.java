package com.bladir.database_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bladir.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
    public Role findByRoleName(String roleName);
}
