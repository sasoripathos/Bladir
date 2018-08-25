package com.bladir.database_service;

import org.springframework.data.repository.CrudRepository;

import com.bladir.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
