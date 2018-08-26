package com.bladir.database_service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bladir.entity.Result;
import com.bladir.entity.User;

public interface ResultRepository extends CrudRepository<Result, Integer> {
	public List<Result> findAllByUserAndDate(User user, Date date);
}
