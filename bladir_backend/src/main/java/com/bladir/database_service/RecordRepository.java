package com.bladir.database_service;

import java.util.Date;
import java.util.List;

import com.bladir.entity.Standard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bladir.entity.Record;
import com.bladir.entity.Test;
import com.bladir.entity.User;

@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
	//public List<Test> findAllByUserAndDate(User user, Date date);
    public Record findRecordByTestAndStandard(Test test, Standard standard);
}
