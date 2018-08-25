package com.bladir.database_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bladir.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
