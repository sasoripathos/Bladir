package com.bladir.database_service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bladir.entity.Record;
import com.bladir.entity.User;

public interface RecordRepository extends CrudRepository<Record, Integer> {
	public List<Record> findAllByUserAndDate(User user, Date date);
}
